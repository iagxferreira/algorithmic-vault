use std::collections::VecDeque;

#[derive(Debug, Clone, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Box<TreeNode>>,
    pub right: Option<Box<TreeNode>>,
}

impl TreeNode {
    pub fn new(val: i32) -> Self {
        Self {
            val,
            left: None,
            right: None,
        }
    }
}

pub fn max_depth(root: &Option<Box<TreeNode>>) -> usize {
    match root {
        Some(node) => 1 + max_depth(&node.left).max(max_depth(&node.right)),
        None => 0,
    }
}

pub fn level_order(root: &Option<Box<TreeNode>>) -> Vec<Vec<i32>> {
    let mut result = Vec::new();
    let Some(root) = root.as_ref() else {
        return result;
    };

    let mut queue = VecDeque::from([root.as_ref()]);

    while !queue.is_empty() {
        let level_size = queue.len();
        let mut level = Vec::with_capacity(level_size);

        for _ in 0..level_size {
            let node = queue.pop_front().expect("queue is not empty");
            level.push(node.val);

            if let Some(left) = node.left.as_ref() {
                queue.push_back(left.as_ref());
            }

            if let Some(right) = node.right.as_ref() {
                queue.push_back(right.as_ref());
            }
        }

        result.push(level);
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn computes_depth() {
        let mut root = Box::new(TreeNode::new(1));
        root.left = Some(Box::new(TreeNode::new(2)));
        root.right = Some(Box::new(TreeNode::new(3)));
        root.left.as_mut().unwrap().left = Some(Box::new(TreeNode::new(4)));

        assert_eq!(max_depth(&Some(root)), 3);
    }

    #[test]
    fn traverses_levels() {
        let mut root = Box::new(TreeNode::new(1));
        root.left = Some(Box::new(TreeNode::new(2)));
        root.right = Some(Box::new(TreeNode::new(3)));
        root.left.as_mut().unwrap().left = Some(Box::new(TreeNode::new(4)));

        assert_eq!(level_order(&Some(root)), vec![vec![1], vec![2, 3], vec![4]]);
    }
}

