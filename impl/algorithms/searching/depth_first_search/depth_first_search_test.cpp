#include "depth_first_search.h"

#include <cassert>
#include <iostream>
#include <optional>
#include <string_view>

namespace {

using data_structures::TreeNode;
using data_structures::add_child;

void check_search(std::string_view test_name,
                  const data_structures::TreeNode& root,
                  const data_structures::TreeItem& target,
                  bool expected) {
    const data_structures::TreeNode* result =
        searching::iterative_depth_first_search(root, target);
    assert((result != nullptr) == expected);
    if (result != nullptr) {
        assert(result->item == target);
    }
    std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
    {
        data_structures::TreeNode root;
        check_search("empty root", root, "key", false);
    }
    {
        data_structures::TreeNode root;
        root.item = "key";
        check_search("item in root", root, "key", true);
    }
    {
        data_structures::TreeNode root;
        add_child(root, "key");
        check_search("item in child", root, "key", true);
    }
    {
        data_structures::TreeNode root;
        data_structures::TreeNode* child = add_child(root, std::nullopt);
        add_child(*child, "key");
        check_search("item several levels deep", root, "key", true);
    }
    {
        data_structures::TreeNode root;
        add_child(root, std::nullopt);
        add_child(root, std::nullopt);
        check_search("item is missing", root, "key", false);
    }
    {
        data_structures::TreeNode root;
        root.item = "other";
        check_search("different item", root, "key", false);
    }
}
