package dsa.algorithms.search;

/**
 * Binary search on a sorted array that has been rotated at an unknown pivot,
 * for example {@code [4, 5, 6, 7, 0, 1, 2]}.
 *
 * <p>The array is not sorted, yet binary search still works. The reason is the
 * only thing to understand here: whichever side of {@code mid} you look at,
 * <b>at least one half is always properly sorted</b>. Work out which, decide
 * whether the target lies inside it, and discard the other half.
 *
 * <p>Target: O(log n) time, O(1) space. Values are distinct.
 *
 * <p>See {@code docs/algorithms/binary-search.md} for what to understand first.
 */
public final class RotatedArray {

    private RotatedArray() {
    }

    /** Index of {@code target}, or -1. */
    public static int search(int[] rotated, int target) {
        throw new UnsupportedOperationException("TODO: RotatedArray.search");
    }

    /** The smallest value, i.e. the rotation point. */
    public static int findMin(int[] rotated) {
        throw new UnsupportedOperationException("TODO: RotatedArray.findMin");
    }
}
