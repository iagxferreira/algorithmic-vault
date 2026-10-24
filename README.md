# Algorithmic Vault

A personal Rust workspace for implementing algorithms, tracking study progress,
and organizing book-based notes. The focus is on understanding techniques and
their correctness, complexity, and edge cases — and on becoming fluent in
idiomatic Rust along the way.

The older C++ implementations and Makefiles are kept in
[`impl/`](./impl/README.md) for reference, but new work is Rust-only.

## Start here

1. Follow [`ROADMAP.md`](./ROADMAP.md) and choose a topic.
2. Study the technique, including its invariant, complexity, and edge cases.
3. Solve representative problems and record the reusable idea and pitfalls.
4. Build cleanly with `clippy` and `rustfmt`, cover boundary cases with tests,
   and run them before considering a topic complete.

## Study materials

- [`impl/`](./impl/README.md) is for hands-on Rust algorithm and data-structure
  implementations, organized by topic and algorithm. The existing C++ folders
  are historical reference; add Rust work alongside them or in new folders.
- [`notes/`](./notes/README.md) keeps book notes separated by title and edition
  for easy reference. CLRS notes are in LaTeX; general study notes can be in
  Markdown.

## Rust baseline

- Track the latest **stable** Rust. Update the toolchain regularly and let the
  2021+ idioms (iterators, `Option`/`Result`, ownership-aware APIs) lead the
  design instead of translating C++ directly.
- Use **Cargo** per crate or one workspace crate with one module per algorithm;
  prefer `cargo` layout (`src/`, `tests/`) over ad-hoc build files.
- Prefer standard-library containers and algorithms; implement core structures
  from scratch when studying their internals.
- Make complexity and integer bounds explicit. Use checked/wrapping arithmetic
  consciously, reach for `u64`/`i64` when constraints require them, and let
  `debug_assert!` and overflow checks catch mistakes during development.
- Keep solutions self-contained and suitable for online judges: read from
  standard input, write to standard output, no external crates unless a judge
  allows them.

Build, test, and lint a focused implementation from its own folder:

```sh
cargo build
cargo test
cargo fmt
cargo clippy
```

## Learning approach

Prioritize problem-solving patterns over accumulating code snippets. For each
topic, understand when it applies, prove why it works, analyze time and space,
and practice variations. Keep reusable templates small, tested, and justified —
and treat every implementation as a chance to deepen ownership, borrowing, and
lifetimes intuition.
