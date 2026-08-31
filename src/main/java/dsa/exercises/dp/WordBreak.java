package dsa.exercises.dp;

import java.util.List;

/**
 * Word Break.
 *
 * <p>Return true when {@code text} can be segmented into a sequence of words
 * from {@code dictionary}. Words may be reused.
 *
 * <p>Example: {@code "applepenapple"} with {@code ["apple", "pen"]} gives true.
 *
 * <p>{@code reachable[i]} means "the first i characters can be segmented". It
 * is true when some earlier reachable position is followed by a dictionary
 * word ending here. The plain recursion re-solves the same suffixes over and
 * over, which is exactly what memoising fixes.
 */
public final class WordBreak {

    public static boolean solve(String text, List<String> dictionary) {
        throw new UnsupportedOperationException("TODO: WordBreak.solve");
    }
}
