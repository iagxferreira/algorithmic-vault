package dsa.algorithms.scanning;

/**
 * Precompute once, answer range sums in O(1).
 *
 * <p>The cheapest trick there is. Build
 * {@code prefix[i] = values[0] + ... + values[i-1]} in one pass and every
 * range sum becomes a single subtraction.
 *
 * <p>The array is <b>exclusive</b> and has length {@code n + 1}, so
 * {@code prefix[0] == 0}. That off-by-one convention is deliberate: it removes
 * the special case at index 0 that otherwise appears in every caller.
 *
 * <p>Target: O(n) build, O(1) per query.
 *
 * <p>See {@code docs/algorithms/prefix-sums.md} for what to understand first.
 */
public final class PrefixSum {

    private PrefixSum() {
    }

    /** Exclusive prefix sums, length {@code values.length + 1}. */
    public static int[] build(int[] values) {
        throw new UnsupportedOperationException("TODO: PrefixSum.build");
    }

    /** Sum of the inclusive range {@code [from, to]} from a {@link #build} array. */
    public static int rangeSum(int[] prefix, int from, int to) {
        throw new UnsupportedOperationException("TODO: PrefixSum.rangeSum");
    }
}
