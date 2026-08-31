package dsa.usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class MapUsageTest {

    @Test
    void countsValues() {
        assertEquals(Map.of(1, 3, 2, 2, 3, 1), MapUsage.countValues(new int[] {1, 1, 1, 2, 2, 3}));
        assertEquals(Map.of(), MapUsage.countValues(new int[] {}));
    }

    @Test
    void countsCharacters() {
        assertEquals(Map.of('a', 2, 'b', 1), MapUsage.countCharacters("aab"));
        assertEquals(Map.of(), MapUsage.countCharacters(""));
    }

    @Test
    void findsTheMostFrequentValue() {
        assertEquals(1, MapUsage.mostFrequent(new int[] {1, 1, 2, 3}));
        assertEquals(2, MapUsage.mostFrequent(new int[] {5, 2, 5, 2, 9}), "a tie must pick the smaller value");
        assertEquals(7, MapUsage.mostFrequent(new int[] {7}));
    }

    @Test
    void groupsByFirstLetter() {
        Map<Character, List<String>> grouped =
                MapUsage.groupByFirstLetter(List.of("apple", "avocado", "banana", "cherry", "apricot"));
        assertEquals(List.of('a', 'b', 'c'), List.copyOf(grouped.keySet()), "keys must be in alphabetical order");
        assertEquals(List.of("apple", "avocado", "apricot"), grouped.get('a'));
        assertEquals(List.of("banana"), grouped.get('b'));
    }

    @Test
    void invertsAMap() {
        assertEquals(Map.of("one", 1, "two", 2), MapUsage.invert(Map.of(1, "one", 2, "two")));
        assertEquals(Map.of(), MapUsage.invert(Map.of()));
    }

    @Test
    void sumsValues() {
        assertEquals(6, MapUsage.sumValues(Map.of("a", 1, "b", 2, "c", 3)));
        assertEquals(0, MapUsage.sumValues(Map.of()));
    }

    @Test
    void filtersKeysByValue() {
        Map<String, Integer> scores = Map.of("carol", 9, "alice", 5, "bob", 3);
        assertEquals(List.of("alice", "carol"), MapUsage.keysWithValueAtLeast(scores, 5));
        assertEquals(List.of(), MapUsage.keysWithValueAtLeast(scores, 100));
    }

    @Test
    void findsTheFirstUniqueCharacter() {
        assertEquals(Optional.of('l'), MapUsage.firstUniqueCharacter("leetcode"));
        assertEquals(Optional.of('v'), MapUsage.firstUniqueCharacter("loveleetcode"));
        assertTrue(MapUsage.firstUniqueCharacter("aabb").isEmpty());
        assertTrue(MapUsage.firstUniqueCharacter("").isEmpty());
    }
}
