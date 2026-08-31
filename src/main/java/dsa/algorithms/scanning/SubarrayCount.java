package dsa.algorithms.scanning;

/**
 * Counting subarrays with a prefix sum and a hash map.
 *
 * <p>The most reused counting trick in the subject. At index j, the number of
 * subarrays ending here that sum to {@code k} is how many times the value
 * {@code prefix[j] - k} has already been seen. One pass, one map.
 *
 * <p>Note what this is <b>not</b>: a sliding window. With negative values the
 * running sum is not monotonic in the window size, so growing and shrinking a
 * window is simply wrong here. Knowing which of the two a problem needs is the
 * skill.
 *
 * <p>Target: O(n) time, O(n) space.
 *
 * <p>See {@code docs/algorithms/prefix-sums.md} for what to understand first.
 */
public final class SubarrayCount {

    private SubarrayCount() {
    }

    /** Number of contiguous subarrays summing to exactly {@code k}. */
    public static int withSum(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: SubarrayCount.withSum");
    }

    /**
     * Length of the longest contiguous subarray summing to exactly {@code k},
     * or 0. Same map, storing the first index each prefix was seen at rather
     * than a count.
     */
    public static int longestWithSum(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: SubarrayCount.longestWithSum");
    }
}
