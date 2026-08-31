package dsa.usage;

import java.util.List;
import java.util.Map;

/**
 * Driving {@link java.util.Map} the easy way.
 *
 * <p>The counterpart to the {@link dsa.structures.HashTable} you built.
 * Counting things with a map is the single most common move in this whole
 * subject, so the idioms here should become reflex.
 *
 * <p>Four methods worth knowing by name, because each replaces four lines of
 * null-checking:
 *
 * <ul>
 *   <li>{@code getOrDefault(key, 0)} - read a count that may not exist yet.
 *       Plain {@code get} returns {@code null}, and unboxing that into an
 *       {@code int} throws a NullPointerException.
 *   <li>{@code merge(key, 1, Integer::sum)} - increment a count in one call.
 *   <li>{@code computeIfAbsent(key, k -> new ArrayList<>())} - the standard way
 *       to build a map of lists.
 *   <li>{@code putIfAbsent} - write only the first value seen for a key.
 * </ul>
 *
 * <p>Ordering: {@code HashMap} has none, {@code LinkedHashMap} keeps insertion
 * order, {@code TreeMap} keeps keys sorted. Where a drill below promises an
 * order, that choice is the answer.
 */
public final class MapUsage {

    private MapUsage() {
    }

    /** How many times each value appears. */
    public static Map<Integer, Integer> countValues(int[] values) {
        throw new UnsupportedOperationException("TODO: MapUsage.countValues");
    }

    /** How many times each character appears in the text. */
    public static Map<Character, Integer> countCharacters(String text) {
        throw new UnsupportedOperationException("TODO: MapUsage.countCharacters");
    }

    /** The value with the highest count; on a tie, the smallest such value. */
    public static int mostFrequent(int[] values) {
        throw new UnsupportedOperationException("TODO: MapUsage.mostFrequent");
    }

    /** Words grouped by their first letter, keys in alphabetical order and words in input order. */
    public static Map<Character, List<String>> groupByFirstLetter(List<String> words) {
        throw new UnsupportedOperationException("TODO: MapUsage.groupByFirstLetter");
    }

    /** Keys and values swapped. Assume the values are unique. */
    public static Map<String, Integer> invert(Map<Integer, String> source) {
        throw new UnsupportedOperationException("TODO: MapUsage.invert");
    }

    /** Sum of every value in the map. */
    public static int sumValues(Map<String, Integer> source) {
        throw new UnsupportedOperationException("TODO: MapUsage.sumValues");
    }

    /** The keys whose value is at least {@code threshold}, in ascending key order. */
    public static List<String> keysWithValueAtLeast(Map<String, Integer> source, int threshold) {
        throw new UnsupportedOperationException("TODO: MapUsage.keysWithValueAtLeast");
    }

    /**
     * The first value that appears exactly once in the text, or
     * {@code Optional.empty()} when every character repeats. The map has to
     * remember insertion order for "first" to mean anything.
     */
    public static java.util.Optional<Character> firstUniqueCharacter(String text) {
        throw new UnsupportedOperationException("TODO: MapUsage.firstUniqueCharacter");
    }
}
