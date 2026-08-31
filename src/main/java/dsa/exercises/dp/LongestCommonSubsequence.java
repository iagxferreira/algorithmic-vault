package dsa.exercises.dp;

/**
 * Longest Common Subsequence.
 *
 * <p>Length of the longest sequence of characters appearing in both strings in
 * the same order, not necessarily adjacent.
 *
 * <p>Example: {@code "abcde"} and {@code "ace"} give 3, for "ace".
 *
 * <p>The archetypal two-dimensional table: {@code best[i][j]} covers the first
 * i characters of one string and the first j of the other. Matching characters
 * extend the diagonal; otherwise take the better of dropping one character
 * from either side. O(n * m).
 */
public final class LongestCommonSubsequence {

    public static int solve(String a, String b) {
        throw new UnsupportedOperationException("TODO: LongestCommonSubsequence.solve");
    }
}
