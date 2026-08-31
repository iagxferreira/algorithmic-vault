package dsa.exercises.arrays;

import java.util.List;

/**
 * Group Anagrams.
 *
 * <p>Group words that are rearrangements of each other.
 *
 * <p>Example: {@code ["eat", "tea", "tan", "ate", "nat", "bat"]} gives
 * {@code [[bat], [eat, tea, ate], [tan, nat]]}.
 *
 * <p>To keep the output comparable: inside a group keep the input order, and
 * order the groups by their first word alphabetically.
 *
 * <p>The idea is to find a canonical key every anagram shares. Sorting each
 * word gives O(n * k log k); a 26-slot character count as the key gives
 * O(n * k).
 */
public final class GroupAnagrams {

    public static List<List<String>> solve(String[] words) {
        throw new UnsupportedOperationException("TODO: GroupAnagrams.solve");
    }
}
