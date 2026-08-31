package dsa.algorithms.numbers;

/**
 * Xor as a cancelling accumulator.
 *
 * <p>Xor is associative, commutative, and {@code x ^ x == 0}. Together that
 * means xoring a whole collection makes every duplicated value vanish and
 * leaves exactly what appeared an odd number of times - in O(n) time and O(1)
 * space, where the obvious solution needs a hash map.
 *
 * <p>{@link #missingNumber} is the same idea used differently: xor the values
 * against the indices and everything paired cancels.
 *
 * <p>Target: O(n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/bits.md} for what to understand first.
 */
public final class XorTricks {

    private XorTricks() {
    }

    /** The one value appearing an odd number of times; everything else appears twice. */
    public static int singleNumber(int[] values) {
        throw new UnsupportedOperationException("TODO: XorTricks.singleNumber");
    }

    /** The one value in {@code [0, n]} missing from an array of n distinct values. */
    public static int missingNumber(int[] values) {
        throw new UnsupportedOperationException("TODO: XorTricks.missingNumber");
    }

    /** Swaps two array slots without a temporary. A party trick - but understand why it works. */
    public static void swapInPlace(int[] values, int i, int j) {
        throw new UnsupportedOperationException("TODO: XorTricks.swapInPlace");
    }
}
