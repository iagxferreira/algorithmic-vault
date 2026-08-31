package dsa.exercises.dp;

/**
 * Longest Increasing Subsequence.
 *
 * <p>Length of the longest strictly increasing subsequence; the elements need
 * not be adjacent.
 *
 * <p>Example: {@code [10, 9, 2, 5, 3, 7, 101, 18]} gives 4, for
 * {@code [2, 3, 7, 101]}.
 *
 * <p>Start with the O(n^2) version: {@code best(i)} is the longest sequence
 * ending at i. Then rewrite it in O(n log n) by keeping the smallest possible
 * tail for each length and binary searching where each value belongs. That
 * array is not itself a valid subsequence, only its length is meaningful.
 */
public final class LongestIncreasingSubsequence {

    public static int solve(int[] nums) {
        throw new UnsupportedOperationException("TODO: LongestIncreasingSubsequence.solve");
    }
}
