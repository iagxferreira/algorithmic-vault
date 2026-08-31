package dsa.algorithms.scanning;

/**
 * A window that grows and shrinks - the pattern most problems actually want.
 *
 * <p>The shape is always the same: advance the right edge one step, then
 * shrink from the left <b>while</b> the window is invalid. It reads like a
 * nested loop but it is O(n), because each index enters once and leaves once.
 * Convincing yourself of that amortised argument is the point of this class.
 *
 * <p>The two flavours, and getting them the right way round is the usual bug:
 *
 * <ul>
 *   <li><b>longest valid</b> - shrink while INVALID, record after shrinking
 *   <li><b>shortest valid</b> - shrink while still VALID, record before shrinking
 * </ul>
 *
 * <p>Target: O(n) time, O(1) or O(alphabet) space.
 *
 * <p>See {@code docs/algorithms/sliding-window.md} for what to understand first.
 */
public final class VariableWindow {

    private VariableWindow() {
    }

    /**
     * Length of the shortest contiguous subarray summing to at least
     * {@code target}, or 0 when there is none. Values are positive - that is
     * what makes shrinking from the left safe.
     */
    public static int minLengthWithSumAtLeast(int[] values, int target) {
        throw new UnsupportedOperationException("TODO: VariableWindow.minLengthWithSumAtLeast");
    }

    /** Length of the longest substring with no repeated character. */
    public static int longestUniqueSubstring(String text) {
        throw new UnsupportedOperationException("TODO: VariableWindow.longestUniqueSubstring");
    }

    /** Length of the longest substring containing at most {@code k} distinct characters. */
    public static int longestWithAtMostKDistinct(String text, int k) {
        throw new UnsupportedOperationException("TODO: VariableWindow.longestWithAtMostKDistinct");
    }

    /**
     * Length of the longest run of 1s obtainable by flipping at most {@code k}
     * zeroes. Restated as a window: the longest window with at most k zeroes -
     * and that restatement is the entire exercise.
     */
    public static int longestOnesWithKFlips(int[] bits, int k) {
        throw new UnsupportedOperationException("TODO: VariableWindow.longestOnesWithKFlips");
    }
}
