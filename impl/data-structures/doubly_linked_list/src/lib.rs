//! A doubly linked list with a sentinel node, stored on an arena.
//!
//! The sentinel is a permanent valueless node kept at arena index 0. In a
//! circular wiring the sentinel's `next` handle is the front of the list and
//! its `prev` handle is the back, so an empty list is simply one where both
//! handles point back at the sentinel — no `Option` special cases anywhere in
//! the insert and remove routines.
//!
//! As with the singly linked list, popped nodes become tombstones: the arena
//! never compacts.

#[derive(Clone, Debug, Default, PartialEq)]
pub struct DoublyLinkedList<T> {
    arena: Vec<Node<T>>,
    len: usize,
}

#[derive(Clone, Debug, PartialEq)]
struct Node<T> {
    value: Option<T>,
    next: Option<usize>,
    prev: Option<usize>,
}

const SENTINEL: usize = 0;

impl<T> DoublyLinkedList<T> {
    pub fn new() -> Self {
        Self {
            arena: vec![Node {
                value: None,
                next: Some(SENTINEL),
                prev: Some(SENTINEL),
            }],
            len: 0,
        }
    }

    /// Wires `index` between `prev` and `next`, updating all four handles.
    /// The single splice primitive every insert builds on. `O(1)`.
    fn link(&mut self, index: usize, prev: usize, next: usize) {
        self.arena[index].prev = Some(prev);
        self.arena[index].next = Some(next);
        self.arena[prev].next = Some(index);
        self.arena[next].prev = Some(index);
    }

    /// Prepends to the front: splices the new node between the sentinel and
    /// the current head. `O(1)`.
    pub fn push_front(&mut self, value: T) {
        let index = self.arena.len();
        let front = self.arena[SENTINEL]
            .next
            .expect("sentinel links never dangle");
        self.arena.push(Node {
            value: Some(value),
            next: None,
            prev: None,
        });
        self.link(index, SENTINEL, front);
        self.len += 1;
    }

    /// Appends to the back: splices the new node between the current tail
    /// (the sentinel's `prev`) and the sentinel. `O(1)`.
    pub fn push_back(&mut self, value: T) {
        let index = self.arena.len();
        let tail = self.arena[SENTINEL]
            .prev
            .expect("sentinel links never dangle");
        self.arena.push(Node {
            value: Some(value),
            next: None,
            prev: None,
        });
        self.link(index, tail, SENTINEL);
        self.len += 1;
    }

    /// Removes the front node and returns its value, bypassing the splice
    /// since removing the first node only needs to update two handles.
    /// `O(1)`.
    pub fn pop_front(&mut self) -> Option<T> {
        let front = self.arena[SENTINEL].next?;
        let back = self.arena[front].next?;
        let value = self.arena[front].value.take()?;
        self.arena[SENTINEL].next = Some(back);
        self.arena[back].prev = Some(SENTINEL);

        self.len -= 1;
        Some(value)
    }

    /// Removes the back node and returns its value. `O(1)`.
    pub fn pop_back(&mut self) -> Option<T> {
        let tail = self.arena[SENTINEL].prev?;
        let back = self.arena[tail].prev?;
        let value = self.arena[tail].value.take()?;
        self.arena[SENTINEL].prev = Some(back);
        self.arena[back].next = Some(SENTINEL);

        self.len -= 1;
        Some(value)
    }

    /// Borrows the front value without removing it. `O(1)`.
    pub fn front(&self) -> Option<&T> {
        let front = self.arena[SENTINEL].next?;
        self.arena[front].value.as_ref()
    }

    /// Borrows the back value without removing it. `O(1)`.
    pub fn back(&self) -> Option<&T> {
        let tail = self.arena[SENTINEL].prev?;
        self.arena[tail].value.as_ref()
    }

    /// Reverses the list in place by swapping each node's `next` and `prev`
    /// handles, sentinel included. `O(n)` time, `O(1)` extra space.
    pub fn reverse(&mut self) {
        for node in &mut self.arena {
            std::mem::swap(&mut node.next, &mut node.prev);
        }
    }

    /// Drops every value and resets the list to empty. `O(n)`.
    pub fn clear(&mut self) {
        self.arena.truncate(1);
        self.arena[SENTINEL].next = Some(SENTINEL);
        self.arena[SENTINEL].prev = Some(SENTINEL);
        self.len = 0;
    }

    pub fn len(&self) -> usize {
        self.len
    }

    pub fn is_empty(&self) -> bool {
        self.len == 0
    }

    pub fn iter(&self) -> Iter<'_, T> {
        Iter {
            arena: &self.arena,
            current: self.arena[SENTINEL].next,
        }
    }
}

/// Forward iterator over the list values, produced by
/// [`DoublyLinkedList::iter`]. It walks nodes until it lands back on the
/// sentinel; tombstone slots are never reached, so their stale handles do not
/// matter.
#[derive(Clone, Debug)]
pub struct Iter<'a, T> {
    arena: &'a [Node<T>],
    current: Option<usize>,
}

impl<'a, T> Iterator for Iter<'a, T> {
    type Item = &'a T;

    fn next(&mut self) -> Option<Self::Item> {
        let index = self.current?;
        if index == SENTINEL {
            return None;
        }
        let node = &self.arena[index];
        self.current = node.next;
        node.value.as_ref()
    }
}

impl<'a, T> IntoIterator for &'a DoublyLinkedList<T> {
    type Item = &'a T;
    type IntoIter = Iter<'a, T>;

    fn into_iter(self) -> Self::IntoIter {
        self.iter()
    }
}

impl<T> FromIterator<T> for DoublyLinkedList<T> {
    fn from_iter<I: IntoIterator<Item = T>>(values: I) -> Self {
        let mut list = Self::new();
        for value in values {
            list.push_back(value);
        }
        list
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn new_list_is_empty() {
        let list = DoublyLinkedList::<i32>::new();
        assert!(list.is_empty());
        assert_eq!(list.len(), 0);
        assert_eq!(list.front(), None);
        assert_eq!(list.back(), None);
        assert_eq!(list.iter().count(), 0);
    }

    #[test]
    fn empty_pops_return_nothing() {
        let mut list = DoublyLinkedList::<i32>::new();
        assert_eq!(list.pop_front(), None);
        assert_eq!(list.pop_back(), None);
        assert!(list.is_empty());
        assert_eq!(list.len(), 0);
    }

    #[test]
    fn push_front_prepends() {
        let mut list = DoublyLinkedList::new();
        list.push_front(1);
        list.push_front(7);
        list.push_front(42);

        assert_eq!(list.front(), Some(&42));
        assert_eq!(list.back(), Some(&1));
        assert_eq!(list.len(), 3);
        let items: Vec<_> = list.iter().copied().collect();
        assert_eq!(items, [42, 7, 1]);
    }

    #[test]
    fn push_back_appends() {
        let mut list = DoublyLinkedList::new();
        list.push_back(1);
        list.push_back(7);
        list.push_back(42);

        assert_eq!(list.front(), Some(&1));
        assert_eq!(list.back(), Some(&42));
        assert_eq!(list.len(), 3);
        let items: Vec<_> = list.iter().copied().collect();
        assert_eq!(items, [1, 7, 42]);
    }

    #[test]
    fn mixed_pushes_and_pops() {
        let mut list = DoublyLinkedList::new();
        list.push_back(2);
        list.push_front(1);
        list.push_back(3);
        list.push_front(0);

        assert_eq!(list.pop_front(), Some(0));
        assert_eq!(list.pop_back(), Some(3));
        assert_eq!(list.front(), Some(&1));
        assert_eq!(list.back(), Some(&2));
        assert_eq!(list.pop_front(), Some(1));
        assert_eq!(list.pop_back(), Some(2));
        assert!(list.is_empty());
    }

    #[test]
    fn reused_after_clear() {
        let mut list: DoublyLinkedList<_> = [1, 2, 3].into_iter().collect();
        assert_eq!(list.len(), 3);

        list.clear();
        assert!(list.is_empty());
        assert_eq!(list.front(), None);

        list.push_front(9);
        assert_eq!(list.front(), Some(&9));
        assert_eq!(list.back(), Some(&9));
        assert_eq!(list.len(), 1);
    }

    #[test]
    fn reverse_empty_and_single_lists() {
        let mut empty = DoublyLinkedList::<i32>::new();
        empty.reverse();
        assert!(empty.is_empty());

        let mut single = DoublyLinkedList::new();
        single.push_front(5);
        single.reverse();
        assert_eq!(single.front(), Some(&5));
        assert_eq!(single.back(), Some(&5));
    }

    #[test]
    fn double_reverse_restores_original_order() {
        let mut list: DoublyLinkedList<_> = [1, 2, 3, 4].into_iter().collect();

        list.reverse();
        assert_eq!(list.front(), Some(&4));
        assert_eq!(list.back(), Some(&1));
        let once: Vec<_> = list.iter().copied().collect();
        assert_eq!(once, [4, 3, 2, 1]);

        list.reverse();
        let twice: Vec<_> = list.iter().copied().collect();
        assert_eq!(twice, [1, 2, 3, 4]);
    }

    #[test]
    fn list_works_in_for_loops() {
        let list: DoublyLinkedList<_> = [1, 2, 3].into_iter().collect();
        let seen: Vec<_> = list.into_iter().copied().collect();
        assert_eq!(seen, [1, 2, 3]);
    }

    #[test]
    fn strings_drop_correctly() {
        let mut list = DoublyLinkedList::new();
        list.push_back("first".to_string());
        list.push_back("second".to_string());

        list.reverse();
        assert_eq!(list.pop_front(), Some("second".to_string()));
        assert_eq!(list.front(), Some(&"first".to_string()));
        assert_eq!(list.len(), 1);
    }
}
