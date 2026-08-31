package dsa.fundamentals;

import java.util.List;

/**
 * Depth-first and breadth-first search, and the questions they answer.
 *
 * <p>Graphs arrive here as an adjacency list: {@code adjacency.get(v)} is the
 * list of vertices reachable from {@code v} in one hop, and vertices are
 * {@code 0..n-1}. Build one with {@link dsa.structures.Graph#adjacency()}.
 *
 * <p>DFS and BFS are the same algorithm with a different container. DFS uses a
 * stack (usually the call stack) and dives; BFS uses a queue and expands in
 * rings. That difference decides what each is good for:
 *
 * <ul>
 *   <li><b>DFS</b> - connectivity, cycle detection, topological order,
 *       anything about the structure of the exploration itself.
 *   <li><b>BFS</b> - shortest paths when every edge costs the same, because
 *       the first time you reach a vertex you have reached it in the fewest
 *       hops.
 * </ul>
 *
 * <p>Whenever several vertices are equally valid candidates, visit the
 * smallest index first, so the output is deterministic.
 *
 * <p>Target complexity: O(V + E) time, O(V) space.
 */
public final class GraphTraversal {

    private GraphTraversal() {
    }

    /** Vertices in the order a recursive dfs from {@code start} first sees them. */
    public static List<Integer> dfs(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.dfs");
    }

    /**
     * The same order as {@link #dfs}, but driven by an explicit stack instead
     * of recursion. Watch the push order: to pop the smallest neighbour first
     * you have to push the neighbours in reverse.
     */
    public static List<Integer> dfsIterative(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.dfsIterative");
    }

    /** Vertices in breadth-first order from {@code start}. */
    public static List<Integer> bfs(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.bfs");
    }

    /**
     * Hops from {@code start} to every vertex, with -1 for unreachable ones.
     * This is bfs with a distance array instead of a visited set.
     */
    public static int[] distancesFrom(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.distancesFrom");
    }

    /**
     * A shortest vertex path from {@code start} to {@code end} inclusive, or an
     * empty list when unreachable. Record each vertex's parent during the bfs
     * and walk the parents backwards at the end.
     */
    public static List<Integer> shortestPath(List<List<Integer>> adjacency, int start, int end) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.shortestPath");
    }

    /** Number of connected components in an undirected graph. */
    public static int countComponents(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.countComponents");
    }

    /**
     * True when an undirected graph contains a cycle. Careful: the edge you
     * just came in on is not a cycle, so pass the parent down and skip it.
     */
    public static boolean hasCycleUndirected(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.hasCycleUndirected");
    }

    /**
     * True when a directed graph contains a cycle. Colour each vertex white,
     * grey (on the current dfs path) or black (finished); an edge into a grey
     * vertex is a back edge, hence a cycle.
     */
    public static boolean hasCycleDirected(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.hasCycleDirected");
    }

    /**
     * A topological order of a directed acyclic graph, or an empty list when
     * the graph has a cycle. Kahn's algorithm: repeatedly take a vertex with
     * in-degree zero (smallest index first) and remove its edges.
     */
    public static List<Integer> topologicalSort(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.topologicalSort");
    }

    /**
     * True when the undirected graph is bipartite, i.e. two-colourable. Colour
     * greedily during a bfs and fail when an edge joins two same-coloured
     * vertices.
     */
    public static boolean isBipartite(List<List<Integer>> adjacency) {
        throw new UnsupportedOperationException("TODO: GraphTraversal.isBipartite");
    }
}
