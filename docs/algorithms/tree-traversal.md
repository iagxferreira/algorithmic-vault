# Tree traversal

`dsa.algorithms.tree` — 5 classes
Structure to build first: `dsa.structures.BinarySearchTree`

## Why this topic

Every tree problem is a traversal plus a decision about *when* to do the
work. The three depth-first orders differ in exactly one thing — where the
visit sits relative to the two recursive calls:

```
preorder(n):  visit(n); go(n.left); go(n.right)     // node first
inorder(n):   go(n.left); visit(n); go(n.right)     // node in the middle
postorder(n): go(n.left); go(n.right); visit(n)     // node last
```

That one line of difference decides what each is good for:

| Order | Use it for |
|---|---|
| pre | copying, serialising — you have the parent before the children |
| in | **sorted output on a BST** — validation, k-th smallest, closest pair |
| post | anything computed *from* the children — height, diameter, deletion |
| level (bfs) | anything that depends on **depth** — min depth, side views |

## Understand before you write code

1. **Why in-order on a BST is sorted.** The BST invariant is "everything
   left is smaller, everything right is larger". In-order visits all of
   left, then the node, then all of right — which is exactly ascending.
   You should be able to say this in one sentence.
2. **What the call stack is doing.** The recursive version has a stack; you
   just cannot see it. Writing the iterative version is how you learn what
   is on it. That matters because the default JVM stack overflows around
   depth 10⁴ — a 100 000-node degenerate tree will crash recursion.
3. **Why level order needs a queue and the others do not.** Depth-first
   goes deep, which is LIFO. Breadth-first expands in rings, which is FIFO.
4. **The "size snapshot" in level order.** Read `queue.size()` into a local
   before the inner loop. If you read it inside, the queue has already
   grown and your levels merge.
5. **Height is edges, depth is edges.** Decide once whether an empty tree is
   −1 or 0 and be consistent. Here: empty is −1, a single node is 0.
6. **The return-one-record-another pattern.** For diameter you need each
   node's height *and* the best path so far. Return the height; record the
   best in a field. Do not try to return both.

## Order to implement

- [ ] `PreOrder` — recursive, then the stack version
- [ ] `InOrder` — the same, then `isBinarySearchTree` on top of it
- [ ] `PostOrder` — recursive, then the reverse-of-node-right-left trick
- [ ] `LevelOrder` — bfs, then zigzag, right-side view and min depth
- [ ] `TreeMetrics` — height and counts, then `diameter` last

## Traps

- **Pre-order iterative: push right before left.** A stack reverses you.
- **In-order iterative** is the one people get wrong. The loop condition is
  `while (current != null || !stack.isEmpty())` — both halves matter.
- **Validating a BST against only the parent** accepts invalid trees. The
  in-order walk avoids the problem entirely, which is why it lives here.
- **`minDepth` and one-child nodes.** A node with a single child is *not* a
  leaf. `1 + min(left, right)` returns 1 for it, which is wrong. This is
  the classic bug and there is a test for it.
- **Recomputing height inside diameter** makes it O(n²). One pass only.
- **`Integer` vs `int` in level-order lists.** A `List<Integer>` holding a
  null (for a missing child) NPEs on unboxing. Filter before you collect.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.tree.*'
./gradlew test --tests '*InOrderTest'
```

`TreeNodes.of(1, 2, 3, null, 4)` builds a tree from its level-order form,
where `null` marks a missing child. `Trees` in the test sources holds the
three sample trees the tests share.

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0094-binary-tree-inorder-traversal` — do the iterative one
- `leetcode/0102-binary-tree-level-order-traversal` and `0199-binary-tree-right-side-view`
- `leetcode/0098-validate-binary-search-tree` — both ways
- `leetcode/0230-kth-smallest-element-in-a-bst` — stop the walk early
- `leetcode/0543-diameter-of-binary-tree` then `0124-binary-tree-maximum-path-sum`
- `leetcode/0111-minimum-depth-of-binary-tree` — the one-child trap
- `leetcode/0297-serialize-and-deserialize-binary-tree` — pre-order earning its keep
