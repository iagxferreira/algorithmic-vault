# Sorting

`dsa.algorithms.sorting` — 10 classes

## Why this topic first

You will almost always call `Arrays.sort` in real code. You write these
anyway because the *ideas* inside them are reused everywhere else:

- **merge sort** is the divide-and-conquer template — you reuse it for
  counting inversions, and the same shape appears in merge-k-lists
- **quicksort** is really *partitioning*, which on its own gives you
  quickselect and O(n) k-th largest
- **heap sort** forces you to understand sift-down, which is the same
  routine as `MinHeap`
- **counting sort** is the proof that O(n log n) is only a lower bound for
  *comparison* sorts

## Understand before you write code

Answer these out loud. If you cannot, reading the implementation will not
help.

1. **What makes a sort stable, and when do you care?** (Two records with
   the same key — does their relative order survive?) Which of the seven
   below are stable?
2. **Why is O(n log n) a lower bound for comparison sorts?** A sort that
   only compares can distinguish at most 2^(comparisons) orderings, and
   there are n! of them. So how does counting sort escape it?
3. **In-place vs extra memory.** Merge sort needs O(n) scratch; heap sort
   needs O(1). Why can merge sort not be made in-place easily?
4. **Why does quicksort degrade to O(n²)?** What input does it on, and
   what does picking a random or median-of-three pivot actually fix?
5. **What is a loop invariant?** For insertion sort: "everything before
   index i is sorted". Say the invariant for each sort before coding it.

## Order to implement

Each file is one sitting. Run its test, make it green, move on.

- [ ] `SelectionSort` — simplest to reason about; n swaps maximum
- [ ] `BubbleSort` — add the early-exit flag, then check it is O(n) on sorted input
- [ ] `InsertionSort` — the one that is genuinely useful; note why it is fast on nearly-sorted data
- [ ] `MergeSort` — write the merge as its own private method first
- [ ] `Partition` — do this **before** `QuickSort`; it is the hard part
- [ ] `QuickSort` — now it is six lines on top of `Partition`
- [ ] `QuickSelect` — recurse into one side instead of two; derive why that is O(n)
- [ ] `HeapSort` — build the heap in place, then shrink it
- [ ] `CountingSort` — no comparisons at all
- [ ] `CountInversions` — merge sort solving a problem that is not sorting

## The comparison worth memorising

| Sort | Best | Average | Worst | Space | Stable |
|---|---|---|---|---|---|
| Selection | n² | n² | n² | 1 | no |
| Bubble | n | n² | n² | 1 | yes |
| Insertion | n | n² | n² | 1 | yes |
| Merge | n log n | n log n | n log n | n | yes |
| Quick | n log n | n log n | n² | log n | no |
| Heap | n log n | n log n | n log n | 1 | no |
| Counting | n + k | n + k | n + k | k | yes |

## Traps

- **Merge**: after one half runs out, you still have to drain the other.
  Forgetting that drops elements silently.
- **Quicksort**: an off-by-one in the recursion bounds gives infinite
  recursion, not a wrong answer. Recurse on `[low, p-1]` and `[p+1, high]`
  — the pivot itself is done.
- **Heap sort**: the heap shrinks as you swap elements to the end. Sift
  down over the *shrinking* size, not the array length.
- **Counting sort**: the counts array needs `max + 1` slots, not `max`.
- **Inversions**: the count reaches n(n−1)/2, which overflows `int` at
  n ≈ 65 000. Use `long`.
- **`Arrays.sort(int[])` is hackable** — it is dual-pivot quicksort with
  adversarial O(n²) inputs. Shuffle first, or sort a boxed `Integer[]`
  which uses TimSort. This matters on Codeforces, not in your app.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.sorting.*'      # the whole topic
./gradlew test --tests '*MergeSortTest'                # one sitting
```

`SortContract` in the test sources is the shared behaviour every sort must
satisfy, including a randomised cross-check against `Arrays.sort`.

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0912-sort-an-array` — write it against anti-quicksort tests
- `leetcode/0215-kth-largest-element-in-an-array` — quickselect
- `leetcode/0315-count-of-smaller-numbers-after-self` — inversions per index
- `leetcode/0179-largest-number` — a comparator that must be a valid ordering
- `leetcode/0075-sort-colors` — three-way partition
