# Quicksort

`quick_sort` uses recursion to partition the input around a pivot and returns a
new vector in ascending order. Values equal to the pivot are grouped together
to handle duplicate values without unproductive recursive calls.

This version allocates temporary vectors rather than sorting in place. Its
average running time is `O(n log n)` and its worst case is `O(n^2)`.

Build the example with:

```sh
make build
```
