#include "breadth_first_search.h"

#include <deque>
#include <utility>

namespace searching {

const data_structures::TreeNode *iterative_breadth_first_search(
    const data_structures::TreeNode &root,
    const data_structures::TreeItem &target) {
  std::deque<const data_structures::TreeNode *> nodes_to_visit;
  nodes_to_visit.push_back(&root);

  while (!nodes_to_visit.empty()) {
    const data_structures::TreeNode *current = nodes_to_visit.front();
    nodes_to_visit.pop_front();

    if (current->item == target) {
      return current;
    }

    for (const auto &child : current->children) {
      nodes_to_visit.push_back(child.get());
    }
  }

  return nullptr;
}

namespace {

const data_structures::TreeNode *search_frontier(
    std::deque<const data_structures::TreeNode *> frontier,
    const data_structures::TreeItem &target) {
  if (frontier.empty())
    return nullptr;

  const data_structures::TreeNode *current = frontier.front();
  frontier.pop_front();

  if (current->item == target)
    return current;

  for (const auto &child : current->children) {
    frontier.push_back(child.get());
  }

  return search_frontier(std::move(frontier), target);
}

}  // namespace

const data_structures::TreeNode *recursive_breadth_first_search(
    const data_structures::TreeNode &root,
    const data_structures::TreeItem &target) {
  std::deque<const data_structures::TreeNode *> frontier;
  frontier.push_back(&root);

  return search_frontier(std::move(frontier), target);
}

}  // namespace searching
