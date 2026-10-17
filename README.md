# Algorithm Studies

A C++ competitive-programming workbook for learning algorithms and data
structures through problem solving. The goal is to build sound reasoning,
recognize common techniques, and write correct, efficient C++ solutions under
contest constraints.

## Start here

1. Follow [`ROADMAP.md`](./ROADMAP.md) and choose a topic.
2. Study the technique, including its invariant, complexity, and edge cases.
3. Solve representative problems and record the reusable idea and pitfalls.
4. Compile with warnings and test boundary cases before considering a topic
   complete.

## C++ baseline

- Use **C++20** unless a problem or judge requires another standard.
- Prefer standard-library containers and algorithms; implement core structures
  from scratch when studying their internals.
- Make complexity and integer bounds explicit. Use 64-bit integers when the
  constraints require them, and avoid overflow in intermediate calculations.
- Keep solutions self-contained and suitable for online judges: standard input
  and output, no external dependencies, and no reliance on local files.

Put the current solution in `main.cpp`, then build and run it with:

```sh
make build
make run
```

The `Makefile` uses `g++` and C++20 by default. Override `CXX`, `SOURCE`, or
`TARGET` when needed; pass runtime arguments with `ARGS`.

## Learning approach

Prioritize problem-solving patterns over accumulating code snippets. For each
topic, understand when it applies, prove why it works, analyze time and space,
and practice variations. Keep reusable templates small, tested, and justified.
