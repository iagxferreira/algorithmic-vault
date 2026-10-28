#include "tree.h"

#include <utility>

namespace data_structures {

TreeNode *add_child(TreeNode &parent, std::optional<TreeItem> item) {
  auto child = std::make_unique<TreeNode>();
  child->item = std::move(item);
  parent.children.push_back(std::move(child));
  return parent.children.back().get();
}

std::size_t size(const TreeNode &root) {
  std::size_t count = 1;
  for (const auto &child : root.children)
    count += size(*child);
  return count;
}

}  // namespace data_structures
