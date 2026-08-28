# Rust Basics

Foundational Rust exercises for building comfort before implementing data
structures and algorithms.

## Goals

- Practice ownership, borrowing, and references.
- Work with `Vec`, arrays, slices, strings, tuples, structs, enums, and matches.
- Write small pure functions with unit tests.
- Prefer explicit types when learning, then simplify once the code is clear.

## Exercise Ideas

1. Read and transform vectors using iterators.
2. Implement manual loops over slices.
3. Count characters and words in strings.
4. Convert between `String`, `&str`, and `Vec<char>`.
5. Model simple states with enums.
6. Use structs to group related values.
7. Return `Option<T>` for missing values.
8. Return `Result<T, E>` for fallible operations.
9. Write tests for edge cases like empty inputs.
10. Rewrite simple solutions with iterators after the loop version works.

## Recommended Location

Rust basics should live under focused modules in `src/algorithms` or
`src/exercises` when they become reusable. Keep this file as a study checklist,
not as a separate crate module.
