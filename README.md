# Algorithm Studies

A personal workspace for studying algorithms and data structures: implement
them, work through books, and keep the material organized and easy to find.
Solutions use C++20, with a focus on understanding techniques and their
correctness, complexity, and edge cases.

## Start here

1. Follow [`ROADMAP.md`](./ROADMAP.md) and choose a topic.
2. Study the technique, including its invariant, complexity, and edge cases.
3. Solve representative problems and record the reusable idea and pitfalls.
4. Compile with warnings and test boundary cases before considering a topic
   complete.

## Study materials

- [`core/`](./core/README.md) is for hands-on C++ algorithm and data-structure
  implementations, organized by topic and algorithm.
- [`notes/`](./notes/README.md) keeps book notes separated by title and edition
  for easy reference. CLRS notes are in LaTeX; general study notes can be in
  Markdown.

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
