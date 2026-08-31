package dsa.algorithms.graph;

import java.util.List;

/**
 * Kruskal's algorithm - a minimum spanning tree, cheapest edge first.
 *
 * <p>Sort every edge by weight and take each one whose endpoints are not
 * already connected. That "already connected?" test is exactly
 * {@link dsa.structures.UnionFind} - build that first and this becomes about
 * ten lines.
 *
 * <p>Edges are {@code {from, to, weight}} over an undirected graph.
 *
 * <p>Target: O(E log E) time, dominated by the sort.
 *
 * <p>See {@code docs/algorithms/shortest-paths.md} for what to understand first.
 */
public final class Kruskal {

    private Kruskal() {
    }

    /** Total weight of a minimum spanning tree, or -1 when the graph is disconnected. */
    public static int totalWeight(int vertexCount, int[][] edges) {
        throw new UnsupportedOperationException("TODO: Kruskal.totalWeight");
    }

    /**
     * The chosen edges as {@code {from, to, weight}} with {@code from < to},
     * sorted by weight then by endpoints. Empty when disconnected.
     */
    public static List<int[]> edges(int vertexCount, int[][] edges) {
        throw new UnsupportedOperationException("TODO: Kruskal.edges");
    }
}
