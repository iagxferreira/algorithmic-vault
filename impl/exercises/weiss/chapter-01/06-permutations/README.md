# Exercise 1.6: Permutations

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.6.

## Task

Write two routines:

```cpp
void permute(const std::string& str);
void permute(const std::string& str, int low, int high);
```

The first is a driver that calls the second. The second uses recursion to print
all permutations of the characters in `str`. For `"abc"` the output should be
`abc`, `acb`, `bac`, `bca`, `cab`, and `cba`.

## Requirements

- [ ] Implement the driver overload.
- [ ] Implement the recursive overload.
- [ ] Print each permutation exactly once.
- [ ] Check the output for an empty string, one character, and repeated
      characters.
- [ ] Record the recursion tree and the complexity in the book notes.

## Scaffold

- `main.cpp` - stub; add the program here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

The signature takes a `const` reference, so each recursive step needs its own
copy if characters are swapped. Compare the produced order with the order listed
in the exercise.
