package dsa.exercises.trees;

import dsa.support.TreeNode;

/**
 * Kth Smallest Element in a BST.
 *
 * <p>Return the {@code k}-th smallest value, 1-indexed.
 *
 * <p>Example: in {@code [3, 1, 4, null, 2]}, the 1st smallest is 1 and the 3rd
 * is 3.
 *
 * <p>An in-order walk of a bst emits values in sorted order, so this is
 * "stop the walk after k values". Materialising the whole list first works but
 * is O(n); stopping early is O(h + k).
 */
public final class KthSmallestInBst {

    public static int solve(TreeNode root, int k) {
        throw new UnsupportedOperationException("TODO: KthSmallestInBst.solve");
    }
}
