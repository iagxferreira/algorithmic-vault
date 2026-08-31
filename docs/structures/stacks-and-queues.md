# Stacks and queues

`dsa.structures.ArrayStack`, `dsa.structures.CircularQueue`

## Why build them

They are the two access disciplines — last-in-first-out and
first-in-first-out — and that single choice is what separates DFS from BFS.
Both are trivial to implement and central to everything after.

## Understand before you write code

1. **LIFO vs FIFO decides your traversal.** A stack explores deep, a queue
   explores in rings. Same algorithm, different container. That is not a
   metaphor — see
   [`docs/algorithms/graph-traversal.md`](../algorithms/graph-traversal.md).
2. **Why a queue needs a *ring* buffer.** A naive array queue either shifts
   every element on dequeue (O(n)) or leaks space at the front forever. A
   ring reuses the vacated slots: the tail slot is
   `(head + size) % capacity`.
3. **Why track `size` rather than a separate `tail` index.** With `head` and
   `tail` alone, a full queue and an empty queue look identical
   (`head == tail`). Storing `size` removes the ambiguity — the alternative
   is wasting one slot.
4. **Where each shows up.** Stack: parentheses matching, expression
   evaluation, iterative DFS, monotonic-stack problems, undo. Queue: BFS,
   level-order traversal, task scheduling, streaming windows.

## Implement

`ArrayStack`:
- [ ] `push` with the doubling grow, `pop`, `peek`
- [ ] `pop` on empty throws `NoSuchElementException`

`CircularQueue`:
- [ ] `enqueue`, `dequeue`, `peek` — all O(1)
- [ ] `isFull`, and `enqueue` returning `false` when full
- [ ] wrap-around: fill, drain partway, refill past the end

## Traps

- **Modulo arithmetic on the head.** `head = (head + 1) % capacity`, not
  `head++`. Tested with a fill-drain-refill cycle.
- **Empty vs full ambiguity** — see point 3.
- **`pop`/`dequeue` on empty.** Decide the contract: `ArrayStack.pop`
  throws, `CircularQueue.dequeue` returns null. Both are tested; both are
  defensible; be deliberate.
- **In real Java, use `ArrayDeque`** for both — never the legacy `Stack`
  (synchronised) or `LinkedList` (an allocation per element).

## Test it

```shell
./gradlew test --tests '*ArrayStackTest'
./gradlew test --tests '*CircularQueueTest'
```

## Then use it

`dsa.usage.DequeUsage` drives the JDK `ArrayDeque` as both a stack and a
queue. The monotonic-deque variant is in
[`docs/algorithms/sliding-window.md`](../algorithms/sliding-window.md).
