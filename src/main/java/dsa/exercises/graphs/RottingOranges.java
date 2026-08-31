package dsa.exercises.graphs;

/**
 * Rotting Oranges.
 *
 * <p>Cells hold 0 (empty), 1 (fresh) or 2 (rotten). Every minute, rot spreads
 * to the four orthogonal neighbours. Return the minutes until nothing fresh is
 * left, or -1 when some orange can never rot.
 *
 * <p>Example: {@code [[2,1,1],[1,1,0],[0,1,1]]} gives 4.
 *
 * <p>Multi-source bfs: seed the queue with every rotten cell at once and
 * expand level by level, where each level is one minute. Starting a separate
 * search per source would be both slower and wrong.
 */
public final class RottingOranges {

    public static int solve(int[][] grid) {
        throw new UnsupportedOperationException("TODO: RottingOranges.solve");
    }
}
