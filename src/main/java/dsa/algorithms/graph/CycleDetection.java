package dsa.algorithms.graph;

import java.util.List;

/**
 * Finding cycles - and the two cases are genuinely different algorithms.
 *
 * <p><b>Undirected.</b> Every edge appears in both directions, so the edge you
 * arrived on always looks like a way back. Pass the parent down and skip it. A
 * visited neighbour that is <em>not</em> the parent means a cycle.
 *
 * <p><b>Directed.</b> The parent trick does not work: reaching an already
 * visited vertex is fine if you finished with it long ago. You need three
 * states - unvisited, <em>on the current path</em>, and finished. An edge into
 * a vertex on the current path is a back edge, hence a cycle.
 *
 * <p>Getting these two confused is the most common graph mistake there is.
 *
 * <p>Target: O(V + E) time, O(V) space.
 *
 * <p>See {@code docs/algorithms/graph-traversal.md} for what to understand first.
 */
public final class CycleDetection {

    private CycleDetection() {
    }

    /** True when an undirected graph contains a cycle. */
    public static boolean hasCycleUndirected(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: CycleDetection.hasCycleUndirected");
    }

    /** True when a directed graph contains a cycle. */
    public static boolean hasCycleDirected(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: CycleDetection.hasCycleDirected");
    }
}
