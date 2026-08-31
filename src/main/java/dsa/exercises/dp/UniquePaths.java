package dsa.exercises.dp;

/**
 * Unique Paths.
 *
 * <p>Number of paths from the top-left to the bottom-right of a
 * {@code rows x cols} grid, moving only right or down.
 *
 * <p>Example: a 3 x 7 grid gives 28.
 *
 * <p>Every cell is reached from above or from the left, so the table is a sum
 * of its two neighbours. One row of state is enough, updated in place. Worth
 * noticing afterwards that the answer is a binomial coefficient, which is the
 * combinatorial way to see the same count.
 */
public final class UniquePaths {

    public static int solve(int rows, int cols) {
        throw new UnsupportedOperationException("TODO: UniquePaths.solve");
    }
}
