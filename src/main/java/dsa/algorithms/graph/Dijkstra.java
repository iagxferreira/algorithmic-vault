package dsa.algorithms.graph;

import java.util.List;

/**
 * Dijkstra's algorithm - cheapest paths from one source, non-negative weights.
 *
 * <p>Weighted graphs arrive as {@code adjacency.get(v)} holding {@code int[]}
 * pairs of {@code {neighbour, weight}}. Unreachable distances are
 * {@link Integer#MAX_VALUE}.
 *
 * <p>Greedy: repeatedly settle the closest unsettled vertex, then relax its
 * edges. A min-heap of {@code (distance, vertex)} makes "closest unsettled"
 * cheap. Once a vertex comes off the heap its distance is final - that is the
 * whole correctness argument, and it <b>depends on every weight being
 * non-negative</b>. A negative edge could make a settled vertex cheaper later,
 * which is exactly why {@link BellmanFord} exists.
 *
 * <p>Java's {@code PriorityQueue} has no decrease-key, so push duplicates and
 * skip stale entries with {@code if (d > dist[u]) continue;}.
 *
 * <p>Target: O(E log V) time, O(V + E) space.
 *
 * <p>See {@code docs/algorithms/shortest-paths.md} for what to understand first.
 */
public final class Dijkstra {

    private Dijkstra() {
    }

    /** Cheapest cost to every vertex; {@link Integer#MAX_VALUE} when unreachable. */
    public static int[] distances(List<List<int[]>> adjacency, int source) {
        throw new UnsupportedOperationException("TODO: Dijkstra.distances");
    }

    /**
     * The cheapest path from {@code source} to {@code target} inclusive, or an
     * empty list when unreachable. Same loop, keeping a parent array.
     */
    public static List<Integer> path(List<List<int[]>> adjacency, int source, int target) {
        throw new UnsupportedOperationException("TODO: Dijkstra.path");
    }
}
