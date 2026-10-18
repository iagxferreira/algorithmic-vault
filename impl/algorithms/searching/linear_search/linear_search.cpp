#include "linear_search.h"
#include <cstddef>

namespace searching {

int linear_search(const std::vector<int> &values, int target) {
  for (std::size_t i = 0; i < values.size(); i++) {
    if (values[i] == target)
      return i;
  }
  return -1;
}

int linear_search_from_end(const std::vector<int> &values, int target) {
  for (std::size_t i = values.size(); i > 0; --i) {
    if (values[i - 1] == target)
      return static_cast<int>(i - 1);
  }
  return -1;
}

} // namespace searching
