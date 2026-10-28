# Breadth-First Search

This module compares two breadth-first search strategies on a tree of boxes.
Each box can hold a key and contain nested boxes. Both searches return a
reference to the box containing the target as `Option<&Box>`, or `None` if it
is absent. Because the search runs level by level, the returned box is the
shallowest one holding the target.

- `iterative_breadth_first_search` is implemented with an explicit queue.
- `recursive_breadth_first_search` recurses over the queue of boxes still to
  visit.

Run both searches' tests with `cargo test`.

Build the example with:

```sh
cargo run
```
