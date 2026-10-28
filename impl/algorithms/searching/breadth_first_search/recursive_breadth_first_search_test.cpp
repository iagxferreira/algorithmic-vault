#include "breadth_first_search.h"

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
        searching::recursive_breadth_first_search(root, target);
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

    {
        // Two nodes hold the key: the shallow one directly under the root,
        // and a deep one two levels further down. Breadth-first search must
        // return the shallow one, still holding a child; the deep match adds
        // no children.
        data_structures::TreeNode root;
        data_structures::TreeNode* shallow_match = add_child(root, "key");
        add_child(*shallow_match, std::nullopt);
        add_child(root, std::nullopt);
        data_structures::TreeNode* second = add_child(root, std::nullopt);
        data_structures::TreeNode* third = add_child(*second, std::nullopt);
        add_child(*third, "key");

        const data_structures::TreeNode* result =
            searching::recursive_breadth_first_search(root, "key");
        assert(result != nullptr);
        assert(!result->children.empty());
        std::cout << "item in the shallowest node passed!\n";
    }
}
