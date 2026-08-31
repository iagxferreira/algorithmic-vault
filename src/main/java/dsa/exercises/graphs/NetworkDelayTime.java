package dsa.exercises.graphs;

/**
 * Network Delay Time.
 *
 * <p>{@code times[i] = {from, to, weight}} are directed travel times over
 * nodes labelled {@code 1..n}. A signal starts at {@code source}. Return how
 * long until every node has it, or -1 when some node is unreachable.
 *
 * <p>Example: {@code [[2,1,1],[2,3,1],[3,4,1]], n = 4, source = 2} gives 2.
 *
 * <p>Dijkstra with a twist at the end: the answer is not one distance but the
 * largest of them, since the signal is done only when the slowest node has it.
 * O(E log V).
 */
public final class NetworkDelayTime {

    public static int solve(int[][] times, int n, int source) {
        throw new UnsupportedOperationException("TODO: NetworkDelayTime.solve");
    }
}
