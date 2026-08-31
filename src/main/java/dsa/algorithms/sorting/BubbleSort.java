package dsa.algorithms.sorting;

/**
 * Bubble sort.
 *
 * <p>Repeatedly swap adjacent out-of-order pairs. Each full pass floats the largest remaining value to the end, so after k passes the last k slots are final. Track whether a pass made any swap: if none did, the array is sorted and you can stop early.
 *
 * <p>Target: O(n^2) time, O(1) space, O(n) on already-sorted input with the early exit
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class BubbleSort {

    private BubbleSort() {
    }

    /** Sorts ascending, in place where possible, and returns the array. */
    public static int[] sort(int[] values) {
        throw new UnsupportedOperationException("TODO: BubbleSort.sort");
    }
}
