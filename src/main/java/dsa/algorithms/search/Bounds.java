package dsa.algorithms.search;

/**
 * Lower and upper bound - binary search that answers "where does it belong?".
 *
 * <p>Plain search fails on duplicates: it finds <em>an</em> index, not the
 * first or last. Bounds fix that, and they are also what you want when the
 * target is absent - {@code lowerBound} is exactly the insertion point.
 *
 * <p>These two are the most reused searches in practice. C++ ships them;
 * Java does not, so you write them.
 *
 * <p>Target: O(log n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/binary-search.md} for what to understand first.
 */
public final class Bounds {

    private Bounds() {
    }

    /** First index whose value is >= target, or {@code sorted.length}. */
    public static int lowerBound(int[] sorted, int target) {
        throw new UnsupportedOperationException("TODO: Bounds.lowerBound");
    }

    /** First index whose value is > target, or {@code sorted.length}. */
    public static int upperBound(int[] sorted, int target) {
        throw new UnsupportedOperationException("TODO: Bounds.upperBound");
    }

    /**
     * First and last index of target as {@code [first, last]}, or
     * {@code [-1, -1]}. Both bounds give this away once they work.
     */
    public static int[] firstAndLastOccurrence(int[] sorted, int target) {
        throw new UnsupportedOperationException("TODO: Bounds.firstAndLastOccurrence");
    }

    /** How many times target occurs. One subtraction once you have the bounds. */
    public static int countOccurrences(int[] sorted, int target) {
        throw new UnsupportedOperationException("TODO: Bounds.countOccurrences");
    }
}
