# Roadmap

Ordered so that nothing depends on something further down. Tick items off as
their tests go green.

## Phase 1 - Build the containers

`dsa.structures` — implement each one from nothing.

- [ ] `DynamicArray` - amortised growth
- [ ] `SinglyLinkedList` - pointer rewiring, in-place reversal
- [ ] `DoublyLinkedList` - O(1) removal from both ends
- [ ] `ArrayStack` - LIFO over an array
- [ ] `CircularQueue` - FIFO over a ring buffer
- [ ] `HashTable` - separate chaining, load factor, resizing
- [ ] `MinHeap` - sift up, sift down, O(n) heapify
- [ ] `BinarySearchTree` - insert, search, delete (all three cases)
- [ ] `Trie` - prefix walking
- [ ] `UnionFind` - path compression and union by rank
- [ ] `LRUCache` - hash map plus doubly linked list
- [ ] `Graph` - adjacency list, directed and undirected
- [ ] `FenwickTree` - point update, prefix sum, `i & -i`
- [ ] `SegmentTree` - range sum and range min, point assignment

## Phase 2 - Walk them

`dsa.fundamentals` — the operations that turn a container into an algorithm.

### Sorting and searching
- [ ] `Sorting` - bubble, selection, insertion, merge, quick, heap, counting
- [ ] `Sorting` - partition, quickselect, inversion counting
- [ ] `BinarySearch` - sorted array, bounds, first/last occurrence
- [ ] `BinarySearch` - rotated array, matrix, bst
- [ ] `BinarySearch` - over the answer space (`firstTrue`, integer sqrt, peak)

### Running a list
- [ ] `ListTraversal` - length, sum, middle, kth from end
- [ ] `ListTraversal` - reversal, iterative and recursive
- [ ] `ListTraversal` - Floyd cycle detection, palindrome check

### Traversing a tree
- [ ] `TreeTraversal` - pre, in and post order, recursively
- [ ] `TreeTraversal` - the same three iteratively, with an explicit stack
- [ ] `TreeTraversal` - level order, zigzag, right side view, root-to-leaf paths

### Graphs
- [ ] `GraphTraversal` - dfs recursive and iterative, bfs
- [ ] `GraphTraversal` - distances, path reconstruction, components
- [ ] `GraphTraversal` - cycle detection, topological sort, bipartite check
- [ ] `ShortestPaths` - Dijkstra, with and without the path
- [ ] `ShortestPaths` - Bellman-Ford and negative cycles
- [ ] `ShortestPaths` - Floyd-Warshall
- [ ] `MinimumSpanningTree` - Kruskal and Prim

### Scanning
- [ ] `SlidingWindow` - fixed, variable, monotonic deque
- [ ] `PrefixSums` - 1d, 2d, difference array, subarray counting

### Arithmetic
- [ ] `NumberTheory` - gcd/lcm, fast power, modPow, sieve, factorisation
- [ ] `Bits` - masks, subset enumeration, xor tricks

## Phase 3 - Use the standard library

`dsa.usage` — the same ground, now via the JDK, fluently.

- [ ] `ListUsage` - build, convert, reverse, rotate, filter, sort by comparator
- [ ] `MapUsage` - counting, `getOrDefault`, `merge`, `computeIfAbsent`, grouping
- [ ] `SetUsage` - dedupe, union/intersection/difference, `TreeSet` neighbours
- [ ] `DequeUsage` - as a stack, as a queue, from both ends, bounded history
- [ ] `PriorityQueueUsage` - min vs max heap, top-k, merging sorted input
- [ ] `ArrayUsage` - `Arrays` methods, comparator sorting, deep copy, transpose
- [ ] `StringUsage` - `StringBuilder`, split/join, normalising, counting

## Then what

Two directions, and they are different sports:

**Systems and language depth** — extend this repo. Balanced trees (AVL or
red-black rotations), a segment tree with lazy propagation, an iterator that
honours `ConcurrentModificationException`, a `hashCode`/`equals` contract done
properly, generics with bounded wildcards.

**Competitive programming** — go to
[`competitive-programming-notebook`](../competitive-programming-notebook/) and
follow its roadmap. That is where the judge problems, the contest I/O template
and the timed practice live. This repo is the warm-up for it, not a substitute.
