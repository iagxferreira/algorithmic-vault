# Exercise 1.4: Expanding include directives

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.4.

## Task

Write a program that reads a file and outputs it with every
`#include filename` line replaced by the contents of `filename`. Include
statements may be nested, but a file never includes itself in any chain.

## Requirements

- [ ] Accept the input file path (for example, as a command-line argument).
- [ ] Replace `#include filename` lines with the referenced file's contents.
- [ ] Process includes recursively so nested includes are expanded.
- [ ] Handle missing files without crashing.
- [ ] Guard against accidental cycles even though the exercise promises none.

## Scaffold

- `main.cpp` - stub; add the program here.
- `Makefile` - builds `build/main`; `make run ARGS=file.txt` executes it.

## Notes

The book uses the simplified form `#include filename`, without angle brackets or
quotes. Keep the expansion logic separate from `main` so it can be tested with
temporary files.
