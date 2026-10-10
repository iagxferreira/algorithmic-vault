# Roadmap

This is the Go learning path. Tick a topic when its tests pass and you can
explain the invariant and complexity without leaning on the implementation.
The old Java roadmap is being migrated topic-by-topic; unchecked topics do
not yet have an active Go implementation.

## Phase 1 — Build the containers

| Status | Topic | Notes |
|---|---|---|
| [x] | `DynamicArray[T comparable]` | [dynamic-array.md](./docs/structures/dynamic-array.md) |
| [ ] | `SinglyLinkedList[T]`, `DoublyLinkedList[T]` | [linked-lists.md](./docs/structures/linked-lists.md) |
| [ ] | `ArrayStack[T]`, `CircularQueue[T]` | [stacks-and-queues.md](./docs/structures/stacks-and-queues.md) |
| [ ] | `HashTable[K comparable, V any]`, `LRUCache` | [hash-tables.md](./docs/structures/hash-tables.md) |
| [ ] | `MinHeap[T]` | [heaps.md](./docs/structures/heaps.md) |
| [ ] | `BinarySearchTree[T]` | [binary-search-trees.md](./docs/structures/binary-search-trees.md) |
| [ ] | `Trie` | [tries.md](./docs/structures/tries.md) |
| [ ] | `UnionFind` | [union-find.md](./docs/structures/union-find.md) |
| [ ] | `Graph` | [graphs.md](./docs/structures/graphs.md) |
| [ ] | `FenwickTree`, `SegmentTree` | [range-queries.md](./docs/structures/range-queries.md) |

## Phase 2 — Walk the structures

Migrate the existing algorithm topics into focused Go packages and tests.

- [ ] Sorting, partitioning, quickselect, inversion counting
- [ ] Binary search, bounds, matrix search, answer-space search
- [ ] Linked-list traversal, reversal, cycle detection
- [ ] Recursive and iterative tree traversals
- [ ] Graph traversal, connectivity, cycles, topological order, bipartite checks
- [ ] Shortest paths and minimum spanning trees
- [ ] Sliding windows and prefix sums
- [ ] Number theory and bit manipulation

## Phase 3 — Use Go's standard library

- [ ] Slices and `sort` / `slices`
- [ ] Maps and sets represented with `map`
- [ ] Queues, stacks, and `container/list`
- [ ] Priority queues with `container/heap`
- [ ] Arrays, strings, and byte/rune semantics

## Suggested path

1. `DynamicArray` — capacity, growth, shifting, amortized analysis
2. Linked lists — pointer discipline and list algorithms
3. Stack, queue, and heap — access constraints and interfaces
4. Trees — recursion, invariants, and traversal
5. Graph representation and traversal — then weighted algorithms
6. Prefix sums and sliding windows — high-leverage array techniques
7. Standard-library idioms — compare clarity and performance with your own code

## Go conventions

- Prefer a usable zero value when that makes the type safe and clear.
- Use generics for reusable containers, with the narrowest constraint the
  operations actually require.
- Return errors for invalid operations; do not use Java exceptions or panic
  for ordinary input errors.
- Keep tests beside implementation in the same package, named `*_test.go`.
- Each topic should explain invariants, complexity, edge cases, and relevant
  Go-specific design choices.
