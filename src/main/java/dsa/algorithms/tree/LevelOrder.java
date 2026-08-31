package dsa.algorithms.tree;

import dsa.support.TreeNode;
import java.util.List;

/**
 * Level order traversal - breadth first, with a queue.
 *
 * <p>The odd one out: the other three orders ride the call stack, this one
 * needs a queue. Use it whenever the answer depends on <em>depth</em> - the
 * shallowest leaf, the view from one side, the width of a level.
 *
 * <p>The key move is processing one whole level per outer iteration: read
 * {@code queue.size()} into a local <b>before</b> the inner loop, because the
 * queue grows while you drain it.
 *
 * <p>Target: O(n) time, O(w) space, where w is the widest level.
 *
 * <p>See {@code docs/algorithms/tree-traversal.md} for what to understand first.
 */
public final class LevelOrder {

    private LevelOrder() {
    }

    /** One inner list per depth, top to bottom. */
    public static List<List<Integer>> traverse(TreeNode root) {
        throw new UnsupportedOperationException("TODO: LevelOrder.traverse");
    }

    /** Alternating direction: left to right, then right to left. */
    public static List<List<Integer>> zigzag(TreeNode root) {
        throw new UnsupportedOperationException("TODO: LevelOrder.zigzag");
    }

    /** The rightmost value at each depth - what you see looking from the right. */
    public static List<Integer> rightSideView(TreeNode root) {
        throw new UnsupportedOperationException("TODO: LevelOrder.rightSideView");
    }

    /** Edges to the nearest leaf. Bfs can stop at the first one it meets. */
    public static int minDepth(TreeNode root) {
        throw new UnsupportedOperationException("TODO: LevelOrder.minDepth");
    }
}
