package dsa.algorithms.graph;

import java.util.List;

/**
 * Depth-first search - dive, then back up.
 *
 * <p>Graphs arrive as an adjacency list: {@code adjacency.get(v)} is the list
 * of vertices reachable from {@code v} in one hop, vertices are
 * {@code 0..n-1}. Build one with {@link dsa.structures.Graph#adjacency()}.
 *
 * <p>DFS and BFS are the same algorithm with a different container - a stack
 * versus a queue. DFS is what you want when the question is about the
 * <em>structure</em> of the exploration: connectivity, cycles, topological
 * order.
 *
 * <p>Visit the smallest-numbered neighbour first, so the output is
 * deterministic.
 *
 * <p>Target: O(V + E) time, O(V) space.
 *
 * <p>See {@code docs/algorithms/graph-traversal.md} for what to understand first.
 */
public final class DepthFirstSearch {

    private DepthFirstSearch() {
    }

    /** Vertices in the order a recursive dfs from {@code start} first sees them. */
    public static List<Integer> traverse(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: DepthFirstSearch.traverse");
    }

    /**
     * The same order, driven by an explicit stack. Watch the push order: to
     * pop the smallest neighbour first you must push the neighbours reversed.
     */
    public static List<Integer> traverseIterative(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: DepthFirstSearch.traverseIterative");
    }

    /** Every vertex reachable from {@code start}, including itself. */
    public static boolean[] reachableFrom(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: DepthFirstSearch.reachableFrom");
    }
}
