#include "insertion_sort.h"

#include <cstddef>

namespace sorting {

void insertion_sort(std::vector<int> &values) {
  for (std::size_t low = 0; low < values.size(); low++) {
    const int key = values[low];
    std::size_t i = low;

    while (i > 0 && values[i - 1] > key) {
      values[i] = values[i - 1];
      --i;
    }
    values[i] = key;
  }
}

} // namespace sorting
