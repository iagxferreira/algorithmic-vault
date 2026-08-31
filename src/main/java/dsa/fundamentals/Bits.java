package dsa.fundamentals;

import java.util.List;

/**
 * Bit manipulation, mostly as a way to represent sets cheaply.
 *
 * <p>Why it matters: an int is 32 booleans. Once you can treat a number as a
 * set, subset enumeration, "visited" masks in travelling-salesman style dynamic
 * programming, and a pile of counting tricks all become one loop over
 * {@code 0..2^n}.
 *
 * <p>Worth memorising: {@code x & (x - 1)} clears the lowest set bit,
 * {@code x & -x} isolates it, and xor-ing a value with itself cancels out,
 * which is why xor finds the unpaired element.
 */
public final class Bits {

    private Bits() {
    }

    /** Number of set bits (population count). */
    public static int countOnes(int value) {
        throw new UnsupportedOperationException("TODO: Bits.countOnes");
    }

    /** Value of the lowest set bit, e.g. 12 gives 4; 0 gives 0. */
    public static int lowestSetBit(int value) {
        throw new UnsupportedOperationException("TODO: Bits.lowestSetBit");
    }

    /** True when exactly one bit is set. */
    public static boolean isPowerOfTwo(int value) {
        throw new UnsupportedOperationException("TODO: Bits.isPowerOfTwo");
    }

    /** True when bit {@code index} of {@code mask} is set. */
    public static boolean isSet(int mask, int index) {
        throw new UnsupportedOperationException("TODO: Bits.isSet");
    }

    /** {@code mask} with bit {@code index} set. */
    public static int set(int mask, int index) {
        throw new UnsupportedOperationException("TODO: Bits.set");
    }

    /** {@code mask} with bit {@code index} cleared. */
    public static int clear(int mask, int index) {
        throw new UnsupportedOperationException("TODO: Bits.clear");
    }

    /**
     * Every subset of {@code values}, enumerated by counting masks from 0 to
     * {@code 2^n - 1} and picking the elements whose bit is set. Ordered by
     * mask value.
     */
    public static List<List<Integer>> subsets(int[] values) {
        throw new UnsupportedOperationException("TODO: Bits.subsets");
    }

    /**
     * The one value that appears an odd number of times, everything else
     * appearing twice. Xor the whole array. O(n) time, O(1) space.
     */
    public static int singleNumber(int[] values) {
        throw new UnsupportedOperationException("TODO: Bits.singleNumber");
    }

    /** {@code countOnes(i)} for every i in {@code [0, n]}, in O(n) using earlier answers. */
    public static int[] countOnesUpTo(int n) {
        throw new UnsupportedOperationException("TODO: Bits.countOnesUpTo");
    }
}
