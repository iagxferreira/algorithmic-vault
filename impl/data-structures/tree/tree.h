#pragma once

#include <cstddef>
#include <memory>
#include <optional>
#include <string>
#include <vector>

namespace data_structures {

using TreeItem = std::string;

// A node of a rooted tree: an optional item and the children this node owns.
struct TreeNode {
    std::optional<TreeItem> item;
    std::vector<std::unique_ptr<TreeNode>> children;
};

// Appends a child holding item to parent and returns a pointer to it. The
// child stays alive as long as its parent does; pointers into the tree stay
// valid when other children are added later.
TreeNode* add_child(TreeNode& parent, std::optional<TreeItem> item);

// Counts the nodes in the tree rooted at root, including root itself.
std::size_t size(const TreeNode& root);

// Traversals collect the items the walk touches, in visit order. Nodes
// without an item are visited but contribute nothing.
//
// pre-order: the node, then each child.
// in-order: the first child's subtree, then the node, then the remaining
// children. On a two-child (binary) tree this is the classic
// left-root-right order; on wider trees this is the generalization used
// here.
// post-order: every child, then the node.
std::vector<TreeItem> pre_order(const TreeNode& root);
std::vector<TreeItem> in_order(const TreeNode& root);
std::vector<TreeItem> post_order(const TreeNode& root);

// Level-order walks the tree one depth at a time, breadth-first.
std::vector<TreeItem> level_order(const TreeNode& root);

// Returns the node at the greatest depth from root. When several nodes tie
// for the deepest level, returns the first one reached in level order.
const TreeNode* deepest_node(const TreeNode& root);

}  // namespace data_structures
