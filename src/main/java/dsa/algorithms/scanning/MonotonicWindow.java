package dsa.algorithms.scanning;

/**
 * A window whose answer is a max or a min - the monotonic deque.
 *
 * <p>A running sum is easy to update when an element leaves the window; a
 * running maximum is not, because you do not know what the second largest was.
 * The fix is to keep a deque of candidate <b>indices</b> whose values decrease
 * from front to back: anything smaller than an incoming value can never win
 * again, so drop it immediately.
 *
 * <p>The front of the deque is then always the answer. Each index is pushed
 * and popped at most once, which is why it is O(n) rather than O(n * k).
 *
 * <p>Target: O(n) time, O(k) space.
 *
 * <p>See {@code docs/algorithms/sliding-window.md} for what to understand first.
 */
public final class MonotonicWindow {

    private MonotonicWindow() {
    }

    /** Maximum of every window of size {@code k}, left to right. */
    public static int[] maxOfEachWindow(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: MonotonicWindow.maxOfEachWindow");
    }

    /** Minimum of every window of size {@code k}. The same code with one comparison flipped. */
    public static int[] minOfEachWindow(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: MonotonicWindow.minOfEachWindow");
    }
}
