#include "tree.h"

#include <cassert>
#include <iostream>
#include <memory>
#include <optional>
#include <string>
#include <string_view>
#include <vector>

namespace {

using data_structures::add_child;
using data_structures::deepest_node;
using data_structures::in_order;
using data_structures::level_order;
using data_structures::post_order;
using data_structures::pre_order;
using data_structures::size;
using data_structures::TreeNode;
using data_structures::TreeItem;

//      R
//      ├─ L
//      ├─ M
//      │   └─ M1
//      └─ N
std::unique_ptr<TreeNode> sample_tree() {
  auto root = std::make_unique<TreeNode>();
  root->item = "R";
  add_child(*root, "L");
  TreeNode *middle = add_child(*root, "M");
  add_child(*middle, "M1");
  add_child(*root, "N");
  return root;
}

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

  {
    auto tree = sample_tree();
    check("pre_order visits nodes before their children",
          pre_order(*tree) == std::vector<TreeItem>{"R", "L", "M", "M1", "N"});
    check("in_order visits the first child, then the node, then the rest",
          in_order(*tree) == std::vector<TreeItem>{"L", "R", "M1", "M", "N"});
    check("post_order visits children before their parent",
          post_order(*tree) == std::vector<TreeItem>{"L", "M1", "M", "N", "R"});
    check("level_order visits the tree one depth at a time",
          level_order(*tree) == std::vector<TreeItem>{"R", "L", "M", "N", "M1"});
  }

  {
    TreeNode root;
    add_child(root, "shown");
    check("traversals collect present items only",
          pre_order(root) == std::vector<TreeItem>{"shown"});
  }

  {
    TreeNode solo;
    solo.item = "solo";
    check("deepest_node of a lone root is the root itself", deepest_node(solo) == &solo);
  }

  {
    auto tree = sample_tree();
    check("deepest_node returns the deepest node",
          deepest_node(*tree) == tree->children.at(1)->children.front().get());
  }

  {
    // Two nodes reach depth two; level order touches the left one first.
    TreeNode root;
    TreeNode *left = add_child(root, "left");
    TreeNode *right = add_child(root, "right");
    add_child(*left, "bottom left");
    add_child(*right, "bottom right");
    check("deepest_node breaks ties with the first in level order",
          deepest_node(root) == left->children.front().get());
  }
}
