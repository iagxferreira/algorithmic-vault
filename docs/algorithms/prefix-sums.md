# Prefix sums and difference arrays

`dsa.algorithms.scanning` (the prefix half) — 4 classes

## Why this topic

Two mirror-image tricks, both about paying once so the repeated operation
becomes free:

- **Prefix sum** — the array is fixed, you read ranges many times.
  Precompute, then every range sum is one subtraction.
- **Difference array** — you write ranges many times, then read once.
  Record only the endpoints, then prefix-sum at the end.

And one composite: **prefix sum + hash map** counts subarrays with a given
sum in O(n), which is the single most reused counting trick in the subject.

If both reads *and* writes are frequent, neither works and you want a
Fenwick tree — see `dsa.structures.FenwickTree`.

## Understand before you write code

1. **Why the prefix array is exclusive and length n+1.** With
   `prefix[0] = 0`, the sum of `[from, to]` is
   `prefix[to+1] - prefix[from]` with no special case at index 0. The
   inclusive convention forces an `if` into every caller.
2. **The 2D inclusion-exclusion.** Build:
   `pre[r][c] = grid + up + left - upLeft`. Query:
   `bottomRight - above - left + corner`. Draw both on paper once — you
   will not remember the signs otherwise, and guessing is how this breaks.
3. **Why the difference array puts `-delta` at `to + 1`.** The `+delta`
   turns the contribution on at `from`; it has to be turned off *after*
   `to`, not at it. Size the array `n + 1` so that index exists.
4. **Why `SubarrayCount` seeds the map with `{0: 1}`.** A subarray starting
   at index 0 has no earlier prefix to subtract; the seed is that empty
   prefix. Without it you lose every such subarray.
5. **Query before insert.** In the counting loop, look up
   `prefix - k` *before* recording the current prefix, or a zero-length
   subarray counts itself when `k == 0`.
6. **Overflow.** Prefix sums accumulate. On real inputs (HackerRank's
   `array-manipulation` uses n = 10⁷ and deltas up to 10⁹) the running total
   reaches 10¹³. Use `long`.

## Order to implement

- [ ] `PrefixSum` — build and rangeSum; get the exclusive convention right
- [ ] `PrefixSum2D` — the same idea with four terms instead of two
- [ ] `DifferenceArray` — the mirror image
- [ ] `SubarrayCount` — prefix plus a hash map

## Traps

- Off-by-one between `prefix[to]` and `prefix[to + 1]`. Write the
  convention in a comment above the method and stick to it.
- Forgetting the `{0: 1}` seed — see point 4.
- Updating the count map before querying it — see point 5.
- `int` accumulators — see point 6. There is a test for this.
- Reaching for a sliding window on a counting problem with negatives. See
  [`sliding-window.md`](./sliding-window.md), point 3.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.scanning.Prefix*'
./gradlew test --tests '*SubarrayCountTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0303-range-sum-query-immutable` then `0304-range-sum-query-2d-immutable`
- `leetcode/0560-subarray-sum-equals-k` — the composite trick
- `leetcode/1094-car-pooling` — a difference array in disguise
- `hackerrank/array-manipulation` — the difference array, with the overflow
- `leetcode/0307-range-sum-query-mutable` — where prefix sums stop being enough
