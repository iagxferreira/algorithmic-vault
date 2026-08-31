# Roadmap

Ordered so nothing depends on anything below it. Tick an item when its
test is green.

Each phase links to a doc in `docs/` — **read it before you open the
code.** The questions at the top of each doc are the actual work; the
implementation is what proves you answered them.

---

## Phase 1 — Build the containers

`dsa.structures` · 14 classes

| | Doc |
|---|---|
| [ ] `DynamicArray` | [dynamic-array.md](./docs/structures/dynamic-array.md) |
| [ ] `SinglyLinkedList` [ ] `DoublyLinkedList` | [linked-lists.md](./docs/structures/linked-lists.md) |
| [ ] `ArrayStack` [ ] `CircularQueue` | [stacks-and-queues.md](./docs/structures/stacks-and-queues.md) |
| [ ] `HashTable` [ ] `LRUCache` | [hash-tables.md](./docs/structures/hash-tables.md) |
| [ ] `MinHeap` | [heaps.md](./docs/structures/heaps.md) |
| [ ] `BinarySearchTree` | [binary-search-trees.md](./docs/structures/binary-search-trees.md) |
| [ ] `Trie` | [tries.md](./docs/structures/tries.md) |
| [ ] `UnionFind` | [union-find.md](./docs/structures/union-find.md) |
| [ ] `Graph` | [graphs.md](./docs/structures/graphs.md) |
| [ ] `FenwickTree` [ ] `SegmentTree` | [range-queries.md](./docs/structures/range-queries.md) |

---

## Phase 2 — Walk them

`dsa.algorithms` · 57 classes

### Sorting → [sorting.md](./docs/algorithms/sorting.md)

- [ ] `SelectionSort` [ ] `BubbleSort` [ ] `InsertionSort`
- [ ] `MergeSort` [ ] `Partition` [ ] `QuickSort` [ ] `HeapSort` [ ] `CountingSort`
- [ ] `QuickSelect` [ ] `CountInversions`

### Binary search → [binary-search.md](./docs/algorithms/binary-search.md)

- [ ] `BinarySearch` [ ] `Bounds` [ ] `SearchMatrix` [ ] `SearchBst`
- [ ] `RotatedArray` [ ] `SearchAnswer` [ ] `FindPeak`

### Running a list → [linked-lists.md](./docs/algorithms/linked-lists.md)

- [ ] `TraverseList` [ ] `ReverseList` [ ] `FastSlowPointers`
- [ ] `DetectCycle` [ ] `ListPalindrome`

### Traversing a tree → [tree-traversal.md](./docs/algorithms/tree-traversal.md)

- [ ] `PreOrder` [ ] `InOrder` [ ] `PostOrder` [ ] `LevelOrder` [ ] `TreeMetrics`

### Graphs, unweighted → [graph-traversal.md](./docs/algorithms/graph-traversal.md)

- [ ] `DepthFirstSearch` [ ] `BreadthFirstSearch` [ ] `ConnectedComponents`
- [ ] `CycleDetection` [ ] `TopologicalSort` [ ] `Bipartite`

### Graphs, weighted → [shortest-paths.md](./docs/algorithms/shortest-paths.md)

- [ ] `Dijkstra` [ ] `BellmanFord` [ ] `FloydWarshall` [ ] `Kruskal` [ ] `Prim`

### Sliding window → [sliding-window.md](./docs/algorithms/sliding-window.md)

- [ ] `FixedWindow` [ ] `VariableWindow` [ ] `MonotonicWindow`

### Prefix sums → [prefix-sums.md](./docs/algorithms/prefix-sums.md)

- [ ] `PrefixSum` [ ] `PrefixSum2D` [ ] `DifferenceArray` [ ] `SubarrayCount`

### Number theory → [number-theory.md](./docs/algorithms/number-theory.md)

- [ ] `Gcd` [ ] `FastPower` [ ] `Primes` [ ] `Factorisation` [ ] `Binomial`

### Bits → [bits.md](./docs/algorithms/bits.md)

- [ ] `BitBasics` [ ] `XorTricks` [ ] `Bitmasks`

---

## Phase 3 — Use the standard library

`dsa.usage` · 7 classes · [collections.md](./docs/usage/collections.md)

- [ ] `ListUsage` [ ] `MapUsage` [ ] `SetUsage` [ ] `DequeUsage`
- [ ] `PriorityQueueUsage` [ ] `ArrayUsage` [ ] `StringUsage`

---

## A suggested path through it

You do not have to finish Phase 1 before starting Phase 2, and the
dependencies are looser than the numbering suggests. If you want a
narrower path, this order gets you to useful ground fastest:

1. `DynamicArray`, `SinglyLinkedList` — the two memory models
2. `TraverseList`, `ReverseList`, `FastSlowPointers` — pointer discipline
3. `BinarySearch`, `Bounds`, `SearchAnswer` — the highest-leverage technique here
4. `MergeSort`, `Partition`, `QuickSort` — divide and conquer
5. `ArrayStack`, `CircularQueue`, `MinHeap` — the three access disciplines
6. `PreOrder`/`InOrder`/`PostOrder`/`LevelOrder` — then `BinarySearchTree`
7. `Graph`, `DepthFirstSearch`, `BreadthFirstSearch` — then everything graph
8. `UnionFind` → `Kruskal`; `MinHeap` → `Dijkstra` and `Prim`
9. `PrefixSum`, `VariableWindow` — the two cheapest wins in the repo
10. `dsa.usage` — anytime; it is independent of the rest

## Then what

**Competitive programming** — go to
[`competitive-programming-notebook`](../competitive-programming-notebook/)
and follow its roadmap. Every topic doc here ends with the matching
problems there. This repo is the warm-up, not a substitute for solving
under a clock.

**More depth here** — things deliberately left out, worth adding once the
above is green:

- Balanced trees: AVL or red-black rotations, and why `TreeMap` needs them
- Segment tree with **lazy propagation**, for range updates
- Strongly connected components (Tarjan or Kosaraju), bridges, articulation points
- String algorithms: KMP, Z-function, rolling hash, suffix array
- Max flow (Dinic), bipartite matching
- Bitmask and digit dynamic programming
- An `Iterator` that honours `ConcurrentModificationException`, and a
  `hashCode`/`equals` contract done properly
