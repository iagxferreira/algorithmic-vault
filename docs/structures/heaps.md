# Heaps

`dsa.structures.MinHeap` — your own `PriorityQueue`

## Why build it

A heap answers one question — "what is the smallest thing here?" — while
you keep inserting. That is exactly what Dijkstra, Prim, top-k, merging k
sorted lists and streaming medians all need.

## Understand before you write code

1. **A heap is a tree stored in an array.** For index `i`: children live at
   `2i+1` and `2i+2`, parent at `(i-1)/2`. No nodes, no pointers — just
   arithmetic. Convince yourself the formulas are right by drawing a
   7-element heap.
2. **The heap property is weaker than sorting.** Each parent is ≤ its
   children; siblings are unordered. That weakness is why insertion is
   O(log n) instead of O(n) — and why iterating a `PriorityQueue` does *not*
   give sorted order.
3. **Sift up vs sift down.** After a push, the new element is at the end and
   may be too small — swap it upwards. After a pop, you move the last
   element to the root where it may be too large — swap it downwards, always
   with the *smaller* child.
4. **Why `heapify` is O(n), not O(n log n).** Sifting down from the last
   internal node backwards: most nodes are near the bottom and sift a short
   distance. The sum converges to 2n. This surprises people and it is worth
   deriving.
5. **Min-heap vs max-heap.** One comparison. In Java, `PriorityQueue` is a
   **min-heap by default** — the opposite of C++'s `priority_queue`. For a
   max-heap pass `Comparator.reverseOrder()`, never `(a, b) -> b - a`, which
   overflows.

## Implement

- [ ] `push` — append, then sift up
- [ ] `peek` — the root
- [ ] `pop` — take the root, move the last element up, sift down
- [ ] `heapify` — build from an arbitrary array in O(n)

## Traps

- **Sifting down must pick the smaller child.** Picking the left child
  unconditionally breaks the heap property silently.
- **Bounds when a node has one child.** `2i+2` may be past `size`.
- **After `pop`, decrement `size` before sifting down**, or the removed
  element re-enters.
- **Sift over `size`, not `items.length`.** The backing array is bigger.
- **`peek`/`pop` on an empty heap** must throw `NoSuchElementException`,
  not return 0. Tested.

## Test it

```shell
./gradlew test --tests '*MinHeapTest'
```

## Then use it

`dsa.usage.PriorityQueueUsage` for the JDK idioms, and
[`docs/algorithms/shortest-paths.md`](../algorithms/shortest-paths.md) —
Dijkstra and Prim are both "a heap plus bookkeeping".
