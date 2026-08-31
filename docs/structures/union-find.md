# Union-find (disjoint set union)

`dsa.structures.UnionFind`

## Why build it

It answers "are these two things connected?" and "connect them" in
effectively constant time, *incrementally* — as edges arrive, without ever
re-traversing. That makes it the right tool for connectivity, cycle
detection in undirected graphs, and Kruskal's MST.

Compare with `ConnectedComponents`, which answers the same question by
traversal but needs the whole graph up front.

## Understand before you write code

1. **The model.** Each set is a tree; the root is the set's identity. `find`
   walks to the root; `union` attaches one root under another. Two elements
   are connected exactly when they share a root.
2. **Why path compression.** During `find`, point every node you passed
   directly at the root. The next lookup is then O(1). One extra line.
3. **Why union by rank (or size).** Always attach the *shallower* tree under
   the deeper one, so the height grows as slowly as possible. Without it, a
   chain of unions builds a linked list and `find` degrades to O(n).
4. **Both together give α(n).** The inverse Ackermann function — under 5 for
   any n you will ever see, so "effectively constant". Either optimisation
   alone is good; both is the standard.
5. **Why `union` returns a boolean.** Returning `false` when the two were
   already connected is what makes cycle detection and Kruskal's
   edge-selection one line each. Do not throw this away.

## Implement

- [ ] `find` — with path compression
- [ ] `union` — with union by rank, returning `false` on a no-op
- [ ] `connected`
- [ ] `components` — decrement the count on each successful union

## Traps

- **`union` on already-connected elements** must not decrement the component
  count. Tested.
- **Union by rank compares *roots*,** not the arguments. Call `find` on both
  first.
- **Rank is only an upper bound on height** once path compression is in
  play — that is fine, and you do not update it on compression.
- **1-based labels.** Many problems label vertices 1..n. Size the array
  `n + 1`.
- **A long chain of unions** is the test that exposes a missing rank
  heuristic. There is one, with n = 1000.

## Test it

```shell
./gradlew test --tests '*UnionFindTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):
`leetcode/0547-number-of-provinces` (write DSU here first),
`0684-redundant-connection` (DSU as a cycle detector),
`0721-accounts-merge`, `1584-min-cost-to-connect-all-points` (Kruskal).
