#pragma once

#include <cstddef>
#include <cstdint>
#include <optional>
#include <vector>

namespace recursion {

std::int64_t recursive_sum(const std::vector<int>& values);
std::size_t recursive_count(const std::vector<int>& values);

// Returns std::nullopt for an empty list.
std::optional<int> recursive_maximum(const std::vector<int>& values);

}  // namespace recursion
