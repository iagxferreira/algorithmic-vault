#include "tree.h"

#include <cstddef>
#include <deque>
#include <utility>

namespace data_structures {

namespace {

void pre_order_visit(const TreeNode &node, std::vector<TreeItem> &out) {
  if (node.item.has_value())
    out.push_back(*node.item);

  for (const auto &child : node.children)
    pre_order_visit(*child, out);
}

// Generalized in-order: first child's subtree, the node, then the rest.
void in_order_visit(const TreeNode &node, std::vector<TreeItem> &out) {
  if (!node.children.empty())
    in_order_visit(*node.children.front(), out);

  if (node.item.has_value())
    out.push_back(*node.item);

  for (std::size_t i = 1; i < node.children.size(); ++i)
    in_order_visit(*node.children[i], out);
}

void post_order_visit(const TreeNode &node, std::vector<TreeItem> &out) {
  for (const auto &child : node.children)
    post_order_visit(*child, out);

  if (node.item.has_value())
    out.push_back(*node.item);
}

}  // namespace

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

std::vector<TreeItem> pre_order(const TreeNode &root) {
  std::vector<TreeItem> items;
  pre_order_visit(root, items);
  return items;
}

std::vector<TreeItem> in_order(const TreeNode &root) {
  std::vector<TreeItem> items;
  in_order_visit(root, items);
  return items;
}

std::vector<TreeItem> post_order(const TreeNode &root) {
  std::vector<TreeItem> items;
  post_order_visit(root, items);
  return items;
}

std::vector<TreeItem> level_order(const TreeNode &root) {
  std::vector<TreeItem> items;
  std::deque<const TreeNode *> queue;
  queue.push_back(&root);

  while (!queue.empty()) {
    const TreeNode *current = queue.front();
    queue.pop_front();

    if (current->item.has_value())
      items.push_back(*current->item);

    for (const auto &child : current->children)
      queue.push_back(child.get());
  }

  return items;
}

const TreeNode *deepest_node(const TreeNode &root) {
  std::deque<std::pair<const TreeNode *, std::size_t>> queue;
  queue.emplace_back(&root, 0);

  const TreeNode *deepest = &root;
  std::size_t deepest_depth = 0;

  while (!queue.empty()) {
    const auto [current, depth] = queue.front();
    queue.pop_front();

    if (depth > deepest_depth) {
      deepest = current;
      deepest_depth = depth;
    }

    for (const auto &child : current->children)
      queue.emplace_back(child.get(), depth + 1);
  }

  return deepest;
}

}  // namespace data_structures
