package dsa.fundamentals;

import java.util.List;

/**
 * Shortest paths on weighted graphs.
 *
 * <p>Which one to reach for:
 *
 * <ul>
 *   <li><b>BFS</b> - all edges cost the same. See
 *       {@link GraphTraversal#distancesFrom}.
 *   <li><b>Dijkstra</b> - non-negative weights, one source. Greedy: always
 *       settle the closest unsettled vertex, using a min-heap of
 *       {@code (distance, vertex)}. Negative edges break the greedy argument,
 *       which is exactly why Bellman-Ford exists.
 *   <li><b>Bellman-Ford</b> - negative weights allowed, and it detects
 *       negative cycles. Relax every edge V-1 times; if a V-th pass still
 *       improves something, a negative cycle is reachable.
 *   <li><b>Floyd-Warshall</b> - all pairs, small V. Three nested loops with k
 *       outermost: "is going through k better than going direct?"
 * </ul>
 *
 * <p>Weighted graphs arrive as {@code adjacency.get(v)} holding {@code int[]}
 * pairs of {@code {neighbour, weight}}. Unreachable distances are
 * {@link Integer#MAX_VALUE}.
 */
public final class ShortestPaths {

    private ShortestPaths() {
    }

    /**
     * Dijkstra from {@code source}. O(E log V) with a binary heap.
     *
     * @return distance to every vertex, {@link Integer#MAX_VALUE} when unreachable.
     */
    public static int[] dijkstra(List<List<int[]>> adjacency, int source) {
        throw new UnsupportedOperationException("TODO: ShortestPaths.dijkstra");
    }

    /**
     * The actual cheapest path from {@code source} to {@code target}
     * inclusive, or an empty list when unreachable. Same as
     * {@link #dijkstra} but keeping a parent array.
     */
    public static List<Integer> dijkstraPath(List<List<int[]>> adjacency, int source, int target) {
        throw new UnsupportedOperationException("TODO: ShortestPaths.dijkstraPath");
    }

    /**
     * Bellman-Ford from {@code source} over {@code vertexCount} vertices and
     * edges given as {@code {from, to, weight}}. O(V * E).
     *
     * @return distances, or null when a negative cycle is reachable from the source.
     */
    public static int[] bellmanFord(int vertexCount, int[][] edges, int source) {
        throw new UnsupportedOperationException("TODO: ShortestPaths.bellmanFord");
    }

    /**
     * Floyd-Warshall over a dense distance matrix, where {@code matrix[i][j]}
     * is the direct edge cost and {@link Integer#MAX_VALUE} means no edge.
     * O(V^3). Do not relax through an unreachable intermediate, or you will
     * overflow.
     *
     * @return a new matrix of all-pairs shortest distances.
     */
    public static int[][] floydWarshall(int[][] matrix) {
        throw new UnsupportedOperationException("TODO: ShortestPaths.floydWarshall");
    }
}
