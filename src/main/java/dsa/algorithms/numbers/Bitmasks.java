package dsa.algorithms.numbers;

import java.util.List;

/**
 * An int as a set of up to 32 elements.
 *
 * <p>This is what makes bit manipulation worth learning. Once a number
 * <em>is</em> a subset, enumerating all 2^n subsets is a single counting loop
 * from 0 to {@code 2^n - 1}, and "which cities have I already visited" fits in
 * one int - which is the whole basis of bitmask dynamic programming.
 *
 * <p>Target: O(n * 2^n) to enumerate every subset with its elements.
 *
 * <p>See {@code docs/algorithms/bits.md} for what to understand first.
 */
public final class Bitmasks {

    private Bitmasks() {
    }

    /**
     * Every subset of {@code values}, ordered by mask value - so the empty set
     * first and the full set last.
     */
    public static List<List<Integer>> subsets(int[] values) {
        throw new UnsupportedOperationException("TODO: Bitmasks.subsets");
    }

    /** The elements of {@code values} whose bit is set in {@code mask}. */
    public static List<Integer> elementsOf(int[] values, int mask) {
        throw new UnsupportedOperationException("TODO: Bitmasks.elementsOf");
    }

    /** Sum of the subset sums over every subset. */
    public static long totalOfAllSubsetSums(int[] values) {
        throw new UnsupportedOperationException("TODO: Bitmasks.totalOfAllSubsetSums");
    }
}
