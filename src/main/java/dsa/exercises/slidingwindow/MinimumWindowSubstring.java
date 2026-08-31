package dsa.exercises.slidingwindow;

/**
 * Minimum Window Substring.
 *
 * <p>The shortest substring of {@code text} containing every character of
 * {@code pattern}, counting duplicates. Return "" when there is none; the
 * answer is unique when it exists.
 *
 * <p>Example: {@code text = "ADOBECODEBANC", pattern = "ABC"} gives "BANC".
 *
 * <p>The hardest of the variable-window problems and worth the time. Expand
 * the right edge until the window is valid, then shrink from the left while it
 * stays valid, recording the best. Track how many required characters are
 * still missing rather than rescanning the counts.
 */
public final class MinimumWindowSubstring {

    public static String solve(String text, String pattern) {
        throw new UnsupportedOperationException("TODO: MinimumWindowSubstring.solve");
    }
}
