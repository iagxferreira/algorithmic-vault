package dsa.algorithms.sorting;

/**
 * Quickselect - the k-th smallest element without sorting.
 *
 * <p>Partition, then recurse into only the side that contains k. Discarding
 * half the work each time is what turns quicksort's O(n log n) into O(n)
 * expected: n + n/2 + n/4 + ... is 2n.
 *
 * <p>Target: O(n) expected, O(n^2) worst case, O(1) extra space.
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class QuickSelect {

    private QuickSelect() {
    }

    /** The k-th smallest value, 0-indexed. May reorder the input. */
    public static int kthSmallest(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: QuickSelect.kthSmallest");
    }
}
