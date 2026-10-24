# Implementations

This folder is a Cargo workspace for hands-on Rust implementations. Each
algorithm exercise is its own crate, so exercises stay independent and build
fast. The older C++ sources and Makefiles are legacy reference and are being
retired as each topic is ported.

## Layout

```text
impl/
  Cargo.toml
  algorithms/
    sorting/
      insertion_sort/
        Cargo.toml
        src/
          lib.rs        # the algorithm and its unit tests
          main.rs       # example program, mirrors the C++ example
    graph/
  exercises/
    clrs/
      binary_addition/
        Cargo.toml
        src/
          lib.rs
          main.rs
  data-structures/
```

Each crate follows the same shape:

- `Cargo.toml` declares the crate with the folder's name.
- `src/lib.rs` holds the exported algorithm and its `#[cfg(test)]` unit tests,
  so `cargo test` from anywhere in the workspace exercises it.
- `src/main.rs` holds the example program: `cargo run` inside the crate folder.

Build, test, and lint a focused implementation from its own folder:

```sh
cargo build
cargo test
cargo fmt
cargo clippy
```

Or work across the whole workspace from `impl/`:

```sh
cargo test --workspace
cargo clippy --workspace --all-targets
```

Keep book-specific explanations and exercise answers under
[`notes/booknotes/`](../notes/booknotes/README.md). Shared helpers are not
needed yet; a crate stays self-contained and only grows a dependency on a
sibling crate when several algorithms genuinely share code.

Legacy C++ structure (folder per algorithm with `.h`/`.cpp`/`Makefile`) is
described by each topic's README until it is removed.
