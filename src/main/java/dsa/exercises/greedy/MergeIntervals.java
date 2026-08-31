package dsa.exercises.greedy;

/**
 * Merge Intervals.
 *
 * <p>Merge all overlapping intervals, given as {@code {start, end}} pairs, and
 * return them sorted by start. Intervals that merely touch, such as
 * {@code [1, 4]} and {@code [4, 5]}, do overlap.
 *
 * <p>Example: {@code [[1,3],[2,6],[8,10],[15,18]]} gives
 * {@code [[1,6],[8,10],[15,18]]}.
 *
 * <p>The move that unlocks every interval problem: sort by start first. After
 * that a single pass suffices, because anything overlapping the interval you
 * are building must come next. O(n log n).
 */
public final class MergeIntervals {

    public static int[][] solve(int[][] intervals) {
        throw new UnsupportedOperationException("TODO: MergeIntervals.solve");
    }
}
