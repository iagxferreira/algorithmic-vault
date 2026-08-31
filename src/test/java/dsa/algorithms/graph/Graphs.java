package dsa.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/** Builds the adjacency lists the graph tests consume. Test-only plumbing. */
final class Graphs {

    private Graphs() {
    }

    /** Unweighted adjacency list from {@code {from, to}} pairs. */
    static List<List<Integer>> unweighted(int vertices, int[][] edges, boolean directed) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            if (!directed) {
                adjacency.get(edge[1]).add(edge[0]);
            }
        }
        return adjacency;
    }

    /** Weighted adjacency list from {@code {from, to, weight}} triples. */
    static List<List<int[]>> weighted(int vertices, int[][] edges, boolean directed) {
        List<List<int[]>> adjacency = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(new int[] {edge[1], edge[2]});
            if (!directed) {
                adjacency.get(edge[1]).add(new int[] {edge[0], edge[2]});
            }
        }
        return adjacency;
    }

    /**
     * <pre>
     *   0 - 1 - 3      5
     *   |
     *   2 - 4
     * </pre>
     */
    static List<List<Integer>> sample() {
        return unweighted(6, new int[][] {{0, 1}, {0, 2}, {1, 3}, {2, 4}}, false);
    }
}
