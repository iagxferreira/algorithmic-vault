#include "minimum_search.h"
#include <cstddef>

namespace searching {

int minimum_search(const std::vector<int> &values) {
  if (values.empty())
    return -1;

  int min = values[0];
  int min_index = 0;
  for (std::size_t i = 0; i < values.size(); i++) {
    if (values[i] < min) {
      min = values[i];
      min_index = i;
    }
  }
  return min_index;
}

} // namespace searching
