pub fn solve(root: &Option<Box<crate::dsa::binary_tree::TreeNode>>) -> Vec<Vec<i32>> {
    crate::dsa::binary_tree::level_order(root)
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::dsa::binary_tree::TreeNode;

    #[test]
    fn solves_level_order() {
        let mut root = Box::new(TreeNode::new(1));
        root.left = Some(Box::new(TreeNode::new(2)));
        root.right = Some(Box::new(TreeNode::new(3)));

        assert_eq!(solve(&Some(root)), vec![vec![1], vec![2, 3]]);
    }
}

