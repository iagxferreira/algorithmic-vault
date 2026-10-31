# Exercise 1.5: Counting 1 bits recursively

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.5.

## Task

Write a recursive function that returns the number of 1s in the binary
representation of $N$. Use the fact that this count equals the number of 1s in
the representation of $N/2$, plus one when $N$ is odd.

## Requirements

- [ ] Use recursion, with a base case for zero.
- [ ] Return the correct count for powers of two, all-ones values, and zero.
- [ ] Decide how to treat the input domain (for example, nonnegative integers).
- [ ] Add tests for boundary values.

## Scaffold

- `main.cpp` - stub; add the program here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

The recurrence is `ones(N) = ones(N / 2) + N % 2`. Check what happens with
signed negative inputs before choosing the parameter type.
