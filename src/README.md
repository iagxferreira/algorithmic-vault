# Source Layout

This crate is organized around learning data structures and algorithms in Rust
from first principles.

## Main Areas

- `dsa`: data structures with direct tests for behavior and edge cases.
- `algorithms`: reusable algorithms that can stand alone.
- `strategies`: problem-solving patterns used across many exercises.
- `exercises`: LeetCode-style solutions that compose the lower-level modules.

## Note-Only Subjects

Some folders currently contain notes before code. They are kept as study guides
until the related implementations move into `dsa`, `algorithms`, `strategies`,
or `exercises`.

## Development Rule

Each new implementation should include tests in the same module first. Extract
shared helpers only after the same setup appears in multiple exercises.
