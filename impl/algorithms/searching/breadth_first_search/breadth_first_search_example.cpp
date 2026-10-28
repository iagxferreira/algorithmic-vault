#include "breadth_first_search.h"

#include <iostream>
#include <optional>
#include <string>

int main() {
    data_structures::TreeNode main_tree;
    data_structures::add_child(main_tree, std::nullopt);
    data_structures::add_child(main_tree, "golden key");

    const data_structures::TreeNode* found =
        searching::iterative_breadth_first_search(main_tree, "golden key");
    if (found != nullptr) {
        std::cout << "Found the key in its node!\n";
    } else {
        std::cout << "Key not found.\n";
    }
}
