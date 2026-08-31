package dsa.structures;

import java.util.List;

/**
 * A prefix tree over lowercase ascii words.
 *
 * <p>Why it matters: a trie turns "does any word start with this prefix?" into
 * a walk of length |prefix|, independent of how many words are stored. It is
 * the backbone of autocomplete and of word-search-on-a-grid problems.
 *
 * <p>Hint: each node holds 26 children plus an {@code isWord} flag.
 *
 * <p>Target complexity: insert/search/startsWith O(|word|).
 */
public class Trie {

    private static class Node {
        final Node[] children = new Node[26];
        boolean isWord;
    }

    private final Node root = new Node();

    public void insert(String word) {
        throw new UnsupportedOperationException("TODO: Trie.insert");
    }

    /** True only when the exact word was inserted. */
    public boolean search(String word) {
        throw new UnsupportedOperationException("TODO: Trie.search");
    }

    /** True when any stored word starts with the prefix. */
    public boolean startsWith(String prefix) {
        throw new UnsupportedOperationException("TODO: Trie.startsWith");
    }

    /** Every stored word starting with the prefix, in lexicographic order. */
    public List<String> wordsWithPrefix(String prefix) {
        throw new UnsupportedOperationException("TODO: Trie.wordsWithPrefix");
    }
}
