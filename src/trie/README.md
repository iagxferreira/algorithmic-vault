# Tries In Rust

Notes and goals for trie study.

## Core Concepts

- A trie stores strings by shared prefixes.
- Each node usually has child edges and an end-of-word marker.
- `HashMap<char, TrieNode>` is easy to start with.
- Fixed arrays can be faster for constrained alphabets, but are less flexible.

## Implementation Goals

1. Insert word.
2. Search exact word.
3. Search prefix.
4. Delete word.
5. Count prefix matches.

## Exercise Goals

1. Implement Trie.
2. Add and Search Word.
3. Replace Words.
4. Word Search II.
5. Design Search Autocomplete System.
