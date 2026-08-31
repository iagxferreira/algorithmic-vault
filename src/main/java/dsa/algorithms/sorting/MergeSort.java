package dsa.algorithms.sorting;

/**
 * Merge sort - the divide and conquer template.
 *
 * <p>Split in half, sort each half, merge the two sorted halves. The merge is the part worth getting right: walk two pointers and copy the smaller head. Stable, and the only comparison sort here with a guaranteed O(n log n).
 *
 * <p>Target: O(n log n) time always, O(n) extra space, stable
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class MergeSort {

    private MergeSort() {
    }

    /** Sorts ascending, in place where possible, and returns the array. */
    public static int[] sort(int[] values) {
        throw new UnsupportedOperationException("TODO: MergeSort.sort");
    }
}
