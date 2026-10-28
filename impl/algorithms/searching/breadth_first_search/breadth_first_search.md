# Breadth-First Search

This module compares two breadth-first search strategies on a tree of boxes.
Each box can hold a key and contain nested boxes. Both searches return a
pointer to the box containing the target, or `nullptr` if it is absent.
Because the search runs level by level, the returned box is the shallowest
one holding the target.

- `iterative_breadth_first_search` is implemented with an explicit queue.
- `recursive_breadth_first_search` recurses over the queue of boxes still to
  visit.

Run the iterative tests with `make test` and the recursive tests with
`make recursive-test`.

Build the example with:

```sh
make build
```
