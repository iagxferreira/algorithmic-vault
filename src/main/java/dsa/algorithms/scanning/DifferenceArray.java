package dsa.algorithms.scanning;

/**
 * The mirror image of a prefix sum: many range <b>updates</b>, one read.
 *
 * <p>A prefix sum makes reads cheap after the array is fixed. A difference
 * array makes writes cheap when you only read at the end: to add {@code v}
 * across {@code [a, b]}, record {@code +v} at {@code a} and {@code -v} at
 * {@code b + 1}, and prefix-sum the whole thing once when you are done.
 *
 * <p>That turns m range updates from O(n * m) into O(n + m), which is the
 * difference between passing and timing out on the problems that use it.
 *
 * <p>Target: O(n + updates) time, O(n) space.
 *
 * <p>See {@code docs/algorithms/prefix-sums.md} for what to understand first.
 */
public final class DifferenceArray {

    private DifferenceArray() {
    }

    /**
     * Applies updates given as {@code {from, to, delta}} to an array of
     * {@code length} zeroes and returns the final array.
     */
    public static int[] applyRangeUpdates(int length, int[][] updates) {
        throw new UnsupportedOperationException("TODO: DifferenceArray.applyRangeUpdates");
    }

    /**
     * The largest final value after the same updates. Sums can exceed int
     * range on real inputs, which is why this returns long.
     */
    public static long maxAfterRangeUpdates(int length, int[][] updates) {
        throw new UnsupportedOperationException("TODO: DifferenceArray.maxAfterRangeUpdates");
    }
}
