# Insertion Sort

The code keeps the prefix through `low` sorted. It saves `values[low]` as the
`key`, shifts larger values one position to the right, then places the key in
the open position. These are shifts, not swaps.

## Small visual trace

Start with `[3, 1, 2]`:

```text
index:   0  1  2
values: [3, 1, 2]
```

At `low = 0`, the first value is already a sorted prefix of length one, so
nothing moves.

At `low = 1`, `key = 1` and `i = 1`:

```text
values: [3, 1, 2]     key = 1
         ^  ^
       i-1   i
```

Since `values[i - 1]` is `3` and `3 > key`, shift `3` right and decrement `i`:

```text
values: [3, 3, 2]     i = 0
```

There is no earlier value to compare. Put `key` at `values[i]`:

```text
values: [1, 3, 2]     prefix [1, 3] is sorted
```

At `low = 2`, `key = 2` and `i = 2`:

```text
values: [1, 3, 2]     key = 2
            ^  ^
          i-1   i
```

`3 > 2`, so shift `3` right and move `i` left:

```text
values: [1, 3, 3]     i = 1
```

Now `values[i - 1]` is `1`, and `1 > 2` is false. Put `key` at `values[i]`:

```text
values: [1, 2, 3]     whole array is sorted
```

Here `low` moves forward through the array, while `i` moves backward through
the sorted prefix to find where the key belongs.
