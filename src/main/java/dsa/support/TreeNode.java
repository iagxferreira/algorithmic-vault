package dsa.support;

/**
 * Binary tree node shared by the tree exercises.
 *
 * <p>This is plumbing, not an exercise: it is already implemented so the
 * exercises can focus on the algorithm.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
