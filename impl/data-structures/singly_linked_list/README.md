# Singly linked list

The textbook representation, translated into Rust the only way the language
allows: every node is a separate heap allocation, and every node *owns* the
next one. `head: Option<Box<Node<T>>>` is an owning pointer to the first node
(or nothing, for the empty list), and the final node's `next` is `None` —
Rust's spelling of a NULL-terminated chain, since the language has no NULL.

Key properties:

- `push_front` and `pop_front` run in `O(1)`: the new node takes over
  ownership of the chain, or the second node is promoted to head.
- `push_back` has no tail pointer to lean on, so it walks the chain one node
  at a time through mutable borrows and runs in `O(n)`. A tail pointer would
  not help this design anyway: in Rust, the head owns the whole chain, and a
  reachable tail pointer inside the same owner makes the compiler reject the
  update of the last node.
- `reverse` re-splices ownership in place: `O(n)` time, no reallocations.
- Full ownership also means dropping a long list frees it node by node,
  recursively.

Run the example and the tests with:

```sh
cargo run
cargo test
```
