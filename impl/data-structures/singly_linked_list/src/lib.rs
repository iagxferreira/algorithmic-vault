//! A singly linked list where every node is its own heap allocation.
//!
//! The head holds an owned pointer to the first node; each node owns the
//! next, and the last node's `next` is `None` — the Rust translation of a
//! NULL-terminated chain, since the language has no `NULL`. One consequence
//! of full ownership is that traversal and splicing work through borrows
//! rather than handles, so operations like `push_back` walk the chain one
//! node at a time with mutable borrows instead of holding integer indices.

#[derive(Debug, Default, PartialEq)]
pub struct SinglyLinkedList<T> {
    head: Option<Box<Node<T>>>,
    len: usize,
}

#[derive(Debug, PartialEq)]
struct Node<T> {
    value: T,
    next: Option<Box<Node<T>>>,
}

impl<T> SinglyLinkedList<T> {
    pub fn new() -> Self {
        Self { head: None, len: 0 }
    }

    /// Prepends to the front. The new allocation starts owning whatever the
    /// head owned, and the head moves to the new node. One allocation,
    /// `O(1)`.
    pub fn push_front(&mut self, value: T) {
        self.head = Some(Box::new(Node {
            value,
            next: self.head.take(),
        }));
        self.len += 1;
    }

    /// Appends at the end. With no tail pointer to fall back on, this walks
    /// the chain one node at a time through mutable borrows until the borrow
    /// lands on the `None` tail — then swaps the allocation in. `O(n)`.
    pub fn push_back(&mut self, value: T) {
        let mut tail = &mut self.head;

        while tail.is_some() {
            tail = &mut tail.as_mut().expect("the loop proves it").next;
        }

        *tail = Some(Box::new(Node { value, next: None }));
        self.len += 1;
    }

    /// Removes the front node and returns its value, promoting its `next`
    /// — the whole rest of the chain — to be the new head. `O(1)`.
    pub fn pop_front(&mut self) -> Option<T> {
        let front = self.head.take()?;
        self.head = front.next;
        self.len -= 1;
        Some(front.value)
    }

    /// Borrows the front value without removing it. `O(1)`.
    pub fn front(&self) -> Option<&T> {
        self.head.as_ref().map(|front| &front.value)
    }

    /// Reverses the chain in place by unwinding the spine one owned node at a
    /// time: take the front, point its `next` at what has been reversed so
    /// far, keep the rest. When the walk exhausts the spine the original
    /// tail becomes the head. `O(n)` time, no reallocations.
    pub fn reverse(&mut self) {
        let mut reversed: Option<Box<Node<T>>> = None;
        let mut remaining = self.head.take();

        while let Some(mut node) = remaining {
            remaining = node.next.take();
            node.next = reversed.take();
            reversed = Some(node);
        }

        self.head = reversed;
    }

    pub fn len(&self) -> usize {
        self.len
    }

    pub fn is_empty(&self) -> bool {
        self.head.is_none()
    }

    pub fn iter(&self) -> Iter<'_, T> {
        Iter {
            node: self.head.as_deref(),
        }
    }
}

/// Forward iterator over the list values, produced by
/// [`SinglyLinkedList::iter`].
#[derive(Clone, Debug)]
pub struct Iter<'a, T> {
    node: Option<&'a Node<T>>,
}

impl<'a, T> Iterator for Iter<'a, T> {
    type Item = &'a T;

    fn next(&mut self) -> Option<Self::Item> {
        let node = self.node?;
        self.node = node.next.as_deref();
        Some(&node.value)
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
