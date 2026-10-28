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

}  // namespace data_structures
