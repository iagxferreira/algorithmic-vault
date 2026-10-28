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

}  // namespace

int main() {
  data_structures::TreeNode root;
  data_structures::TreeNode *one = data_structures::add_child(root, "first");
  data_structures::TreeNode *two = data_structures::add_child(root, "second");
  data_structures::add_child(*one, "deeper");
  data_structures::add_child(*two, "also deeper");

  print_tree(root, 0);
  std::cout << "The tree holds " << data_structures::size(root) << " nodes.\n";
}
