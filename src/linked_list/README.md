# Linked Lists In Rust

Notes and goals for linked list study.

The current implementation lives in:

- `src/dsa/linked_list.rs`

## Core Concepts

- A singly linked list can be represented with `Option<Box<ListNode>>`.
- `take()` is useful when rewiring links without cloning nodes.
- Many algorithms consume the list because ownership makes mutation simpler.
- Conversion helpers from and to `Vec<i32>` keep tests readable.

## Implemented Goals

- `ListNode`
- Build list from slice.
- Convert list to vector.
- Reverse list.

## Next Goals

1. Merge two sorted lists.
2. Remove nth node from end.
3. Detect cycle conceptually with fast and slow pointers.
4. Reorder list.
5. Add two numbers.
6. Merge k sorted lists.
