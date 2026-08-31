# Tries

`dsa.structures.Trie`

## Why build it

A trie turns "does any stored word start with this prefix?" into a walk of
length |prefix| — independent of how many words are stored. A hash set
cannot answer prefix questions at all without scanning everything.

## Understand before you write code

1. **The key is in the path, not in the node.** No node stores a word. The
   word is spelled out by the edges you followed to reach it. That is why
   shared prefixes cost nothing extra.
2. **Why you need an `isWord` flag.** Reaching a node means "this prefix
   exists", which is not the same as "this word was inserted". Without the
   flag, inserting `"apple"` would make `search("app")` return true.
3. **The space trade.** 26 child slots per node, mostly null. That is
   O(alphabet × nodes) memory to buy O(|word|) lookup — expensive, and often
   worth it. A `HashMap<Character, Node>` per node trades speed for space.
4. **Why `wordsWithPrefix` is a DFS.** Walk down to the prefix node, then
   collect everything beneath it. Visiting children in index order gives you
   lexicographic output for free.

## Implement

- [ ] `insert`
- [ ] `search` — exact words only
- [ ] `startsWith` — any word with this prefix
- [ ] `wordsWithPrefix` — walk down, then DFS, in lexicographic order

## Traps

- **`search` vs `startsWith`** differ only in whether you check `isWord` at
  the end. Both are tested against the `"apple"` / `"app"` case.
- **Inserting a prefix of an existing word** must set `isWord` on an
  existing node, not create anything. Tested.
- **The empty trie** matches nothing, including the empty prefix walk.
- **`c - 'a'`** assumes lowercase ASCII. Fine here; know the assumption.
- **Building the answer string during the DFS** — append on the way down,
  remove on the way back up. Same discipline as backtracking.

## Test it

```shell
./gradlew test --tests '*TrieTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):
`leetcode/0208-implement-trie-prefix-tree`,
`0211-design-add-and-search-words-data-structure` (wildcards force a
branching search), `0212-word-search-ii` (a trie pruning a grid DFS — the
one that shows why tries earn their memory).
