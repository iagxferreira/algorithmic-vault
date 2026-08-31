package dsa.algorithms.graph;

import java.util.List;

/**
 * Ordering a directed acyclic graph so every edge points forwards.
 *
 * <p>"Which courses can I take first", "in what order do these tasks build",
 * "does this dependency graph even make sense" are all this.
 *
 * <p>Kahn's algorithm: count each vertex's in-degree, start with the zeroes,
 * and every time you output a vertex decrement its neighbours - outputting any
 * that hit zero. Where several are ready, take the smallest index so the
 * result is deterministic.
 *
 * <p>The cycle check is free and easy to forget: if you output fewer than V
 * vertices, the leftovers are stuck in a cycle.
 *
 * <p>Target: O(V + E) time, O(V) space.
 *
 * <p>See {@code docs/algorithms/graph-traversal.md} for what to understand first.
 */
public final class TopologicalSort {

    private TopologicalSort() {
    }

    /** A topological order, or an empty list when the graph has a cycle. */
    public static List<Integer> sort(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: TopologicalSort.sort");
    }

    /** In-degree of every vertex - the input Kahn's algorithm starts from. */
    public static int[] inDegrees(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: TopologicalSort.inDegrees");
    }
}
