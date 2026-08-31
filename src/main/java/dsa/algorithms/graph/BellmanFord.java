package dsa.algorithms.graph;

/**
 * Bellman-Ford - cheapest paths that tolerate negative weights.
 *
 * <p>Edges are given as {@code {from, to, weight}} over
 * {@code vertexCount} vertices.
 *
 * <p>Relax every edge, V-1 times. After k rounds, every shortest path using at
 * most k edges is correct - and a shortest path can use at most V-1 edges, so
 * V-1 rounds finish the job. That "at most k edges" property is also why this,
 * not Dijkstra, is the right tool when a problem caps the number of hops.
 *
 * <p>Run one extra round: if anything still improves, a negative cycle is
 * reachable and no shortest path exists.
 *
 * <p>Target: O(V * E) time, O(V) space. Slower than Dijkstra, and strictly
 * more capable.
 *
 * <p>See {@code docs/algorithms/shortest-paths.md} for what to understand first.
 */
public final class BellmanFord {

    private BellmanFord() {
    }

    /**
     * Distances from {@code source}, or null when a negative cycle is
     * reachable from it. Unreachable vertices stay {@link Integer#MAX_VALUE}.
     */
    public static int[] distances(int vertexCount, int[][] edges, int source) {
        throw new UnsupportedOperationException("TODO: BellmanFord.distances");
    }

    /**
     * Distances using at most {@code maxEdges} edges. Relax from a snapshot of
     * the previous round, not the array you are writing into, or one round can
     * chain several edges together.
     */
    public static int[] distancesWithin(int vertexCount, int[][] edges, int source, int maxEdges) {
        throw new UnsupportedOperationException("TODO: BellmanFord.distancesWithin");
    }
}
