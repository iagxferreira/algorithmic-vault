# Binary Trees In Rust

Notes and goals for binary tree study in this Rust DSA library.

The current implementation lives in:

- `src/dsa/binary_tree.rs`

## Core Concepts

- A tree node owns its children with `Option<Box<TreeNode>>`.
- Recursive traversal works naturally with borrowed nodes.
- Breadth-first traversal usually uses `VecDeque`.
- Many LeetCode tree problems become simpler when helper functions borrow
  `Option<Box<TreeNode>>` instead of taking ownership.

## Implemented Goals

- `TreeNode`
- Maximum depth
- Level-order traversal

## Next Goals

1. Invert binary tree.
2. Same tree.
3. Validate binary search tree.
4. Lowest common ancestor in a BST.
5. Diameter of binary tree.
6. Balanced binary tree.
7. Path sum.
8. Build tree from preorder and inorder traversal.

## Testing Approach

Prefer small hand-built trees in unit tests. Add helpers only when repeated tree
construction starts making tests harder to read.
