# Exercise 1.16: Extending the matrix class

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.16.

## Task

For the matrix class, add a `resize` member function and a zero-parameter
constructor.

## Requirements

- [ ] Add a zero-parameter constructor that creates a valid empty matrix.
- [ ] Add `resize` that changes the dimensions.
- [ ] Decide whether `resize` preserves existing values and document the choice.
- [ ] Update the existing matrix tests for the new members.
- [ ] Keep the existing constructors and operations working.

## Scaffold

This exercise extends the existing class in
[`impl/data-structures/matrix/`](../../../../data-structures/matrix/matrix.h);
there is no separate `main.cpp` here. Add the members there and a usage case to
that folder's example or tests.

The matrix folder already has a test harness:
`make -C impl/data-structures/matrix test`. It covers the existing constructors
and indexing; add cases for the new members as part of this exercise.

## Notes

Changing dimensions invalidates stored values unless they are copied over.
Think about the interaction between `resize` and the representation used by
`matrix` before writing the code.
