package dsa.exercises.trees;

import dsa.support.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Search Tree.
 *
 * <p>Return the deepest node that has both {@code p} and {@code q} as
 * descendants; a node counts as its own descendant. Both values are present.
 *
 * <p>Example: in {@code [6, 2, 8, 0, 4, 7, 9]}, the ancestor of 2 and 8 is 6,
 * and of 2 and 4 is 2.
 *
 * <p>The bst ordering does the work: walk down from the root, going left when
 * both values are smaller and right when both are larger. The first node that
 * splits them is the answer. O(h), no recursion needed.
 */
public final class LowestCommonAncestor {

    public static TreeNode solve(TreeNode root, int p, int q) {
        throw new UnsupportedOperationException("TODO: LowestCommonAncestor.solve");
    }
}
