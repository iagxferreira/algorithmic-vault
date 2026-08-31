package dsa.algorithms.search;

/**
 * Binary search on unsorted data.
 *
 * <p>A peak is an element strictly greater than both neighbours, with out of
 * bounds counting as negative infinity. The array is <b>not sorted</b>, and
 * binary search still works - which is the reason this exercise exists.
 *
 * <p>The argument: if {@code values[mid] < values[mid + 1]} then the right
 * half must contain a peak, because either it keeps rising to the edge or it
 * turns somewhere. Always walk uphill and you cannot miss.
 *
 * <p>Target: O(log n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/binary-search.md} for what to understand first.
 */
public final class FindPeak {

    private FindPeak() {
    }

    /** Index of any peak. Adjacent values are never equal. */
    public static int findPeak(int[] values) {
        throw new UnsupportedOperationException("TODO: FindPeak.findPeak");
    }
}
