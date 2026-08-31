package dsa.algorithms.sorting;

/**
 * Insertion sort.
 *
 * <p>Grow a sorted prefix: take the next element and shift it back until it lands. This is how people sort playing cards, and it is genuinely the fastest option on small or nearly-sorted input, which is why real library sorts fall back to it below ~32 elements.
 *
 * <p>Target: O(n^2) time worst case, O(n) on nearly-sorted input, O(1) space
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class InsertionSort {

    private InsertionSort() {
    }

    /** Sorts ascending, in place where possible, and returns the array. */
    public static int[] sort(int[] values) {
        throw new UnsupportedOperationException("TODO: InsertionSort.sort");
    }
}
