#pragma once

#include "tree.h"

namespace searching {

// Returns the node whose item equals target, or nullptr when it is not
// present. Visits nodes with an explicit stack (depth-first).
const data_structures::TreeNode* iterative_depth_first_search(
    const data_structures::TreeNode& root,
    const data_structures::TreeItem& target);

// Returns the node whose item equals target, or nullptr when it is not
// present. Recurses into each child.
const data_structures::TreeNode* recursive_depth_first_search(
    const data_structures::TreeNode& root,
    const data_structures::TreeItem& target);

}  // namespace searching
