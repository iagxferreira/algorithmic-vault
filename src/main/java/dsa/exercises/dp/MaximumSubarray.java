package dsa.exercises.dp;

/**
 * Maximum Subarray (Kadane's algorithm).
 *
 * <p>Largest sum of any contiguous non-empty subarray.
 *
 * <p>Example: {@code [-2, 1, -3, 4, -1, 2, 1, -5, 4]} gives 6, for
 * {@code [4, -1, 2, 1]}.
 *
 * <p>The smallest interesting dynamic program. The state is "best sum of a
 * subarray ending exactly here", and the transition is a single decision:
 * extend the previous one, or start fresh. O(n) time, O(1) space.
 */
public final class MaximumSubarray {

    public static int solve(int[] nums) {
        throw new UnsupportedOperationException("TODO: MaximumSubarray.solve");
    }
}
