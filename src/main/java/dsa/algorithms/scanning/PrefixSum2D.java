package dsa.algorithms.scanning;

/**
 * Prefix sums in two dimensions - rectangle sums in O(1).
 *
 * <p>Each cell adds the cell above and the cell to the left, then subtracts
 * the overlap that was counted twice. Queries do the same inclusion-exclusion
 * in reverse: bottom-right, minus the strip above, minus the strip left, plus
 * the corner you removed twice.
 *
 * <p>Draw the four rectangles on paper once. Guessing the signs is how this
 * goes wrong, and it is the only difficulty in the whole class.
 *
 * <p>The array is padded to {@code (rows + 1) x (cols + 1)} for the same
 * reason as the one-dimensional version.
 *
 * <p>Target: O(rows * cols) build, O(1) per query.
 *
 * <p>See {@code docs/algorithms/prefix-sums.md} for what to understand first.
 */
public final class PrefixSum2D {

    private PrefixSum2D() {
    }

    /** Padded 2d prefix sums, {@code (rows + 1) x (cols + 1)}. */
    public static int[][] build(int[][] grid) {
        throw new UnsupportedOperationException("TODO: PrefixSum2D.build");
    }

    /** Sum of the inclusive rectangle from a {@link #build} array. */
    public static int rangeSum(int[][] prefix, int row1, int col1, int row2, int col2) {
        throw new UnsupportedOperationException("TODO: PrefixSum2D.rangeSum");
    }
}
