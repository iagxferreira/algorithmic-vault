package dsa.exercises.stackqueue;

/**
 * Largest Rectangle in Histogram.
 *
 * <p>Bars of width 1 and the given heights. Return the area of the largest
 * rectangle that fits under them.
 *
 * <p>Example: {@code [2, 1, 5, 6, 2, 3]} gives 10, from the bars of height 5
 * and 6.
 *
 * <p>The monotonic stack at full strength. For each bar, its rectangle extends
 * until a shorter bar on either side. Keep an increasing stack of indices; when
 * a shorter bar arrives, everything it cuts off can be settled right then.
 * O(n).
 */
public final class LargestRectangleInHistogram {

    public static int solve(int[] heights) {
        throw new UnsupportedOperationException("TODO: LargestRectangleInHistogram.solve");
    }
}
