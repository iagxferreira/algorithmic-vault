package dsa.algorithms.graph;

/**
 * Floyd-Warshall - cheapest paths between <b>every</b> pair.
 *
 * <p>Three nested loops with {@code k} outermost, asking one question at a
 * time: "is going through k better than going direct?". The loop order is not
 * negotiable - k has to be outside, because the invariant is "distances using
 * only intermediates from {@code 0..k}".
 *
 * <p>Input is a dense matrix where {@code matrix[i][j]} is the direct edge
 * cost and {@link Integer#MAX_VALUE} means no edge.
 *
 * <p>Target: O(V^3) time, O(V^2) space. Only viable for small V - but for
 * small V it is five lines and beats running Dijkstra V times.
 *
 * <p>See {@code docs/algorithms/shortest-paths.md} for what to understand first.
 */
public final class FloydWarshall {

    private FloydWarshall() {
    }

    /** A new all-pairs distance matrix; the input is not modified. */
    public static int[][] distances(int[][] matrix) {
        throw new UnsupportedOperationException("TODO: FloydWarshall.distances");
    }
}
