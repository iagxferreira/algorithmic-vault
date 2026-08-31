package dsa.algorithms.sorting;

/**
 * Counting inversions - merge sort put to work on something other than sorting.
 *
 * <p>An inversion is a pair {@code i < j} with {@code values[i] > values[j]},
 * i.e. a measure of how far from sorted the array is. Counting them by double
 * loop is O(n^2); counting them during a merge is O(n log n), because when you
 * take an element from the right half, every element still waiting in the left
 * half is inverted with it - a whole block settled by one comparison.
 *
 * <p>Target: O(n log n) time, O(n) space.
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class CountInversions {

    private CountInversions() {
    }

    /** Number of inverted pairs. Use long: the count reaches n*(n-1)/2. */
    public static long count(int[] values) {
        throw new UnsupportedOperationException("TODO: CountInversions.count");
    }
}
