package dsa.algorithms.graph;

import java.util.List;

/**
 * Counting and labelling the disconnected pieces of an undirected graph.
 *
 * <p>The pattern: loop over every vertex, and start a fresh search from any
 * one you have not visited. The number of searches you had to start is the
 * number of components. That outer loop is what people forget - a single
 * traversal only ever sees one component.
 *
 * <p>Compare with {@link dsa.structures.UnionFind}, which answers the same
 * question incrementally as edges arrive rather than all at once.
 *
 * <p>Target: O(V + E) time, O(V) space.
 *
 * <p>See {@code docs/algorithms/graph-traversal.md} for what to understand first.
 */
public final class ConnectedComponents {

    private ConnectedComponents() {
    }

    /** How many connected components the graph has. */
    public static int count(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: ConnectedComponents.count");
    }

    /**
     * Component id per vertex, numbered from 0 in order of first discovery,
     * so vertex 0 is always in component 0.
     */
    public static int[] labels(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: ConnectedComponents.labels");
    }

    /** Size of the largest component; 0 for a graph with no vertices. */
    public static int largestComponentSize(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: ConnectedComponents.largestComponentSize");
    }
}
