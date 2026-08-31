package dsa.usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringUsageTest {

    @Test
    void reverses() {
        assertEquals("cba", StringUsage.reverse("abc"));
        assertEquals("", StringUsage.reverse(""));
    }

    @Test
    void splitsAndJoins() {
        assertEquals(List.of("a", "b", "c"), StringUsage.words("a b c"));
        assertEquals(List.of("a", "b"), StringUsage.words("  a   b  "), "empty entries must be dropped");
        assertEquals(List.of(), StringUsage.words("   "));
        assertEquals("a-b-c", StringUsage.join(List.of("a", "b", "c"), "-"));
        assertEquals("a", StringUsage.join(List.of("a"), "-"));
        assertEquals("", StringUsage.join(List.of(), "-"));
    }

    @Test
    void repeatsInOnePass() {
        assertEquals("ababab", StringUsage.repeat("ab", 3));
        assertEquals("", StringUsage.repeat("ab", 0));
        assertEquals(30_000, StringUsage.repeat("abc", 10_000).length());
    }

    @Test
    void sortsCharacters() {
        assertEquals("abc", StringUsage.sortCharacters("cab"));
        assertEquals("aabb", StringUsage.sortCharacters("baba"));
        assertEquals("", StringUsage.sortCharacters(""));
    }

    @Test
    void comparesAnagrams() {
        assertTrue(StringUsage.isAnagram("listen", "silent"));
        assertTrue(StringUsage.isAnagram("", ""));
        assertFalse(StringUsage.isAnagram("rat", "car"));
        assertFalse(StringUsage.isAnagram("a", "aa"));
    }

    @Test
    void normalisesToLettersAndDigits() {
        assertEquals("amanaplanacanalpanama", StringUsage.normalise("A man, a plan, a canal: Panama"));
        assertEquals("abc123", StringUsage.normalise("A-B-C 1_2_3"));
        assertEquals("", StringUsage.normalise("!!!"));
    }

    @Test
    void countsOverlappingOccurrences() {
        assertEquals(2, StringUsage.countOccurrences("abab", "ab"));
        assertEquals(3, StringUsage.countOccurrences("aaaa", "aa"), "overlaps count");
        assertEquals(0, StringUsage.countOccurrences("abc", "d"));
    }

    @Test
    void titleCasesEachWord() {
        assertEquals("Hello World", StringUsage.titleCase("hello world"));
        assertEquals("Hello World", StringUsage.titleCase("HELLO wORLD"));
        assertEquals("", StringUsage.titleCase(""));
    }
}
