//! A doubly linked list where every node is its own heap allocation, in
//! both directions.
//!
//! Ownership rules out the singly list's `Box` trick here: each node is
//! pointed at by its predecessor's `next` *and* its successor's `prev`, so a
//! node has two pointers into it. Shared ownership ([`Rc`]) plus interior
//! mutability ([`RefCell`]) is the safe-Rust translation: `next` links are
//! strong (counted), `prev` links are [`Weak`] (uncounted), which keeps the
//! strong reference graph a plain forward chain that frees completely when
//! the list drops.
//!
//! The cost of sharing is visible at the seams: touching a neighbor goes
//! through `borrow()`, and iteration clones values, since an outstanding
//! `&T` through a `RefCell` would block the next mutation. In the standard
//! library, `collections::LinkedList` pays for the real doubly list with
//! `unsafe` pointers instead.

use std::cell::Ref;
use std::cell::RefCell;
use std::rc::{Rc, Weak};

#[derive(Debug, Default)]
pub struct DoublyLinkedList<T> {
    /// Declared before `tail` on purpose: on drop, Rust releases fields in
    /// order, so the head chain cascades first and every node frees, no
    /// matter how far the `tail` handle reached into the chain.
    head: Link<T>,
    tail: Option<Rc<RefCell<Node<T>>>>,
    len: usize,
}

type Link<T> = Option<Rc<RefCell<Node<T>>>>;

#[derive(Debug)]
struct Node<T> {
    value: T,
    next: Link<T>,
    prev: Option<Weak<RefCell<Node<T>>>>,
}

impl<T> DoublyLinkedList<T> {
    pub fn new() -> Self {
        Self {
            head: None,
            tail: None,
            len: 0,
        }
    }

    /// Prepends to the front. `O(1)`: one allocation, and on a non-empty
    /// list one `prev` fix-up on the old head.
    pub fn push_front(&mut self, value: T) {
        let new_head = Rc::new(RefCell::new(Node {
            value,
            next: self.head.take(),
            prev: None,
        }));

        if let Some(old_head) = new_head.borrow().next.clone() {
            old_head.borrow_mut().prev = Some(Rc::downgrade(&new_head));
        } else {
            self.tail = Some(new_head.clone());
        }

        self.head = Some(new_head);
        self.len += 1;
    }

    /// Appends to the back. `O(1)`: one allocation, and on a non-empty list
    /// one `next` fix-up on the old tail.
    pub fn push_back(&mut self, value: T) {
        let new_tail = Rc::new(RefCell::new(Node {
            value,
            next: None,
            prev: None,
        }));

        if let Some(old_tail) = self.tail.take() {
            old_tail.borrow_mut().next = Some(new_tail.clone());
            new_tail.borrow_mut().prev = Some(Rc::downgrade(&old_tail));
        } else {
            self.head = Some(new_tail.clone());
        }

        self.tail = Some(new_tail);
        self.len += 1;
    }

    /// Removes the front node and returns its value. `O(1)`: after
    /// `head.take()` releases the list's strong count, only this function
    /// holds the node, so `Rc::try_unwrap` can hand its value out whole.
    pub fn pop_front(&mut self) -> Option<T> {
        let front = self.head.take()?;

        match front.borrow_mut().next.take() {
            Some(next) => {
                next.borrow_mut().prev = None;
                self.head = Some(next);
            }
            None => self.tail = None,
        }

        self.len -= 1;
        Some(
            Rc::try_unwrap(front)
                .ok()
                .expect("no other handles")
                .into_inner()
                .value,
        )
    }

    /// Removes the back node and returns its value. `O(1)`: because `prev`
    /// is `Weak`, the last node's only strong pointer is the list's own
    /// `tail` handle.
    pub fn pop_back(&mut self) -> Option<T> {
        let tail = self.tail.take()?;

        match tail
            .borrow_mut()
            .prev
            .take()
            .as_ref()
            .and_then(Weak::upgrade)
        {
            Some(previous) => {
                previous.borrow_mut().next = None;
                self.tail = Some(previous);
            }
            None => self.head = None,
        }

        self.len -= 1;
        Some(
            Rc::try_unwrap(tail)
                .ok()
                .expect("no other handles")
                .into_inner()
                .value,
        )
    }

    /// Borrows the front value. The guard holds a read borrow of the node's
    /// `RefCell` for its lifetime, so further shared reads are fine but any
    /// mutation of the list must wait for it to go out of scope.
    pub fn front(&self) -> Option<Ref<'_, T>> {
        self.head
            .as_ref()
            .map(|head| Ref::map(head.borrow(), |node| &node.value))
    }

    /// Borrows the back value. Same borrow rules as [`front`].
    pub fn back(&self) -> Option<Ref<'_, T>> {
        self.tail
            .as_ref()
            .map(|tail| Ref::map(tail.borrow(), |node| &node.value))
    }

    /// Drops every value and resets the list to empty. `O(n)`.
    pub fn clear(&mut self) {
        self.head = None;
        self.tail = None;
        self.len = 0;
    }

    pub fn len(&self) -> usize {
        self.len
    }

    pub fn is_empty(&self) -> bool {
        self.len == 0
    }
}

/// Forward iterator over the list values, produced by
/// [`DoublyLinkedList::iter`]. Cloning the values is not a style choice:
/// an iteration step clones the strong handle before `borrow()`, the
/// borrow's guard would block the following step, and a shared-ownership
/// node cannot hand out plain `&T` across steps. Requires a clonable value
/// type.
#[derive(Clone, Debug)]
pub struct Iter<T> {
    next: Option<Rc<RefCell<Node<T>>>>,
}

impl<T: Clone> Iterator for Iter<T> {
    type Item = T;

    fn next(&mut self) -> Option<Self::Item> {
        let node = self.next.take()?;
        let value = node.borrow().value.clone();
        self.next = node.borrow().next.clone();
        Some(value)
    }
}

impl<T> DoublyLinkedList<T> {
    /// Walks the list from the front, cloning values along the way.
    pub fn iter(&self) -> Iter<T> {
        Iter {
            next: self.head.clone(),
        }
    }
}

impl<T: Clone> IntoIterator for &DoublyLinkedList<T> {
    type Item = T;
    type IntoIter = Iter<T>;

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

        assert_eq!(*list.front().expect("three items"), 42);
        assert_eq!(*list.back().expect("three items"), 1);
        assert_eq!(list.len(), 3);
        assert_eq!(list.iter().collect::<Vec<_>>(), [42, 7, 1]);
    }

    #[test]
    fn push_back_appends() {
        let mut list = DoublyLinkedList::new();
        list.push_back(1);
        list.push_back(7);
        list.push_back(42);

        assert_eq!(*list.front().expect("three items"), 1);
        assert_eq!(*list.back().expect("three items"), 42);
        assert_eq!(list.len(), 3);
        assert_eq!(list.iter().collect::<Vec<_>>(), [1, 7, 42]);
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
        assert_eq!(*list.front().expect("two items left"), 1);
        assert_eq!(*list.back().expect("two items left"), 2);
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

        list.push_front(9);
        assert_eq!(*list.front().expect("one item"), 9);
        assert_eq!(*list.back().expect("one item"), 9);
        assert_eq!(list.len(), 1);
    }

    #[test]
    fn list_works_in_for_loops() {
        let list: DoublyLinkedList<_> = [1, 2, 3].into_iter().collect();
        let seen: Vec<_> = list.into_iter().collect();
        assert_eq!(seen, [1, 2, 3]);
    }

    #[test]
    fn strings_drop_correctly() {
        let mut list = DoublyLinkedList::new();
        list.push_back("first".to_string());
        list.push_back("second".to_string());

        assert_eq!(list.pop_back(), Some("second".to_string()));
        assert_eq!(list.pop_front(), Some("first".to_string()));
        assert!(list.is_empty());
    }
}
