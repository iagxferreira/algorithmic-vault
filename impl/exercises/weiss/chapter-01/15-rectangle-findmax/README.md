# Exercise 1.15: Rectangle and findMax

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.15.

## Task

Define a `Rectangle` class that provides `getLength` and `getWidth`. Using the
`findMax` routines from Figure 1.25 of the book, write a `main` that creates an
array of `Rectangle`s and finds the largest rectangle first on the basis of area
and then on the basis of perimeter.

## Requirements

- [ ] Implement `Rectangle` with `getLength` and `getWidth`.
- [ ] Add area and perimeter helpers.
- [ ] Write a generic `findMax` that accepts a comparison function or predicate.
- [ ] Find the largest rectangle by area.
- [ ] Find the largest rectangle by perimeter.
- [ ] Test ties and a single-element array.

## Scaffold

- `main.cpp` - stub; add the class, `findMax`, and the example here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

The two searches differ only in the comparison, which is the point of the
generic `findMax`. Keep the comparison logic separate from the search loop.
