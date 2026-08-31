package dsa.structures;

import java.util.List;

/**
 * A graph stored as an adjacency list.
 *
 * <p>Why it matters: how you store the graph decides what is cheap. An
 * adjacency list is O(V + E) memory and lets you walk a vertex's neighbours
 * directly, which is what BFS and DFS need. An adjacency matrix costs O(V^2)
 * but answers "is there an edge?" in O(1).
 *
 * <p>{@code directed} decides whether {@link #addEdge(int, int)} also adds the
 * reverse edge.
 *
 * <p>Target complexity: addEdge O(1), neighbours O(deg(v)).
 */
public class Graph {

    private final int vertices;
    private final boolean directed;

    public Graph(int vertices, boolean directed) {
        this.vertices = vertices;
        this.directed = directed;
    }

    public int vertexCount() {
        throw new UnsupportedOperationException("TODO: Graph.vertexCount");
    }

    /** Number of edges; an undirected pair counts once. */
    public int edgeCount() {
        throw new UnsupportedOperationException("TODO: Graph.edgeCount");
    }

    public void addEdge(int from, int to) {
        throw new UnsupportedOperationException("TODO: Graph.addEdge");
    }

    /** Neighbours of {@code vertex}, in insertion order. */
    public List<Integer> neighbours(int vertex) {
        throw new UnsupportedOperationException("TODO: Graph.neighbours");
    }

    public boolean hasEdge(int from, int to) {
        throw new UnsupportedOperationException("TODO: Graph.hasEdge");
    }

    /** Number of edges leaving a vertex. */
    public int degree(int vertex) {
        throw new UnsupportedOperationException("TODO: Graph.degree");
    }

    /**
     * The whole adjacency list, indexed by vertex. Handy for feeding the
     * traversal exercises in {@code dsa.fundamentals}.
     */
    public List<List<Integer>> adjacency() {
        throw new UnsupportedOperationException("TODO: Graph.adjacency");
    }
}
