package dsa.exercises.slidingwindow;

/**
 * Permutation in String.
 *
 * <p>Return true when {@code text} contains any permutation of {@code pattern}
 * as a contiguous substring. Inputs are lowercase ascii.
 *
 * <p>Example: {@code pattern = "ab", text = "eidbaooo"} gives true, for "ba".
 *
 * <p>A fixed-size window of {@code pattern.length()}: slide it and compare
 * character counts. Rebuilding the comparison each step is O(26 n); keeping a
 * running count of how many of the 26 counts currently match gets it to O(n).
 */
public final class PermutationInString {

    public static boolean solve(String pattern, String text) {
        throw new UnsupportedOperationException("TODO: PermutationInString.solve");
    }
}
