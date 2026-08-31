# Binary search trees

`dsa.structures.BinarySearchTree`

Traversals live in
[`docs/algorithms/tree-traversal.md`](../algorithms/tree-traversal.md).

## Why build it

A BST keeps data sorted while supporting insert, search and delete in
O(h). It is also the structure that most clearly shows why *balance*
matters — an unbalanced BST is a linked list wearing a hat.

## Understand before you write code

1. **The invariant.** Everything in the left subtree is smaller than the
   node; everything in the right is larger. Not just the immediate
   children — the *whole* subtree. Getting this wrong is the classic
   validation bug.
2. **Why in-order traversal comes out sorted.** It follows directly from the
   invariant. This is the single most useful consequence of a BST.
3. **Why every operation is O(h), not O(log n).** Height equals log n only
   when balanced. Insert 1, 2, 3, 4, 5 in order and you get a chain of
   height 4 — every operation is O(n). That is what AVL and red-black trees
   exist to prevent, and why `TreeMap` uses one.
4. **Deletion has three cases, and only the third is interesting.** A leaf:
   detach it. One child: splice the child in. **Two children**: replace the
   node's value with its in-order successor (the smallest value in the right
   subtree), then delete that successor — which by construction has at most
   one child, so you recurse into an easier case.
5. **Height is edges, not nodes.** Empty is −1 here, a single node is 0. Pick
   a convention and hold it.

## Implement

- [ ] `insert` — ignoring duplicates
- [ ] `contains`, `min`, `max`
- [ ] `inOrder` — verify it comes out sorted
- [ ] `height`
- [ ] `delete` — leaf, one child, then two children

## Traps

- **Deleting the root** with two children. Tested separately, because the
  "reattach to the parent" step has no parent here.
- **Deleting an absent value** must leave the tree and `size` untouched.
- **`min`/`max` on an empty tree** must throw, not return 0.
- **`size` on a rejected duplicate insert** must not increase.
- **Recursive delete needs to return the new subtree root** and have the
  caller reassign it. Trying to mutate the parent's pointer directly is
  where this gets tangled.

## Test it

```shell
./gradlew test --tests '*BinarySearchTreeTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):
`leetcode/0701-insert-into-a-binary-search-tree`,
`0450-delete-node-in-a-bst`, `0098-validate-binary-search-tree`,
`0230-kth-smallest-element-in-a-bst`, `1382-balance-a-binary-search-tree`.
