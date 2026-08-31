package dsa.fundamentals;

import java.util.List;

/**
 * Cheapest set of edges that keeps every vertex connected.
 *
 * <p>Two greedy algorithms, both correct, differing in what they grow:
 *
 * <ul>
 *   <li><b>Kruskal</b> - sort all edges by weight and add an edge whenever its
 *       endpoints are not already connected. That "already connected?" test is
 *       exactly {@link dsa.structures.UnionFind}. O(E log E).
 *   <li><b>Prim</b> - grow one tree outwards, repeatedly taking the cheapest
 *       edge leaving it, using a min-heap. Structurally it is Dijkstra with
 *       edge weight instead of path length. O(E log V).
 * </ul>
 */
public final class MinimumSpanningTree {

    private MinimumSpanningTree() {
    }

    /**
     * Total weight of a minimum spanning tree, with edges given as
     * {@code {from, to, weight}} over an undirected graph.
     *
     * @return -1 when the graph is disconnected, so no spanning tree exists.
     */
    public static int kruskal(int vertexCount, int[][] edges) {
        throw new UnsupportedOperationException("TODO: MinimumSpanningTree.kruskal");
    }

    /**
     * The chosen edges of a minimum spanning tree, each as
     * {@code {from, to, weight}} with {@code from < to}, sorted by weight then
     * by endpoints. Empty when the graph is disconnected.
     */
    public static List<int[]> kruskalEdges(int vertexCount, int[][] edges) {
        throw new UnsupportedOperationException("TODO: MinimumSpanningTree.kruskalEdges");
    }

    /**
     * Total weight of a minimum spanning tree grown from vertex 0, with the
     * graph as {@code adjacency.get(v)} holding {@code {neighbour, weight}}.
     *
     * @return -1 when the graph is disconnected.
     */
    public static int prim(List<List<int[]>> adjacency) {
        throw new UnsupportedOperationException("TODO: MinimumSpanningTree.prim");
    }
}
