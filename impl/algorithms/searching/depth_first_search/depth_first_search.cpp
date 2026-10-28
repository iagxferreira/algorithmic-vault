#include "depth_first_search.h"

#include <stack>

namespace searching {

const data_structures::TreeNode *iterative_depth_first_search(
    const data_structures::TreeNode &root,
    const data_structures::TreeItem &target) {
  std::stack<const data_structures::TreeNode *> nodes_to_visit;
  nodes_to_visit.push(&root);

  while (!nodes_to_visit.empty()) {
    const data_structures::TreeNode *current = nodes_to_visit.top();
    nodes_to_visit.pop();

    if (current->item == target) {
      return current;
    }

    for (const auto &child : current->children) {
      nodes_to_visit.push(child.get());
    }
  }

  return nullptr;
}

const data_structures::TreeNode *recursive_depth_first_search(
    const data_structures::TreeNode &root,
    const data_structures::TreeItem &target) {
  if (root.item == target)
    return &root;

  for (const auto &child : root.children) {
    const data_structures::TreeNode *found =
        recursive_depth_first_search(*child, target);
    if (found != nullptr)
      return found;
  }

  return nullptr;
}

}  // namespace searching
