#include "linear_search.h"
#include <cstddef>

namespace searching {

int linear_search(const std::vector<int> &values, int item) {
  if (values.size() == 0) {
    return -1;
  }

  for (std::size_t i = 0; i < values.size(); i++) {
    if (values[i] == item) {
      return i;
    }
  }
  return -1;
}

} // namespace searching
