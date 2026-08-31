package dsa.usage;

/**
 * Driving arrays and {@link java.util.Arrays} the easy way.
 *
 * <p>Arrays are the fastest thing in Java and the least forgiving. These are
 * the library calls that save you from writing loops, plus the two places the
 * library will quietly mislead you:
 *
 * <ul>
 *   <li>{@code Arrays.asList(intArray)} does <b>not</b> give you a list of
 *       ints. It gives a single-element {@code List<int[]>}, because an
 *       {@code int[]} is one object. Use a stream, or box first.
 *   <li>{@code Arrays.toString} prints one dimension;
 *       {@code Arrays.deepToString} is the one for nested arrays. Similarly
 *       {@code equals} versus {@code deepEquals}.
 *   <li>A 2D array is an array of row references. {@code clone()} copies only
 *       the outer array, so the rows stay shared - that is a shallow copy and
 *       it will bite you.
 * </ul>
 */
public final class ArrayUsage {

    private ArrayUsage() {
    }

    /** A copy of the array with the given length, truncated or zero-padded. */
    public static int[] resized(int[] values, int length) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.resized");
    }

    /** The half-open slice {@code [from, to)} as a new array. */
    public static int[] slice(int[] values, int from, int to) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.slice");
    }

    /** A new array of {@code length} filled with {@code value}. */
    public static int[] filled(int length, int value) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.filled");
    }

    /** A sorted copy, ascending; the input is unchanged. */
    public static int[] sortedCopy(int[] values) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.sortedCopy");
    }

    /**
     * A sorted copy, descending. There is no comparator overload for
     * {@code int[]}, so box, sort with a comparator, and unbox.
     */
    public static int[] sortedDescendingCopy(int[] values) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.sortedDescendingCopy");
    }

    /** Rows sorted by their first element, ascending. Sorts the given array in place. */
    public static int[][] sortRowsByFirstColumn(int[][] rows) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.sortRowsByFirstColumn");
    }

    /** Index of {@code target} in a sorted array, or -1. Use the library here, not your own loop. */
    public static int indexInSorted(int[] sorted, int target) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.indexInSorted");
    }

    /** The two arrays joined end to end. */
    public static int[] concat(int[] a, int[] b) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.concat");
    }

    /** A true deep copy of a 2D array: changing a row of the copy must not change the original. */
    public static int[][] deepCopy(int[][] grid) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.deepCopy");
    }

    /** The grid transposed, so {@code result[c][r]} is {@code grid[r][c]}. */
    public static int[][] transpose(int[][] grid) {
        throw new UnsupportedOperationException("TODO: ArrayUsage.transpose");
    }
}
