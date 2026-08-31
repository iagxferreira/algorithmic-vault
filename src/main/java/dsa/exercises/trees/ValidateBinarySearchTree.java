package dsa.exercises.trees;

import dsa.support.TreeNode;

/**
 * Validate Binary Search Tree.
 *
 * <p>Return true when the tree satisfies the bst property: every value in the
 * left subtree is strictly smaller than the node, every value in the right
 * subtree strictly larger.
 *
 * <p>Example: {@code [5, 1, 4, null, null, 3, 6]} is not a bst, because 3 sits
 * in the right subtree of 5.
 *
 * <p>The trap is checking only against the immediate parent, which accepts
 * that example. Carry a valid open interval down the recursion instead, or
 * walk in-order and check the values come out strictly increasing.
 */
public final class ValidateBinarySearchTree {

    public static boolean solve(TreeNode root) {
        throw new UnsupportedOperationException("TODO: ValidateBinarySearchTree.solve");
    }
}
