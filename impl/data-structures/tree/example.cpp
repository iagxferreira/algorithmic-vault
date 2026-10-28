#include "tree.h"

#include <iostream>
#include <string>

namespace {

void print_tree(const data_structures::TreeNode &node, int depth) {
  for (int i = 0; i < depth; ++i)
    std::cout << "  ";
  if (node.item.has_value())
    std::cout << *node.item << '\n';
  else
    std::cout << "(no item)\n";

  for (const auto &child : node.children)
    print_tree(*child, depth + 1);
}

void print_order(const std::string &name,
                 const std::vector<data_structures::TreeItem> &items) {
  std::cout << name << ": ";
  for (const auto &item : items)
    std::cout << item << ' ';
  std::cout << '\n';
}

}  // namespace

int main() {
  data_structures::TreeNode root;
  data_structures::TreeNode *one = data_structures::add_child(root, "first");
  data_structures::TreeNode *two = data_structures::add_child(root, "second");
  data_structures::add_child(*one, "deeper");
  data_structures::add_child(*one, "again");
  data_structures::add_child(*two, "also deeper");

  print_tree(root, 0);

  print_order("pre-order  ", data_structures::pre_order(root));
  print_order("in-order   ", data_structures::in_order(root));
  print_order("post-order ", data_structures::post_order(root));
  print_order("level-order", data_structures::level_order(root));

  const data_structures::TreeNode *deepest = data_structures::deepest_node(root);
  if (deepest->item.has_value())
    std::cout << "The deepest node holds: " << *deepest->item << '\n';

  std::cout << "The tree holds " << data_structures::size(root) << " nodes.\n";
}
