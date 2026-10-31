# Exercise 1.2: Word puzzle

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.2.

## Task

Given a two-dimensional grid of letters and a list of words, find every word in
the grid and report where it occurs. Words may run left, right, up, down, or
along either diagonal, so there are eight directions to check.

## Requirements

- [ ] Represent the grid and the word list.
- [ ] Search all eight directions from every starting cell.
- [ ] Report each match with its row, column, and direction.
- [ ] Handle words that are not present.
- [ ] Record the complexity of the search in the book notes.

## Scaffold

- `main.cpp` - stub; add the program here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

Keep the search function separate from the example grid so it can be tested with
small puzzles. Think about how to avoid reading past the grid edges while
matching a word.
