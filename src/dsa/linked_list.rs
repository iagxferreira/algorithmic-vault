#[derive(Debug, Clone, PartialEq, Eq)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    pub fn new(val: i32) -> Self {
        Self { val, next: None }
    }
}

pub fn from_vec(values: &[i32]) -> Option<Box<ListNode>> {
    let mut head: Option<Box<ListNode>> = None;

    for &value in values.iter().rev() {
        let mut node = Box::new(ListNode::new(value));
        node.next = head;
        head = Some(node);
    }

    head
}

pub fn to_vec(head: &Option<Box<ListNode>>) -> Vec<i32> {
    let mut values = Vec::new();
    let mut current = head.as_ref();

    while let Some(node) = current {
        values.push(node.val);
        current = node.next.as_ref();
    }

    values
}

pub fn reverse(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut prev = None;

    while let Some(mut node) = head {
        head = node.next.take();
        node.next = prev;
        prev = Some(node);
    }

    prev
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn round_trips_vec() {
        let list = from_vec(&[1, 2, 3]);
        assert_eq!(to_vec(&list), vec![1, 2, 3]);
    }

    #[test]
    fn reverses_list() {
        let list = from_vec(&[1, 2, 3]);
        let reversed = reverse(list);
        assert_eq!(to_vec(&reversed), vec![3, 2, 1]);
    }
}

