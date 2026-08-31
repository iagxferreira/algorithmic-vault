package dsa.algorithms.search;

/**
 * Binary search over a matrix.
 *
 * <p>Rows are sorted and each row starts after the previous one ends, so the
 * matrix is one sorted sequence folded into a grid. Treat it as a flat array
 * of length {@code rows * cols} and map an index back with {@code / cols} and
 * {@code % cols}. Doing that mapping - rather than searching row by row - is
 * the point.
 *
 * <p>Target: O(log(rows * cols)) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/binary-search.md} for what to understand first.
 */
public final class SearchMatrix {

    private SearchMatrix() {
    }

    public static boolean contains(int[][] matrix, int target) {
        throw new UnsupportedOperationException("TODO: SearchMatrix.contains");
    }
}
