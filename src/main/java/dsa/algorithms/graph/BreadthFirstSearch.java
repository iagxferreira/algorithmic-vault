package dsa.algorithms.graph;

import java.util.List;

/**
 * Breadth-first search - expand in rings.
 *
 * <p>BFS reaches every vertex by the fewest hops, because it finishes
 * distance k entirely before starting distance k+1. That is why it, and not
 * DFS, answers shortest-path questions on an <b>unweighted</b> graph.
 *
 * <p>Once edges have differing weights this guarantee is gone and you need
 * {@link Dijkstra} instead. Knowing exactly where BFS stops being enough is
 * the point of this class.
 *
 * <p>Target: O(V + E) time, O(V) space.
 *
 * <p>See {@code docs/algorithms/graph-traversal.md} for what to understand first.
 */
public final class BreadthFirstSearch {

    private BreadthFirstSearch() {
    }

    /** Vertices in breadth-first order from {@code start}. */
    public static List<Integer> traverse(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: BreadthFirstSearch.traverse");
    }

    /**
     * Hops from {@code start} to every vertex, with -1 for unreachable ones.
     * This is the traversal with a distance array instead of a visited set.
     */
    public static int[] distancesFrom(List<List<Integer>> adjacency, int start) {
        throw new UnsupportedOperationException("TODO: BreadthFirstSearch.distancesFrom");
    }

    /**
     * A shortest vertex path from {@code start} to {@code end} inclusive, or
     * an empty list when unreachable. Record each vertex's parent as you
     * discover it, then walk the parents backwards at the end.
     */
    public static List<Integer> shortestPath(List<List<Integer>> adjacency, int start, int end) {
        throw new UnsupportedOperationException("TODO: BreadthFirstSearch.shortestPath");
    }

    /**
     * Hops from the nearest of several starts, all seeded into the queue at
     * once. Multi-source bfs, which is what grid problems like spreading rot
     * or nearest-zero actually need - one search, not one per source.
     */
    public static int[] distancesFromAny(List<List<Integer>> adjacency, int[] starts) {
        throw new UnsupportedOperationException("TODO: BreadthFirstSearch.distancesFromAny");
    }
}
