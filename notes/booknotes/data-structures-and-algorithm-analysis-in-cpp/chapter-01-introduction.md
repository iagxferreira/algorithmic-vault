# Chapter 1: Introduction

Chapter 1 introduces the goals of algorithm analysis: correctness, running
time, and the trade-offs between different algorithms for the same problem.

## Exercise 1.1: Selection problem

**Task.** Solve the selection problem with $k = N/2$, then draw a table showing
the running time of the program for various values of $N$.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/01-selection-problem/`.

## Exercise 1.2: Word puzzle

**Task.** Given a two-dimensional grid of letters and a list of words, find
every word in the grid. Words may run in any of the eight directions.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/02-word-puzzle/`.

## Exercise 1.3: Printing a double with printDigit

**Task.** Write a function that outputs an arbitrary double, which may be
negative, using only `printDigit` for I/O.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/03-print-double/`.

## Exercise 1.4: Expanding include directives

**Task.** Read a file and output it with every `#include filename` line replaced
by the contents of that file. Includes may be nested, but a file never includes
itself in any chain.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/04-include-expansion/`.

## Exercise 1.5: Counting 1 bits recursively

**Task.** Write a recursive function that returns the number of 1s in the
binary representation of $N$, using the fact that it equals the number of 1s in
$N/2$ plus one when $N$ is odd.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/05-count-one-bits/`.

## Exercise 1.6: Permutations

**Task.** Write `permute(const string& str)` as a driver that calls
`permute(const string& str, int low, int high)`, which recursively prints all
permutations of the characters in `str`.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/06-permutations/`.

## Exercise 1.7: Logarithm formulas

**Task.** Prove the following for $X > 0$:

(a) $\log X < X$.

(b) $\log(A^B) = B \log A$.

**Answer.** TODO.

## Exercise 1.8: Evaluating sums

**Task.** Evaluate:

(a) $\sum_{i=0}^{\infty} \frac{1}{4^i}$.

(b) $\sum_{i=0}^{\infty} \frac{i}{4^i}$.

(c) $\sum_{i=0}^{\infty} \frac{i^2}{4^i}$.

(d) $\sum_{i=0}^{\infty} \frac{i^N}{4^i}$.

**Answer.** TODO.

## Exercise 1.9: Estimating a partial harmonic sum

**Task.** Estimate $\sum_{i=\lceil N/2 \rceil}^{N} \frac{1}{i}$.

**Answer.** TODO.

## Exercise 1.10: Modular exponentiation

**Task.** Compute $2^{100} \pmod{5}$.

**Answer.** TODO.

## Exercise 1.11: Fibonacci numbers

**Task.** For the Fibonacci numbers $F_i$:

(a) Prove $\sum_{i=1}^{N} F_i = F_{N+2} - 1$.

(b) Prove $F_N < \phi^N$, where $\phi = (1 + \sqrt{5})/2$.

(c) Give a precise closed-form expression for $F_N$.

**Answer.** TODO.

## Exercise 1.12: Summation formulas

**Task.** Prove:

(a) $\sum_{i=1}^{N} (2i - 1) = N^2$.

(b) $\sum_{i=1}^{N} i^3 = \left( \sum_{i=1}^{N} i \right)^2$.

**Answer.** TODO.

## Exercise 1.13: Collection class template

**Task.** Design a class template `Collection` that stores a collection of
`Object`s in an array together with the current size. Provide `isEmpty`,
`makeEmpty`, `insert`, `remove`, and `contains`; `contains(x)` returns true if
and only if an object equal to `x` is present.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/13-collection/`.

## Exercise 1.14: OrderedCollection class template

**Task.** Design a class template `OrderedCollection` that stores a collection
of `Comparable`s in an array together with the current size. Provide `isEmpty`,
`makeEmpty`, `insert`, `remove`, `findMin`, and `findMax`, where the last two
return references to the smallest and largest elements. Explain what can be done
when these operations are performed on an empty collection.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/14-ordered-collection/`.

## Exercise 1.15: Rectangle and findMax

**Task.** Define a `Rectangle` class with `getLength` and `getWidth`. Using the
`findMax` routines from Figure 1.25, write a main that creates an array of
`Rectangle`s and finds the largest one first by area and then by perimeter.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/15-rectangle-findmax/`.

## Exercise 1.16: Extending the matrix class

**Task.** For the matrix class, add a `resize` member function and a
zero-parameter constructor.

**Answer.** TODO.

Implementation scaffold:
`impl/exercises/weiss/chapter-01/16-matrix-resize/`.
