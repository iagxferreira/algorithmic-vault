# Breadth-First Search

This module compares two breadth-first search strategies on a tree built with
the `data_structures::TreeNode` type from `data-structures/tree/`: each node
holds an optional item plus the children it owns. Both searches return a
pointer to the node holding the target, or `nullptr` if it is absent. Because
the search runs level by level, the returned node is the shallowest one
holding the target.

- `iterative_breadth_first_search` is implemented with an explicit queue.
- `recursive_breadth_first_search` recurses over the queue of nodes still to
  visit.

Run the iterative tests with `make test` and the recursive tests with
`make recursive-test`.

Build the example with:

```sh
make build
```
