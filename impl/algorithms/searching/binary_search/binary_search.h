#pragma once

#include <vector>

namespace searching {

// Searches an ascending-sorted vector. Returns a matching zero-based index,
// or -1 when target is not present.
int binary_search(const std::vector<int>& values, int target);

}  // namespace searching
