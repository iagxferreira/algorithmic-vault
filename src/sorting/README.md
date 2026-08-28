# Sorting In Rust

Notes and goals for sorting algorithms.

The current starter implementation lives in:

- `src/algorithms/sorting.rs`

## Core Concepts

- In-place sorting works naturally with mutable slices.
- Stable sorting preserves equal-element order; unstable sorting does not.
- Divide-and-conquer sorts often allocate unless carefully written in place.
- Testing should include duplicates and already-sorted inputs.

## Implemented Goals

- Selection sort.

## Next Goals

1. Insertion sort.
2. Bubble sort as a learning baseline.
3. Merge sort.
4. Quick sort.
5. Heap sort.
6. Counting sort for bounded integer ranges.
