# algorithm-studies

Data structures and algorithms in Java, at the level of **build it, walk
it, use it**. No contest problems here — those live in
[`competitive-programming-notebook`](../competitive-programming-notebook/).

Every class in `src/main` is a **stub**: a signature, a short javadoc, and
a body that throws `UnsupportedOperationException`. Every stub has a JUnit
test describing the expected behaviour, and every topic has a markdown
roadmap in `docs/` saying what to understand before you write any code.

**78 classes, 77 test classes, 258 methods to implement.** There are no
reference solutions in this repo, on purpose.

## Start here

1. Read [`ROADMAP.md`](./ROADMAP.md) and pick the first unticked item.
2. Read that topic's doc in `docs/` — the questions at the top are the
   point; if you cannot answer them, the code will not teach you.
3. Open the one class. Run its one test. Make it green.

```shell
mise install                                  # once: Temurin 21 + Gradle 9.7
./gradlew test --tests '*MergeSortTest'       # one sitting
./gradlew test --tests 'dsa.algorithms.sorting.*'   # one topic
./gradlew test                                # everything (all red on a fresh clone)
```

If `mise` is not activated in your shell, prefix with `mise x --`.

## Layout

```
src/main/java/dsa/
  structures/     build it  — 14 containers written from nothing
  algorithms/     walk it   — 57 techniques, one class each
    sorting/  search/  list/  tree/  graph/  scanning/  numbers/
  usage/          use it    —  7 drills on the JDK equivalents
  support/                  — ListNode, TreeNode + builders (already written)
docs/
  structures/     one roadmap per data structure
  algorithms/     one roadmap per technique
  usage/
```

One class per technique, on purpose: a sitting is "open `MergeSort.java`,
run `MergeSortTest`, make it green" — not "pick one of ten stubs in a
file".

## The three tiers

**`dsa.structures` — build it.** Dynamic array, singly and doubly linked
lists, stack, ring-buffer queue, hash table, min-heap, BST, trie,
union-find, LRU cache, graph, Fenwick tree, segment tree.

**`dsa.algorithms` — walk it.** Seven sorts plus partitioning and
quickselect; binary search over arrays, matrices, BSTs and the answer
space; list traversal, reversal and cycle detection; all four tree orders
both recursively and iteratively; DFS, BFS, topological sort, Dijkstra,
Bellman-Ford, Floyd-Warshall, Kruskal, Prim; sliding windows and prefix
sums; gcd, fast exponentiation, sieves and bit tricks.

**`dsa.usage` — use it.** The same ground via `List`, `Map`, `Set`,
`Deque`, `PriorityQueue`, `Arrays` and `String`. Writing a hash table
teaches you what it costs; knowing `merge(key, 1, Integer::sum)` is what
makes you fast. Both, in that order.

## How a topic doc is laid out

Every file in `docs/` has the same five sections:

- **Why this topic** — what it buys you, and where it stops applying
- **Understand before you write code** — numbered questions to answer out
  loud first
- **Order to implement** — a checklist, one class per line
- **Traps** — the specific failures the tests actually check
- **Then challenge yourself** — the matching problems in the notebook

## Where the problems went

Anything shaped like a judge submission belongs in
`competitive-programming-notebook`, which has the recall-card format, the
platform layout and the run/stress tooling for it. Finish a topic here,
then go solve its problems there — every topic doc ends with the list.
