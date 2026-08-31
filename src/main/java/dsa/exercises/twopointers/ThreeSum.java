package dsa.exercises.twopointers;

import java.util.List;

/**
 * 3Sum.
 *
 * <p>Every unique triple that sums to zero. No duplicate triples in the output.
 * Sort each triple ascending, and order the result lexicographically.
 *
 * <p>Example: {@code [-1, 0, 1, 2, -1, -4]} gives {@code [[-1, -1, 2], [-1, 0, 1]]}.
 *
 * <p>Sort first, then fix one element and run the sorted two-pointer scan on
 * the rest. O(n^2), and the sorting is what lets you skip duplicates by
 * stepping past equal neighbours rather than de-duplicating at the end.
 */
public final class ThreeSum {

    public static List<List<Integer>> solve(int[] nums) {
        throw new UnsupportedOperationException("TODO: ThreeSum.solve");
    }
}
