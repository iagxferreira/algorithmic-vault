package dsa.algorithms.numbers;

/**
 * Reading and writing individual bits.
 *
 * <p>Three identities worth memorising, because everything else is built from
 * them:
 *
 * <ul>
 *   <li>{@code x & (x - 1)} clears the lowest set bit
 *   <li>{@code x & -x} isolates the lowest set bit
 *   <li>{@code x ^ x == 0}, which is why xor cancels pairs
 * </ul>
 *
 * <p>Target: O(1) per operation, or O(set bits) where a loop is involved.
 *
 * <p>See {@code docs/algorithms/bits.md} for what to understand first.
 */
public final class BitBasics {

    private BitBasics() {
    }

    /** Number of set bits (population count). */
    public static int countOnes(int value) {
        throw new UnsupportedOperationException("TODO: BitBasics.countOnes");
    }

    /** Value of the lowest set bit, so 12 gives 4; 0 gives 0. */
    public static int lowestSetBit(int value) {
        throw new UnsupportedOperationException("TODO: BitBasics.lowestSetBit");
    }

    /** True when exactly one bit is set. Negatives and 0 are not powers of two. */
    public static boolean isPowerOfTwo(int value) {
        throw new UnsupportedOperationException("TODO: BitBasics.isPowerOfTwo");
    }

    /** True when bit {@code index} of {@code mask} is set. */
    public static boolean isSet(int mask, int index) {
        throw new UnsupportedOperationException("TODO: BitBasics.isSet");
    }

    /** {@code mask} with bit {@code index} set. */
    public static int set(int mask, int index) {
        throw new UnsupportedOperationException("TODO: BitBasics.set");
    }

    /** {@code mask} with bit {@code index} cleared. */
    public static int clear(int mask, int index) {
        throw new UnsupportedOperationException("TODO: BitBasics.clear");
    }

    /** {@code mask} with bit {@code index} flipped. */
    public static int toggle(int mask, int index) {
        throw new UnsupportedOperationException("TODO: BitBasics.toggle");
    }

    /**
     * {@code countOnes(i)} for every i in {@code [0, n]}, in O(n). Each answer
     * is one more than the answer for {@code i & (i - 1)}, which you have
     * already computed.
     */
    public static int[] countOnesUpTo(int n) {
        throw new UnsupportedOperationException("TODO: BitBasics.countOnesUpTo");
    }
}
