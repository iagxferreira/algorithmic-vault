# Depth-First Search

This module compares two depth-first search strategies on a tree of boxes. Each
box can hold a key and contain nested boxes. Both searches return a pointer to
the box containing the target, or `nullptr` if it is absent.

- `iterative_depth_first_search` is implemented with an explicit stack.
- `recursive_depth_first_search` searches by recursively visiting each child.

Run the iterative tests with `make test` and the recursive tests with
`make recursive-test`.

Build the example with:

```sh
make build
```
