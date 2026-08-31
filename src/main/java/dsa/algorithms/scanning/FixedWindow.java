package dsa.algorithms.scanning;

import java.util.List;

/**
 * A window of fixed size sliding along an array.
 *
 * <p>The whole idea in one sentence: moving the window one step adds exactly
 * one element and drops exactly one, so you never recompute the window from
 * scratch. That turns an O(n * k) scan of every window into O(n).
 *
 * <p>Target: O(n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/sliding-window.md} for what to understand first.
 */
public final class FixedWindow {

    private FixedWindow() {
    }

    /** Largest sum of any {@code k} consecutive elements; 0 when k > n or k <= 0. */
    public static int maxSum(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: FixedWindow.maxSum");
    }

    /** Average of each window of size {@code k}, left to right. */
    public static List<Double> averages(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: FixedWindow.averages");
    }

    /** Sum of each window of size {@code k}, left to right. The building block for the other two. */
    public static int[] sums(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: FixedWindow.sums");
    }
}
