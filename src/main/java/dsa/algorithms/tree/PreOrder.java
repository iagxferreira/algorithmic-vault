package dsa.algorithms.tree;

import dsa.support.TreeNode;
import java.util.List;

/**
 * Pre-order traversal: <b>node, left, right</b>.
 *
 * <p>You visit a node before either of its children, so the root comes out
 * first. That makes pre-order the order for <em>copying</em> or
 * <em>serialising</em> a tree - you always have the parent before you need to
 * attach its children.
 *
 * <p>Write both forms. The recursion is three lines; the iterative version
 * teaches you what the call stack was doing for you, and is what you fall back
 * on when the tree is deep enough to overflow it.
 *
 * <p>Target: O(n) time, O(h) space.
 *
 * <p>See {@code docs/algorithms/tree-traversal.md} for what to understand first.
 */
public final class PreOrder {

    private PreOrder() {
    }

    /** Recursively. */
    public static List<Integer> traverse(TreeNode root) {
        throw new UnsupportedOperationException("TODO: PreOrder.traverse");
    }

    /**
     * With an explicit stack. Push the root, then pop-visit-push-children in a
     * loop - and push <b>right before left</b>, so left pops first.
     */
    public static List<Integer> traverseIterative(TreeNode root) {
        throw new UnsupportedOperationException("TODO: PreOrder.traverseIterative");
    }
}
