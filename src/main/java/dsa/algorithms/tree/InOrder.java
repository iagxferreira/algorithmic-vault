package dsa.algorithms.tree;

import dsa.support.TreeNode;
import java.util.List;

/**
 * In-order traversal: <b>left, node, right</b>.
 *
 * <p>On a binary search tree this emits the values in sorted order, which is
 * the single most useful fact about BSTs. Validating a BST, finding the k-th
 * smallest, and finding the minimum absolute difference are all "walk
 * in-order and look at consecutive pairs".
 *
 * <p>The iterative version is the trickiest of the three: dive left pushing as
 * you go, then pop, visit, and move right.
 *
 * <p>Target: O(n) time, O(h) space.
 *
 * <p>See {@code docs/algorithms/tree-traversal.md} for what to understand first.
 */
public final class InOrder {

    private InOrder() {
    }

    /** Recursively. */
    public static List<Integer> traverse(TreeNode root) {
        throw new UnsupportedOperationException("TODO: InOrder.traverse");
    }

    /** With an explicit stack. */
    public static List<Integer> traverseIterative(TreeNode root) {
        throw new UnsupportedOperationException("TODO: InOrder.traverseIterative");
    }

    /**
     * True when the values come out strictly increasing, i.e. the tree is a
     * valid binary search tree. One line on top of the walk once you see it.
     */
    public static boolean isBinarySearchTree(TreeNode root) {
        throw new UnsupportedOperationException("TODO: InOrder.isBinarySearchTree");
    }
}
