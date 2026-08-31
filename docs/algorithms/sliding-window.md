# Sliding window

`dsa.algorithms.scanning` (the window half) — 3 classes

## Why this topic

A window turns "look at every subarray" — O(n²) or O(n·k) — into a single
O(n) pass. The insight is that moving a window by one position changes it
by exactly two elements, so you update instead of recomputing.

Three shapes, and that is the whole taxonomy:

| Shape | Move | Use when |
|---|---|---|
| **fixed** | both edges together | the window size is given |
| **variable** | grow right, shrink left | the size is what you are solving for |
| **monotonic deque** | as variable, plus a candidate deque | the answer is a max or a min |

## Understand before you write code

1. **Why the variable window is O(n) despite the nested loop.** The inner
   `while` does not restart per outer step — the left edge only ever moves
   forward, so across the whole run it advances at most n times. Total work
   is 2n. Say this out loud; it is the one non-obvious claim here.
2. **Longest vs shortest changes the loop.** For a *longest valid* window
   you shrink while the window is **invalid** and record afterwards. For a
   *shortest valid* window you shrink while it is still **valid** and record
   before shrinking. Same skeleton, opposite condition.
3. **When a window does not apply at all.** Shrinking from the left assumes
   removing an element moves you in a predictable direction. With negative
   numbers that fails — the sum is not monotonic in the window size. That is
   why `SubarrayCount` uses a prefix sum and a hash map instead, and mixing
   these up is the most expensive mistake in this topic.
4. **Why a running max cannot be updated like a running sum.** When the
   maximum leaves the window you have no idea what the new one is. The
   monotonic deque exists precisely to keep that information.
5. **The restatement step.** "Flip at most k zeroes" is really "a window
   with at most k zeroes". "Contains a permutation of p" is really "a fixed
   window whose character counts match". Finding the restatement *is* the
   problem; the code afterwards is the template.

## Order to implement

- [ ] `FixedWindow` — `sums` first, the other two fall out of it
- [ ] `VariableWindow` — `longestUniqueSubstring`, then the shortest-valid variant
- [ ] `MonotonicWindow` — the deque; `minOfEachWindow` is the same code with one flipped comparison

## Traps

- **Shrinking with `if` instead of `while`.** It happens to work when the
  right edge advances one at a time, and breaks the moment it does not.
  Write the `while`.
- **Updating the running state in the wrong order.** Add the entrant before
  checking validity; remove the leaver before advancing the left edge.
- **`k > n` or `k <= 0`** in the fixed window — decide the contract and test
  it. Ours returns 0 / an empty result.
- **Monotonic deque stores indices, not values.** You need the index to
  evict entries that have fallen out of the window.
- **`<=` vs `<` when evicting from the deque** decides how equal values are
  handled. Both give correct maxima; know which you wrote.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.scanning.*Window*'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0121-best-time-to-buy-and-sell-stock` — the simplest window there is
- `leetcode/0003-longest-substring-without-repeating-characters`
- `leetcode/0209-minimum-size-subarray-sum` — the shortest-valid variant
- `leetcode/1004-max-consecutive-ones-iii` — the restatement
- `leetcode/0567-permutation-in-string` and `0438-find-all-anagrams-in-a-string`
- `leetcode/0239-sliding-window-maximum` — the deque
- `leetcode/0076-minimum-window-substring` — the hard one; do it last
