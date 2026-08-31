package dsa.algorithms.sorting;

/**
 * Counting sort - a non-comparison sort.
 *
 * <p>Count how many times each value occurs, then rewrite the array from the counts. It beats O(n log n) because it never compares two elements, which is why the comparison-sort lower bound does not apply. Values here are in [0, 1000].
 *
 * <p>Target: O(n + k) time and O(k) space, where k is the value range
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class CountingSort {

    private CountingSort() {
    }

    /** Sorts ascending, in place where possible, and returns the array. */
    public static int[] sort(int[] values) {
        throw new UnsupportedOperationException("TODO: CountingSort.sort");
    }
}
