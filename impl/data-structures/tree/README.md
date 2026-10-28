# Tree

The `tree` module implements a rooted tree of optional items. Each
`data_structures::TreeNode` stores an `std::optional<std::string>` item and owns
its children through `std::vector<std::unique_ptr<TreeNode>>`, so a subtree
frees with its parent and pointers into the tree stay valid while other
branches grow.

The module offers two helpers over the nodes:

- `add_child(parent, item)` builds a child under `parent` and returns a pointer
  to it, which is how examples and tests assemble trees incrementally.
- `size(root)` counts every node reachable from `root`.

It also provides the classic walks, each returning the items they touch in
visit order:

- `pre_order`, `in_order`, `post_order` are depth-first walks. On a two-child
  tree `in_order` is the classic left-root-right order; on wider trees it
  visits the first child's subtree, the node, then the remaining children.
- `level_order` is the breadth-first walk, one depth at a time.
- `deepest_node(root)` returns the node of the deepest level, ties broken by
  the first node reached in level order.

Run the tests with `make test`.

Build and run the example, which prints a small tree depth-indented, with:

```sh
make test && make run
```

It is the shared node type behind the `depth_first_search` and
`breadth_first_search` algorithm crates.
