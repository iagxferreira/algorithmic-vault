package dsa.algorithms.sorting;

/**
 * Heap sort.
 *
 * <p>Build a max-heap over the array in place, then repeatedly swap the root to the end and sift the new root down over the shrinking heap. O(n log n) guaranteed with O(1) extra space, which neither merge nor quicksort gives you.
 *
 * <p>Target: O(n log n) time always, O(1) space, not stable
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class HeapSort {

    private HeapSort() {
    }

    /** Sorts ascending, in place where possible, and returns the array. */
    public static int[] sort(int[] values) {
        throw new UnsupportedOperationException("TODO: HeapSort.sort");
    }
}
