#pragma once

#include <vector>

namespace exercises::clrs {

// Bits are stored most-significant first. The inputs must have equal length.
// The result contains n + 1 bits, also most-significant first.
std::vector<int> add_binary(const std::vector<int>& left,
                            const std::vector<int>& right);

}  // namespace exercises::clrs
