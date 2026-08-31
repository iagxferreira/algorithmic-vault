package dsa.algorithms.search;

/**
 * Binary search on a sorted array - the base case.
 *
 * <p>Halve the range until the target is found or the range is empty. Get the
 * loop shape into muscle memory here, because every other class in this
 * package is a variation on it.
 *
 * <p>Target: O(log n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/binary-search.md} for what to understand first.
 */
public final class BinarySearch {

    private BinarySearch() {
    }

    /** Index of {@code target} in a sorted array, or -1. */
    public static int search(int[] sorted, int target) {
        throw new UnsupportedOperationException("TODO: BinarySearch.search");
    }
}
