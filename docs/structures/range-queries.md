# Fenwick and segment trees

`dsa.structures.FenwickTree`, `dsa.structures.SegmentTree`

## Why build them

There is a gap that prefix sums cannot fill. A prefix-sum array answers
range queries in O(1) but costs O(n) per update. A plain array updates in
O(1) but costs O(n) per query. **When updates and queries are interleaved,
both are O(n) on average and both are too slow.**

These two make both operations O(log n). They are the workhorse of
competitive programming and the first structure here you would not
reasonably invent yourself.

| | build | update | query | code |
|---|---|---|---|---|
| prefix sum | O(n) | O(n) | O(1) | 2 lines |
| Fenwick | O(n log n) | O(log n) | O(log n) | ~15 lines |
| segment tree | O(n) | O(log n) | O(log n) | ~40 lines |

## Understand before you write code

**Fenwick tree (binary indexed tree)**

1. **`i & -i` isolates the lowest set bit.** That value is the *size of the
   range* node `i` is responsible for. Everything follows from this.
2. **Walk up by `i += i & -i` when updating**, down by `i -= i & -i` when
   querying a prefix. Trace both by hand for n = 8 before coding.
3. **It must be 1-indexed.** `0 & -0` is 0, so the loop never advances from
   zero. Convert at the API boundary.
4. **It stores prefix aggregates**, so range sum is
   `prefix(to) - prefix(from-1)`. That means it only works for *invertible*
   operations — sums yes, minimums no.

**Segment tree**

5. **Any associative merge works** — sum, min, max, gcd. That generality is
   what you buy with the extra code, and it is why min queries need this
   rather than a Fenwick tree.
6. **An array of size 4n is always enough.** Node `i` has children at `2i`
   and `2i+1`. Prove the 4n bound to yourself rather than trusting it.
7. **Query recursion has three cases**: the node's range is fully outside
   (return the identity), fully inside (return the node), or partial
   (recurse both children and merge). Those early exits are what make it
   O(log n).

## Implement

`FenwickTree`:
- [ ] `update` (a **delta**, not an assignment) and `prefixSum`
- [ ] `rangeSum` — one subtraction
- [ ] `of(int[])` — build from an initial array

`SegmentTree`:
- [ ] the constructor — recursive build
- [ ] `rangeSum`, `rangeMin` — same skeleton, different merge
- [ ] `set` — point assignment, then fix the ancestors

## Traps

- **Fenwick is 1-indexed internally, 0-indexed in our API.** Convert in one
  place.
- **`update` takes a delta.** If a problem gives you an absolute new value,
  keep the raw array and pass `newValue - old`.
- **Identity elements.** Sum's identity is 0; min's is `Integer.MAX_VALUE`.
  Returning 0 for an out-of-range min query is a silent wrong answer.
- **Segment tree indices.** Whether you use 1-based node indexing with
  `2i`/`2i+1` or 0-based with `2i+1`/`2i+2` — pick one and be consistent.
- **Negative values** are tested for both, because a min tree initialised to
  0 looks right until a value goes below zero.
- **Not implemented here: lazy propagation**, which is what you need for
  *range* updates rather than point updates. That is the natural next step.

## Test it

```shell
./gradlew test --tests '*FenwickTreeTest'
./gradlew test --tests '*SegmentTreeTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):
`leetcode/0303-range-sum-query-immutable` (the prefix-sum baseline),
`0307-range-sum-query-mutable` (where it breaks down),
`0315-count-of-smaller-numbers-after-self` (Fenwick over compressed values).
