#include "list_recursion.h"

namespace recursion {
namespace {

std::int64_t sum_from(const std::vector<int> &values, std::size_t index) {
  if (index == values.size()) {
    return 0;
  }
  return values[index] + sum_from(values, index + 1);
}

std::size_t count_from(const std::vector<int> &values, std::size_t index) {
  if (index == values.size()) {
    return 0;
  }
  return 1 + count_from(values, index + 1);
}

int maximum_from(const std::vector<int> &values, std::size_t index) {
  if (index + 1 == values.size()) {
    return values[index];
  }
  const int maximum_of_rest = maximum_from(values, index + 1);
  return values[index] > maximum_of_rest ? values[index] : maximum_of_rest;
}

} // namespace

std::int64_t recursive_sum(const std::vector<int> &values) {
  return sum_from(values, 0);
}

std::size_t recursive_count(const std::vector<int> &values) {
  return count_from(values, 0);
}

std::optional<int> recursive_maximum(const std::vector<int> &values) {
  if (values.empty()) {
    return std::nullopt;
  }
  return maximum_from(values, 0);
}

} // namespace recursion
