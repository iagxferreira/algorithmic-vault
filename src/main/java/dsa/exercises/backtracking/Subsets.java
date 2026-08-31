package dsa.exercises.backtracking;

import java.util.List;

/**
 * Subsets (power set).
 *
 * <p>Every subset of a set of distinct integers. Emit subsets in the order the
 * standard "include or exclude each element in turn" recursion produces them,
 * which for {@code [1, 2, 3]} is
 * {@code [[], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]]}.
 *
 * <p>The backtracking skeleton in its simplest form: choose, recurse, undo the
 * choice. Getting the undo right here is what makes the harder problems work.
 * O(n * 2^n).
 *
 * <p>Compare with {@link dsa.fundamentals.Bits#subsets}, which enumerates the
 * same sets by counting bitmasks instead of recursing.
 */
public final class Subsets {

    public static List<List<Integer>> solve(int[] nums) {
        throw new UnsupportedOperationException("TODO: Subsets.solve");
    }
}
