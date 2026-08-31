package dsa.algorithms.graph;

import java.util.List;

/**
 * Two-colouring an undirected graph.
 *
 * <p>A graph is bipartite when its vertices split into two groups with every
 * edge crossing between them - "can these be divided into two teams with no
 * conflicts inside either". Colour greedily during a traversal, giving each
 * neighbour the opposite colour, and fail if an edge ever joins two vertices
 * of the same colour.
 *
 * <p>The theorem worth knowing: a graph is bipartite exactly when it contains
 * no odd-length cycle.
 *
 * <p>Remember to check <em>every</em> component - a disconnected graph can
 * hide the odd cycle away from vertex 0.
 *
 * <p>Target: O(V + E) time, O(V) space.
 *
 * <p>See {@code docs/algorithms/graph-traversal.md} for what to understand first.
 */
public final class Bipartite {

    private Bipartite() {
    }

    public static boolean isBipartite(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: Bipartite.isBipartite");
    }

    /**
     * The 0/1 colour of each vertex, or null when the graph is not bipartite.
     * Vertex 0 of each component starts at colour 0.
     */
    public static int[] colours(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: Bipartite.colours");
    }
}
