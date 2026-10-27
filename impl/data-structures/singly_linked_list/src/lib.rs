//! A singly linked list whose nodes live in an arena: a `Vec` of nodes
//! addressed by `usize` handles instead of pointers.
//!
//! Each node owns its value, so there is no shared mutable state to fight the
//! borrow checker over. In exchange, the arena never compacts: popping leaves
//! a tombstone slot behind so the handles of live nodes stay valid, and the
//! structure trades one slot of wasted memory per removal for index-stable
//! nodes.

#[derive(Clone, Debug, Default, PartialEq)]
pub struct SinglyLinkedList<T> {
    arena: Vec<Node<T>>,
    head: Option<usize>,
    len: usize,
}

#[derive(Clone, Debug, PartialEq)]
struct Node<T> {
    value: Option<T>,
    next: Option<usize>,
}

impl<T> SinglyLinkedList<T> {
    pub fn new() -> Self {
        Self {
            arena: Vec::new(),
            head: None,
            len: 0,
        }
    }

    /// Prepends to the front. The new node points at the current head, and
    /// the head handle moves to the new node. `O(1)` time, `O(1)` arena
    /// space.
    pub fn push_front(&mut self, value: T) {
        self.arena.push(Node {
            value: Some(value),
            next: self.head,
        });
        self.head = Some(self.arena.len() - 1);
        self.len += 1;
    }

    /// Appends at the end. With no tail handle to spare, this walks the whole
    /// chain from the head: `O(n)` time, `O(1)` arena space.
    pub fn push_back(&mut self, value: T) {
        let index = {
            self.arena.push(Node {
                value: Some(value),
                next: None,
            });
            self.arena.len() - 1
        };

        match self.tail_index() {
            Some(tail) => self.arena[tail].next = Some(index),
            None => self.head = Some(index),
        }
        self.len += 1;
    }

    /// Removes the front node and returns its value, or `None` when the list
    /// is empty. The popped node's arena slot becomes a tombstone. `O(1)`.
    pub fn pop_front(&mut self) -> Option<T> {
        let head = self.head?;
        self.head = self.arena[head].next;
        self.len -= 1;
        self.arena[head].value.take()
    }

    /// Borrows the front value without removing it. `O(1)`.
    pub fn front(&self) -> Option<&T> {
        let head = self.head?;
        self.arena[head].value.as_ref()
    }

    /// Reverses the list in place by rewiring the `next` handles, using two
    /// moving handles: `current` walks forward while `previous` collects the
    /// already-reversed prefix. `O(n)` time, `O(1)` extra space.
    pub fn reverse(&mut self) {
        let mut previous: Option<usize> = None;
        let mut current = self.head;

        while let Some(index) = current {
            current = self.arena[index].next;
            self.arena[index].next = previous;
            previous = Some(index);
        }

        self.head = previous;
    }

    pub fn len(&self) -> usize {
        self.len
    }

    pub fn is_empty(&self) -> bool {
        self.head.is_none()
    }

    /// Walks the chain from the front to the end and returns the tail node.
    /// `O(n)`; the empty list has no tail.
    fn tail_index(&self) -> Option<usize> {
        let mut current = self.head;

        while let Some(index) = current {
            if self.arena[index].next.is_none() {
                return Some(index);
            }
            current = self.arena[index].next;
        }

        None
    }

    pub fn iter(&self) -> Iter<'_, T> {
        Iter {
            arena: &self.arena,
            current: self.head,
        }
    }
}

/// Forward iterator over the list values, produced by
/// [`SinglyLinkedList::iter`].
#[derive(Clone, Debug)]
pub struct Iter<'a, T> {
    arena: &'a [Node<T>],
    current: Option<usize>,
}

impl<'a, T> Iterator for Iter<'a, T> {
    type Item = &'a T;

    fn next(&mut self) -> Option<Self::Item> {
        let index = self.current?;
        let node = &self.arena[index];
        self.current = node.next;
        node.value.as_ref()
    }
}

impl<'a, T> IntoIterator for &'a SinglyLinkedList<T> {
    type Item = &'a T;
    type IntoIter = Iter<'a, T>;

    fn into_iter(self) -> Self::IntoIter {
        self.iter()
    }
}

impl<T> FromIterator<T> for SinglyLinkedList<T> {
    /// Builds the list from front-pushing followed by a single `reverse`,
    /// which keeps the whole construction `O(n)` instead of `O(n^2)`
    /// tail-walks.
    fn from_iter<I: IntoIterator<Item = T>>(values: I) -> Self {
        let mut list = Self::new();
        for value in values {
            list.push_front(value);
        }
        list.reverse();
        list
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn new_list_is_empty() {
        let list = SinglyLinkedList::<i32>::new();
        assert!(list.is_empty());
        assert_eq!(list.len(), 0);
        assert_eq!(list.front(), None);
        assert_eq!(list.iter().count(), 0);
    }

    #[test]
    fn push_front_prepends() {
        let mut list = SinglyLinkedList::new();
        list.push_front(1);
        list.push_front(7);
        list.push_front(42);

        assert_eq!(list.front(), Some(&42));
        assert_eq!(list.len(), 3);
        let items: Vec<_> = list.iter().copied().collect();
        assert_eq!(items, [42, 7, 1]);
    }

    #[test]
    fn push_back_appends() {
        let mut list = SinglyLinkedList::new();
        list.push_back(1);
        list.push_back(7);
        list.push_back(42);

        assert_eq!(list.front(), Some(&1));
        assert_eq!(list.len(), 3);
        let items: Vec<_> = list.iter().copied().collect();
        assert_eq!(items, [1, 7, 42]);
    }

    #[test]
    fn mixed_ends_and_pops() {
        let mut list = SinglyLinkedList::new();
        list.push_back(2);
        list.push_front(1);
        list.push_back(3);

        assert_eq!(list.pop_front(), Some(1));
        assert_eq!(list.pop_front(), Some(2));
        assert_eq!(list.front(), Some(&3));
        assert_eq!(list.pop_front(), Some(3));
        assert_eq!(list.pop_front(), None);
        assert_eq!(list.pop_front(), None);
        assert!(list.is_empty());
    }

    #[test]
    fn push_after_emptying_reuses_the_head() {
        let mut list = SinglyLinkedList::new();
        list.push_front(1);
        assert_eq!(list.pop_front(), Some(1));

        list.push_front(9);
        assert_eq!(list.front(), Some(&9));
        assert_eq!(list.len(), 1);
    }

    #[test]
    fn reverse_empty_and_single_lists() {
        let mut empty = SinglyLinkedList::<i32>::new();
        empty.reverse();
        assert!(empty.is_empty());

        let mut single = SinglyLinkedList::new();
        single.push_front(5);
        single.reverse();
        assert_eq!(single.front(), Some(&5));
    }

    #[test]
    fn double_reverse_restores_original_order() {
        let mut list: SinglyLinkedList<_> = [1, 2, 3, 4].into_iter().collect();
        list.reverse();
        let once: Vec<_> = list.iter().copied().collect();
        assert_eq!(once, [4, 3, 2, 1]);

        list.reverse();
        let twice: Vec<_> = list.iter().copied().collect();
        assert_eq!(twice, [1, 2, 3, 4]);
    }

    #[test]
    fn list_works_in_for_loops() {
        let list: SinglyLinkedList<_> = [1, 2, 3].into_iter().collect();
        let seen: Vec<_> = list.into_iter().copied().collect();
        assert_eq!(seen, [1, 2, 3]);
    }

    #[test]
    fn strings_drop_correctly() {
        let mut list = SinglyLinkedList::new();
        list.push_front("first".to_string());
        list.push_front("second".to_string());
        list.push_front("third".to_string());

        assert_eq!(list.pop_front(), Some("third".to_string()));
        assert_eq!(list.front(), Some(&"second".to_string()));
        assert_eq!(list.len(), 2);
    }
}
