package dsa.exercises.graphs;

import java.util.List;

/**
 * Pacific Atlantic Water Flow.
 *
 * <p>Water flows from a cell to an orthogonal neighbour of equal or lower
 * height. The Pacific touches the top and left edges, the Atlantic the bottom
 * and right. Return every cell that can reach both, as {@code {row, col}}
 * pairs sorted by row then column.
 *
 * <p>Example: for the standard 5x5 grid the answer includes {@code {0, 4}} and
 * {@code {3, 0}}.
 *
 * <p>The trick is to reverse the question. Instead of asking "where can this
 * cell drain to", search <em>inland from each ocean</em>, walking uphill, and
 * intersect the two reachable sets. That turns O(cells^2) into O(cells).
 */
public final class PacificAtlanticWaterFlow {

    public static List<int[]> solve(int[][] heights) {
        throw new UnsupportedOperationException("TODO: PacificAtlanticWaterFlow.solve");
    }
}
