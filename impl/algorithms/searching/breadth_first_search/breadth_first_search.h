#pragma once

#include "tree.h"

namespace searching {

// Returns the node whose item equals target, or nullptr when it is not
// present. Visits nodes level by level with an explicit queue, so the
// shallowest match wins.
const data_structures::TreeNode* iterative_breadth_first_search(
    const data_structures::TreeNode& root,
    const data_structures::TreeItem& target);

// Returns the node whose item equals target, or nullptr when it is not
// present. Recurses over the queue of nodes still to visit.
const data_structures::TreeNode* recursive_breadth_first_search(
    const data_structures::TreeNode& root,
    const data_structures::TreeItem& target);

}  // namespace searching
