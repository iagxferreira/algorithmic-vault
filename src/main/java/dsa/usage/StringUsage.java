package dsa.usage;

import java.util.List;

/**
 * Driving {@link String} and {@link StringBuilder} the easy way.
 *
 * <p>Strings are immutable, which is the source of the one performance trap
 * that matters: {@code result += c} inside a loop allocates a whole new string
 * every iteration, turning an O(n) loop into O(n^2). Build with a
 * {@code StringBuilder} and call {@code toString()} once at the end.
 *
 * <p>Also worth knowing: {@code split} takes a <b>regular expression</b>, so
 * {@code split(".")} matches every character and returns an empty array -
 * you want {@code split("\\.")}. And {@code ==} compares references while
 * {@code equals} compares contents; the fact that {@code ==} appears to work
 * on literals is the compiler interning them, not a rule you can rely on.
 */
public final class StringUsage {

    private StringUsage() {
    }

    /** The text reversed. */
    public static String reverse(String text) {
        throw new UnsupportedOperationException("TODO: StringUsage.reverse");
    }

    /** The words of a space-separated sentence, with empty entries dropped. */
    public static List<String> words(String sentence) {
        throw new UnsupportedOperationException("TODO: StringUsage.words");
    }

    /** The parts joined with {@code separator} between them. */
    public static String join(List<String> parts, String separator) {
        throw new UnsupportedOperationException("TODO: StringUsage.join");
    }

    /** The text repeated {@code times} over, built in one pass. */
    public static String repeat(String text, int times) {
        throw new UnsupportedOperationException("TODO: StringUsage.repeat");
    }

    /** The characters sorted ascending, e.g. "cab" gives "abc". */
    public static String sortCharacters(String text) {
        throw new UnsupportedOperationException("TODO: StringUsage.sortCharacters");
    }

    /** True when both strings contain the same characters with the same counts. */
    public static boolean isAnagram(String a, String b) {
        throw new UnsupportedOperationException("TODO: StringUsage.isAnagram");
    }

    /** Lowercase letters and digits only, everything else dropped, case folded. */
    public static String normalise(String text) {
        throw new UnsupportedOperationException("TODO: StringUsage.normalise");
    }

    /** How many times {@code needle} occurs in {@code haystack}, including overlaps. */
    public static int countOccurrences(String haystack, String needle) {
        throw new UnsupportedOperationException("TODO: StringUsage.countOccurrences");
    }

    /** Each word with its first letter uppercased, the rest lowercased. */
    public static String titleCase(String sentence) {
        throw new UnsupportedOperationException("TODO: StringUsage.titleCase");
    }
}
