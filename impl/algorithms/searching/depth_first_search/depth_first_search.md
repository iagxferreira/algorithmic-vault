# Depth-First Search

This module compares two depth-first search strategies on a tree built with
the `data_structures::TreeNode` type from `data-structures/tree/`: each node
holds an optional item plus the children it owns. Both searches return a
pointer to the node holding the target, or `nullptr` if it is absent.

- `iterative_depth_first_search` is implemented with an explicit stack.
- `recursive_depth_first_search` searches by recursively visiting each child.

Run the iterative tests with `make test` and the recursive tests with
`make recursive-test`.

Build the example with:

```sh
make build
```
