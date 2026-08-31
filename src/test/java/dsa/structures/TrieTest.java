package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class TrieTest {

    private static Trie trieOf(String... words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

    @Test
    void findsExactWordsOnly() {
        Trie trie = trieOf("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertFalse(trie.search("apples"));
    }

    @Test
    void prefixMatchesAnyStoredWord() {
        Trie trie = trieOf("apple");
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("apple"));
        assertFalse(trie.startsWith("apx"));
    }

    @Test
    void aPrefixBecomesAWordWhenInserted() {
        Trie trie = trieOf("apple", "app");
        assertTrue(trie.search("app"));
        assertTrue(trie.search("apple"));
    }

    @Test
    void emptyTrieMatchesNothing() {
        Trie trie = new Trie();
        assertFalse(trie.search("a"));
        assertFalse(trie.startsWith("a"));
    }

    @Test
    void collectsWordsUnderAPrefixInOrder() {
        Trie trie = trieOf("car", "card", "care", "dog", "cat");
        assertEquals(List.of("car", "card", "care"), trie.wordsWithPrefix("car"));
        assertEquals(List.of("car", "card", "care", "cat"), trie.wordsWithPrefix("ca"));
        assertEquals(List.of(), trie.wordsWithPrefix("z"));
    }
}
