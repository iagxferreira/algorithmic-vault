package dsa.exercises.backtracking;

import java.util.List;

/**
 * Combination Sum.
 *
 * <p>All unique combinations of the distinct {@code candidates} that add up to
 * {@code target}. Each candidate may be reused any number of times. Emit each
 * combination in non-decreasing order, and the combinations in the order the
 * recursion finds them when candidates are considered left to right.
 *
 * <p>Example: {@code candidates = [2, 3, 6, 7], target = 7} gives
 * {@code [[2, 2, 3], [7]]}.
 *
 * <p>Reuse is allowed, so recursing on the same index rather than the next one
 * is what permits repeats; never going back to an earlier index is what
 * prevents {@code [2,2,3]} and {@code [3,2,2]} both appearing.
 */
public final class CombinationSum {

    public static List<List<Integer>> solve(int[] candidates, int target) {
        throw new UnsupportedOperationException("TODO: CombinationSum.solve");
    }
}
