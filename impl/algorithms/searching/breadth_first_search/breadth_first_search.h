#pragma once

#include <optional>
#include <string>
#include <vector>

namespace searching {

using BoxItem = std::string;

// A node in the box tree. Nested boxes are this node's children.
struct Box {
    std::optional<BoxItem> key;
    std::vector<Box> nested_boxes;
};

// Returns the box containing target, or nullptr when target is not present.
// Searches level by level, so the shallowest match wins.
const Box* iterative_breadth_first_search(const Box& main_box,
                                          const BoxItem& target);

// Returns the box containing target, or nullptr when target is not present.
// Recurses over the queue of boxes still to visit.
const Box* recursive_breadth_first_search(const Box& main_box,
                                          const BoxItem& target);

}  // namespace searching
