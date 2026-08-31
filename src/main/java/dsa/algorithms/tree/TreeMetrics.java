package dsa.algorithms.tree;

import dsa.support.TreeNode;
import java.util.List;

/**
 * Values computed from a whole subtree - all post-order underneath.
 *
 * <p>{@link #diameter} is the one to study. The pattern it teaches: a single
 * post-order pass that <b>returns</b> one thing (height) while
 * <b>recording</b> another (the best answer so far) in a field or holder.
 * Trying to return both, or recomputing height at every node, turns an O(n)
 * solution into O(n^2). That pattern reappears in maximum path sum, balanced
 * tree checks and subtree aggregate problems.
 *
 * <p>Target: O(n) time, O(h) space.
 *
 * <p>See {@code docs/algorithms/tree-traversal.md} for what to understand first.
 */
public final class TreeMetrics {

    private TreeMetrics() {
    }

    /** Edges on the longest root-to-leaf path; -1 for an empty tree. */
    public static int height(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeMetrics.height");
    }

    /** Total number of nodes. */
    public static int countNodes(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeMetrics.countNodes");
    }

    /** Number of leaves, i.e. nodes with no children. */
    public static int countLeaves(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeMetrics.countLeaves");
    }

    /** Every root-to-leaf path, each as the list of values along it. */
    public static List<List<Integer>> rootToLeafPaths(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeMetrics.rootToLeafPaths");
    }

    /** Edges on the longest path between any two nodes; it need not pass the root. */
    public static int diameter(TreeNode root) {
        throw new UnsupportedOperationException("TODO: TreeMetrics.diameter");
    }
}
