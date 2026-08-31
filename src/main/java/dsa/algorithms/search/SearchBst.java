package dsa.algorithms.search;

import dsa.support.TreeNode;

/**
 * Binary search over a binary search tree.
 *
 * <p>Same halving idea, except the structure does the splitting for you: the
 * comparison at each node tells you which subtree to walk into. Worth writing
 * next to the array version to see that "binary search" is a strategy, not one
 * piece of code.
 *
 * <p>Target: O(h) time, where h is the height - O(log n) balanced, O(n) in the
 * degenerate case. That gap is why balanced trees exist.
 *
 * <p>See {@code docs/algorithms/binary-search.md} for what to understand first.
 */
public final class SearchBst {

    private SearchBst() {
    }

    public static boolean contains(TreeNode root, int target) {
        throw new UnsupportedOperationException("TODO: SearchBst.contains");
    }
}
