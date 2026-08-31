package dsa.exercises.trees;

import dsa.support.TreeNode;

/**
 * Diameter of Binary Tree.
 *
 * <p>Length, in edges, of the longest path between any two nodes. The path
 * does not have to pass through the root.
 *
 * <p>Example: {@code [1, 2, 3, 4, 5]} gives 3, for the path 4 - 2 - 1 - 3.
 *
 * <p>The pattern worth learning: one post-order pass that <em>returns</em>
 * height while <em>recording</em> the best answer in a field or holder. Trying
 * to return both at once, or recomputing height at every node, turns an O(n)
 * solution into O(n^2).
 */
public final class DiameterOfBinaryTree {

    public static int solve(TreeNode root) {
        throw new UnsupportedOperationException("TODO: DiameterOfBinaryTree.solve");
    }
}
