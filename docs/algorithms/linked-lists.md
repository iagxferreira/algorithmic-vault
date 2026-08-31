# Linked lists

`dsa.algorithms.list` — 5 classes
Structure to build first: `dsa.structures.SinglyLinkedList`

## Why this topic

A linked list is the smallest possible pointer-manipulation exercise. It
gives you one operation — follow `next` — so every problem becomes a
question of *which pointers you are holding and in what order you move
them*. That discipline is the whole subject, and it transfers directly to
trees and graphs.

There are only three patterns underneath everything here:

1. **One pointer walking** — length, sum, find the tail
2. **Two pointers at different speeds** — middle, cycle detection
3. **Two pointers at a fixed gap** — k-th from the end, remove-nth

Plus one rewiring technique: **three-pointer reversal**.

## Understand before you write code

1. **Why `null` is the whole edge-case surface.** Empty list, one node,
   and "the node after the last one" are the three cases that break naive
   code. Write the empty case first, always.
2. **What a dummy head node buys you.** If you ever write "if this is the
   first node, do something different", a dummy node in front removes that
   branch. Reach for it whenever the head can change.
3. **Why fast/slow finds the middle.** Fast moves twice as far in the same
   time, so when fast has covered n, slow has covered n/2.
4. **Why the tortoise and hare must meet inside a cycle.** Each tick the
   gap between them shrinks by exactly one, modulo the cycle length. So
   the gap reaches zero.
5. **The cycle-entrance proof.** If the tail before the cycle is length
   `a` and they meet `b` into a cycle of length `c`, then
   `a ≡ -b (mod c)`. So a pointer from the head and a pointer from the
   meeting point, both moving one step, arrive together. Derive it once.
6. **O(1) space vs O(n).** Nearly every list problem has a trivial
   solution that copies into an `ArrayList`. That solution is correct and
   teaches nothing. The constraint is the exercise.

## Order to implement

- [ ] `TraverseList` — get the walking loop automatic
- [ ] `ReverseList` — iterative first, then recursive
- [ ] `FastSlowPointers` — middle, then the fixed-gap variant
- [ ] `DetectCycle` — hasCycle, then the entrance, then the length
- [ ] `ListPalindrome` — assembled from the three above

## Traps

- **Losing the rest of the list.** In reversal you must save `next` before
  overwriting `current.next`. This is the mistake everyone makes once.
- **`fast.next` vs `fast.next.next`.** Check both are non-null before
  stepping, and check them in that order — the reverse order NPEs.
- **Off-by-one on the middle.** Starting `fast` at `head` versus
  `head.next` decides whether an even-length list returns the first or
  second middle. Ours wants the second.
- **k-th from end is 1-based.** k = 1 is the last node, not the
  second-last.
- **`ListPalindrome` mutates the list** if you reverse the second half in
  place. That is fine for the test, but know you did it — real callers may
  not expect it.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.list.*'
./gradlew test --tests '*DetectCycleTest'
```

`ListNodes.of(...)`, `.toArray(...)` and `.withCycleAt(...)` in
`dsa.support` build and inspect chains for you — that part is already
written.

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0206-reverse-linked-list` then `0092-reverse-linked-list-ii`
- `leetcode/0876-middle-of-the-linked-list`
- `leetcode/0141-linked-list-cycle` — and 287, which is this on an array
- `leetcode/0019-remove-nth-node-from-end-of-list` — fixed gap plus a dummy head
- `leetcode/0234-palindrome-linked-list`
- `leetcode/0143-reorder-list` — middle + reverse + merge, all three at once
- `leetcode/0025-reverse-nodes-in-k-group` — the hard version of reversal
