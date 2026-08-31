package dsa.exercises.trees;

import dsa.support.TreeNode;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal.
 *
 * <p>Rebuild the tree from its pre-order and in-order sequences. Values are
 * distinct.
 *
 * <p>Example: {@code preorder = [3, 9, 20, 15, 7]} and
 * {@code inorder = [9, 3, 15, 20, 7]} rebuild the tree {@code [3, 9, 20, null,
 * null, 15, 7]}.
 *
 * <p>Pre-order hands you the root first; finding that root inside the in-order
 * sequence splits it into the left and right subtrees, and their sizes tell you
 * where to split the pre-order sequence too. Scanning for the root each time is
 * O(n^2); a value-to-index hash map makes it O(n).
 */
public final class BuildTreeFromTraversals {

    public static TreeNode solve(int[] preorder, int[] inorder) {
        throw new UnsupportedOperationException("TODO: BuildTreeFromTraversals.solve");
    }
}
