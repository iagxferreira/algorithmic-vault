package dsa.algorithms.graph;

import java.util.List;

/**
 * Prim's algorithm - a minimum spanning tree, grown outwards from one vertex.
 *
 * <p>Keep one growing tree and repeatedly take the cheapest edge leaving it,
 * using a min-heap. Structurally this is {@link Dijkstra} with the priority
 * changed from "cost of the path here" to "cost of the single edge in" -
 * putting the two side by side is the best way to see what each one actually
 * optimises.
 *
 * <p>Graph as {@code adjacency.get(v)} holding {@code {neighbour, weight}}.
 * The tree is grown from vertex 0.
 *
 * <p>Target: O(E log V) time. Better than Kruskal on dense graphs, where
 * sorting every edge is the bottleneck.
 *
 * <p>See {@code docs/algorithms/shortest-paths.md} for what to understand first.
 */
public final class Prim {

    private Prim() {
    }

    /** Total weight of a minimum spanning tree, or -1 when the graph is disconnected. */
    public static int totalWeight(List<List<int[]>> adjacency) {
        throw new UnsupportedOperationException("TODO: Prim.totalWeight");
    }
}
