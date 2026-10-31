# Exercise 1.1: Selection problem

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.1.

## Task

Write a program that solves the selection problem: given $N$ values, find the
$k$-th largest value with $k = N/2$. Then measure the running time for several
values of $N$ and print a table of the results.

## Requirements

- [ ] Read or generate the input values.
- [ ] Find the $k$-th largest value for $k = N/2$.
- [ ] Time the selection for several $N$ (for example, doubling $N$).
- [ ] Print a table with columns for $N$ and running time.
- [ ] Explain the observed growth in the book notes.

## Scaffold

- `main.cpp` - stub; add the program here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

Keep the selection routine separate from the timing harness so it can be reused
and tested. Decide which selection algorithm to study before implementing; the
Chapter 1 discussion starts with a simple repeated-maximum approach.
