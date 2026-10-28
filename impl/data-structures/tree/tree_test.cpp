#include "tree.h"

#include <cassert>
#include <iostream>
#include <optional>
#include <string>
#include <string_view>

namespace {

using data_structures::add_child;
using data_structures::size;
using data_structures::TreeNode;
using data_structures::TreeItem;

void check(std::string_view test_name, bool ok) {
  assert(ok);
  std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
  {
    TreeNode leaf;
    check("default node has no item and no children",
          !leaf.item.has_value() && leaf.children.empty());
    check("size of a leaf is one", size(leaf) == 1);
  }

  {
    TreeNode root;
    TreeNode *child = add_child(root, "golden key");
    check("add_child stores the item", child->item == TreeItem{"golden key"});
    check("add_child appends exactly one child", root.children.size() == 1);
    check("add_child returns the stored child", root.children.front().get() == child);
  }

  {
    TreeNode root;
    TreeNode *child = add_child(root, std::nullopt);
    TreeNode *grandchild = add_child(*child, "golden key");
    check("nested add_child keeps ownership",
          child->children.size() == 1 && child->children.front().get() == grandchild);
    check("grandchild is visible from the root",
          root.children.front()->children.front()->item == TreeItem{"golden key"});
    check("size counts all nodes", size(root) == 3);
  }

  {
    TreeNode root;
    TreeNode *child = add_child(root, "golden key");
    add_child(*child, std::nullopt);
    add_child(root, std::nullopt);
    check("adding a sibling keeps earlier pointers valid",
          size(root) == 4 && child->item == TreeItem{"golden key"});
  }
}
