package dsa.fundamentals;

import dsa.support.TreeNode;
import java.util.List;

/**
 * Every way of walking a binary tree.
 *
 * <p>The three depth-first orders differ only in when you visit the node
 * relative to its children:
 *
 * <ul>
 *   <li><b>pre-order</b> node, left, right - copying or serialising a tree
 *   <li><b>in-order</b> left, node, right - on a bst this yields sorted order
 *   <li><b>post-order</b> left, right, node - deleting, or computing a value
 *       that depends on both subtrees (height, diameter)
 * </ul>
 *
 * <p>Breadth-first (level order) is the odd one out: it uses a queue rather
 * than the call stack, and it is what you want when the answer depends on
 * depth.
 *
 * <p>Write each order twice, recursively and iteratively. The recursive form
 * teaches the shape; the iterative form teaches what the call stack was doing
 * for you, and is what you fall back on when the tree is deep enough to
 * overflow it.
 *
 * <p>Target complexity: O(n) time, O(h) space (O(n) for level order).
 */
public final class TreeTraversal {

    private TreeTraversal() {
    }

    /** Node, left, right - recursively. */
    public static List<Integer> preOrder(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.preOrder");
    }

    /** Node, left, right - with an explicit stack. Push right before left. */
    public static List<Integer> preOrderIterative(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.preOrderIterative");
    }

    /** Left, node, right - recursively. Sorted output on a bst. */
    public static List<Integer> inOrder(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.inOrder");
    }

    /** Left, node, right - with an explicit stack: dive left, visit, go right. */
    public static List<Integer> inOrderIterative(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.inOrderIterative");
    }

    /** Left, right, node - recursively. */
    public static List<Integer> postOrder(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.postOrder");
    }

    /**
     * Left, right, node - with an explicit stack. The neat trick is to build
     * node, right, left and reverse it at the end.
     */
    public static List<Integer> postOrderIterative(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.postOrderIterative");
    }

    /** Level order (bfs), one inner list per depth. */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.levelOrder");
    }

    /** Level order alternating direction: left to right, then right to left. */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.zigzagLevelOrder");
    }

    /** Rightmost value at each depth, i.e. what you see looking from the right. */
    public static List<Integer> rightSideView(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.rightSideView");
    }

    /** Edges on the longest root-to-leaf path; -1 for an empty tree. */
    public static int height(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.height");
    }

    /** Total number of nodes. */
    public static int countNodes(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.countNodes");
    }

    /** Every root-to-leaf path, each as the list of values along it. */
    public static List<List<Integer>> rootToLeafPaths(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeTraversal.rootToLeafPaths");
    }
}
