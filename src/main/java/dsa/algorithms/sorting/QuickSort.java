package dsa.algorithms.sorting;

/**
 * Quicksort - the partitioning template.
 *
 * <p>Partition around a pivot so smaller values end up left and larger right, then recurse into both sides. No merge step is needed because the pivot is already in its final place. See {@link Partition}, which is the piece doing the work.
 *
 * <p>Target: O(n log n) expected, O(n^2) worst case, O(log n) stack
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class QuickSort {

    private QuickSort() {
    }

    /** Sorts ascending, in place where possible, and returns the array. */
    public static int[] sort(int[] values) {
        throw new UnsupportedOperationException("TODO: QuickSort.sort");
    }
}
