# Singly linked list

A linked list implemented with the arena pattern: every node is stored in a
`Vec` and referenced by a `usize` handle instead of a pointer. This gives the
list pointer-like navigation without the shared-mutability fight that raw
`Rc<RefCell<T>>` nodes would bring, and it is cache-friendlier as a bonus.

Key properties:

- `push_front` and `pop_front` run in `O(1)`.
- `push_back` walks the whole chain, so it is `O(n)`; a tail handle would fix
  that only for this list, never for insertions in the middle.
- `reverse` rewires `next` handles in place with two moving handles:
  `O(n)` time, `O(1)` extra space.
- The arena never compacts: a popped node leaves a tombstone slot so the
  handles of the remaining nodes stay stable.

Run the example and the tests with:

```sh
cargo run
cargo test
```
