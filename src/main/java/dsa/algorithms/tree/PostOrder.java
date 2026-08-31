package dsa.algorithms.tree;

import dsa.support.TreeNode;
import java.util.List;

/**
 * Post-order traversal: <b>left, right, node</b>.
 *
 * <p>You visit a node only after both subtrees are done, so it is the order
 * for anything computed <em>from</em> the children: height, diameter, subtree
 * sums, and deleting a tree safely.
 *
 * <p>The neat iterative trick: build node-right-left with one stack, then
 * reverse the result at the end. The honest two-stack or visited-flag versions
 * are worth writing too.
 *
 * <p>Target: O(n) time, O(h) space.
 *
 * <p>See {@code docs/algorithms/tree-traversal.md} for what to understand first.
 */
public final class PostOrder {

    private PostOrder() {
    }

    /** Recursively. */
    public static List<Integer> traverse(TreeNode root) {
        throw new UnsupportedOperationException("TODO: PostOrder.traverse");
    }

    /** With an explicit stack. */
    public static List<Integer> traverseIterative(TreeNode root) {
        throw new UnsupportedOperationException("TODO: PostOrder.traverseIterative");
    }
}
