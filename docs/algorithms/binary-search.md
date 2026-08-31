# Binary search

`dsa.algorithms.search` — 7 classes

## Why this topic

Binary search is not one algorithm. It is a way of halving **any** search
space where the answer is monotonic. Most people learn the array version,
stop, and then never recognise it in the wild. The whole point of this
package is the recognition:

| You have | You search |
|---|---|
| a sorted array | the indices |
| a rotated sorted array | the indices, after deciding which half is sorted |
| a row-sorted matrix | the flattened indices |
| a BST | the tree — the structure halves for you |
| a monotonic yes/no question | **the answer itself** |
| an unsorted array with one peak | the indices, walking uphill |

The last two are where the value is.

## Understand before you write code

1. **Closed vs half-open range.** `[low, high]` and `[low, high)` need
   different loop conditions and different updates. Pick one convention and
   use it in all seven files. Mixing them is where every off-by-one comes
   from.
2. **Why `low + (high - low) / 2` and not `(low + high) / 2`.** The sum
   overflows `int` for large indices. Java's own `Arrays.binarySearch` had
   this bug for nine years.
3. **What "monotonic" means.** The predicate must go false…false,
   true…true with exactly one flip. If it can flip back, binary search is
   simply wrong — not slow, wrong.
4. **Why the loop terminates.** Every iteration must strictly shrink the
   range. `high = mid` with a `while (low < high)` loop terminates;
   `high = mid` with `while (low <= high)` spins forever.
5. **What lower bound returns when the target is absent.** (The insertion
   point.) That single fact makes it more useful than plain search.

## Order to implement

- [ ] `BinarySearch` — the base loop, nothing else
- [ ] `Bounds` — lowerBound, upperBound, then the other two fall out
- [ ] `SearchMatrix` — same loop, one index mapping
- [ ] `SearchBst` — same idea, no arithmetic at all
- [ ] `RotatedArray` — first the "which half is sorted" reasoning, then the code
- [ ] `SearchAnswer` — `firstTrue` and `lastTrue`; this is the one that matters
- [ ] `FindPeak` — binary search with no sorted input anywhere

## The two loop shapes

Write these out until you can produce either from memory.

```
// find an exact match — closed range
low = 0; high = n - 1;
while (low <= high) { mid = low + (high - low) / 2; ... low = mid + 1 / high = mid - 1 }

// find a boundary — half-open range, converges on the answer
low = 0; high = n;
while (low < high) { mid = low + (high - low) / 2; if (ok(mid)) high = mid; else low = mid + 1; }
return low;
```

The second shape is `firstTrue`. Once you have it, `lowerBound` is
`firstTrue(i -> a[i] >= target)` and Koko-eating-bananas is
`firstTrue(k -> hoursNeeded(k) <= h)`. Same function, different predicate.

## Traps

- **Overflow in the midpoint** — and separately, overflow inside the
  predicate. `mid * mid` overflows `int` well before `Integer.MAX_VALUE`;
  that is exactly what `integerSquareRoot` is testing.
- **Rotated array with duplicates** is a genuinely different problem and
  degrades to O(n). Ours has distinct values — know that the guarantee is
  what buys you O(log n).
- **`findPeak` on a monotonic array** still has an answer: the edge.
  Solutions that only accept a strict interior peak fail there.
- **Boundary conventions in `firstTrue`**: never true must give
  `high + 1`, not `high`. Callers rely on being able to detect "no answer".

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.search.*'
./gradlew test --tests '*SearchAnswerTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0704-binary-search` — the base loop, done properly
- `leetcode/0035-search-insert-position` — lower bound in disguise
- `leetcode/0033-search-in-rotated-sorted-array` and `0153-find-minimum-in-rotated-sorted-array`
- `leetcode/0875-koko-eating-bananas` — binary search on the answer
- `leetcode/0278-first-bad-version` — `firstTrue` with the predicate handed to you
- `leetcode/0004-median-of-two-sorted-arrays` — the hard one; partition search
