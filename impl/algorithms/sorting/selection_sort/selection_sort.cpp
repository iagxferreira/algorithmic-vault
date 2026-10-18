#include "selection_sort.h"
#include <cstddef>
#include <utility>

namespace sorting {

void selection_sort(std::vector<int>& values) {
    for (std::size_t low = 0; low + 1 < values.size(); ++low) {
        std::size_t min_index = low;
        for (std::size_t high = low + 1; high < values.size(); ++high) {
            if (values[high] < values[min_index]) {
                min_index = high;
            }
        }
        std::swap(values[low], values[min_index]);
    }
}

} // namespace sorting
