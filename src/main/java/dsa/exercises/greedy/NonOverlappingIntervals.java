package dsa.exercises.greedy;

/**
 * Non-overlapping Intervals.
 *
 * <p>Fewest intervals to remove so the rest do not overlap. Touching endpoints
 * such as {@code [1, 2]} and {@code [2, 3]} do not count as overlapping.
 *
 * <p>Example: {@code [[1,2],[2,3],[3,4],[1,3]]} gives 1.
 *
 * <p>Sort by <em>end</em>, not by start, and keep the interval that finishes
 * earliest, since it leaves the most room for what follows. This is the
 * classic activity-selection exchange argument, and sorting by start instead
 * quietly gives wrong answers. O(n log n).
 */
public final class NonOverlappingIntervals {

    public static int solve(int[][] intervals) {
        throw new UnsupportedOperationException("TODO: NonOverlappingIntervals.solve");
    }
}
