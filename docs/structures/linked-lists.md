# Linked lists

`dsa.structures.SinglyLinkedList`, `dsa.structures.DoublyLinkedList`

Algorithms on lists live separately, in
[`docs/algorithms/linked-lists.md`](../algorithms/linked-lists.md). Build
the structures here first.

## Why build them

An array gives you random access and expensive insertion; a linked list
gives you the exact opposite. Knowing *which* is why you can answer "why is
`LinkedList` almost never the right choice in Java" — it is, but only when
you already hold the node.

## Understand before you write code

1. **The trade against an array.** Access by index is O(n) here, and O(1)
   there. Insertion given a node is O(1) here, O(n) there. Everything
   follows from that.
2. **Why a tail pointer matters.** Without one, `addLast` is O(n). With one
   it is O(1) — but `removeLast` on a *singly* linked list is still O(n),
   because you cannot find the new tail's predecessor. That asymmetry is
   precisely what a doubly linked list fixes.
3. **What sentinel nodes buy you.** A permanent dummy head (and tail) means
   no node is ever first or last, so insertion and removal have no special
   cases at all. Write `DoublyLinkedList` with sentinels and compare it to
   the singly linked version without them.
4. **Why memory locality matters in practice.** An array's elements sit
   together and the CPU cache loves that. A linked list's nodes are
   scattered, plus each carries a pointer. This is why `ArrayList` beats
   `LinkedList` on real hardware even for operations where the big-O says
   otherwise.

## Implement

`SinglyLinkedList`:
- [ ] `addFirst`, `addLast`, `size` — maintain head, tail and size together
- [ ] `removeFirst`, `removeLast` — note which one is O(n) and why
- [ ] `get`, `contains`
- [ ] `reverse` — in place, one pass
- [ ] `iterator` — so the class works with for-each

`DoublyLinkedList`:
- [ ] `addFirst`, `addLast`, `removeFirst`, `removeLast` — all O(1)
- [ ] `peekFirst`, `peekLast`
- [ ] `toList`, `toReversedList` — the reversed walk proves the back links

## Traps

- **Forgetting to update `tail`** when the list becomes empty or gains its
  first element. Both directions. This is the single most common bug.
- **Forgetting to update `size`** on one path out of four.
- **After `reverse`, the tail is the old head.** Update both pointers, or
  the next `addLast` corrupts the list. There is a test for this.
- **Doubly linked removal must fix both neighbours** — `prev.next` and
  `next.prev`. Missing one leaves the list walkable forwards and broken
  backwards, which is why `toReversedList` is tested.
- **`iterator()` must not expose nodes.** Yield values.

## Test it

```shell
./gradlew test --tests '*SinglyLinkedListTest'
./gradlew test --tests '*DoublyLinkedListTest'
```

## Then use it

`DoublyLinkedList` is half of `LRUCache` — see
[`hash-tables.md`](./hash-tables.md). And the algorithms are in
[`docs/algorithms/linked-lists.md`](../algorithms/linked-lists.md).
