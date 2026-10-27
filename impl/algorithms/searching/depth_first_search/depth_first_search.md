# Depth-First Search

This module compares two depth-first search strategies on a tree of boxes. Each
box can hold a key and contain nested boxes. Both searches return a reference
to the box containing the target as `Option<&Box>`, or `None` if it is absent.

- `iterative_depth_first_search` is implemented with an explicit stack.
- `recursive_depth_first_search` searches by recursively visiting each child.

Run both searches' tests with `cargo test`.

Build the example with:

```sh
cargo run
```
