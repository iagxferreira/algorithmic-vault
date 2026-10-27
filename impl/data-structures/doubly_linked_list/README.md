# Doubly linked list

A doubly linked list with a sentinel node, the representation from CLRS
section 10.2: a permanent valueless node sits at the boundary, and the list is
wired circularly around it. The sentinel's `next` handle is the front of the
list, its `prev` handle is the back, and an empty list is just a sentinel
pointing at itself — which removes every empty-list branch from the insert
and remove routines.

Key properties:

- All four edge operations (`push_front`, `push_back`, `pop_front`,
  `pop_back`) run in `O(1)`, unlike the singly linked list where `push_back`
  must walk the chain.
- `reverse` swaps each node's `next` and `prev` handles in place:
  `O(n)` time, `O(1)` extra space.
- Like its sibling `singly_linked_list`, nodes live in an arena (`Vec` +
  `usize` handles) and popped nodes become tombstones rather than compacting
  the storage.

Run the example and the tests with:

```sh
cargo run
cargo test
```
