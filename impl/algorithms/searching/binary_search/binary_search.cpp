#include "binary_search.h"

#include <cstddef>
#include <vector>

namespace searching {
int binary_search(const std::vector<int> &values, int target) {
  std::size_t low = 0;
  std::size_t high = values.size();
  while (low < high) {
    const std::size_t mid = low + (high - low) / 2;
    if (values[mid] == target)
      return static_cast<int>(mid);

    if (values[mid] < target) {
      low = mid + 1;
      continue;
    }

    high = mid;
  }
  return -1;
}
} // namespace searching
