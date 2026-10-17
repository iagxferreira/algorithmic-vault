#include "insertion_sort.h"

#include <cstddef>

namespace sorting {

void insertion_sort(std::vector<int>& values) {
    for (std::size_t j = 1; j < values.size(); ++j) {
        const int key = values[j];
        std::size_t i = j;

        while (i > 0 && values[i - 1] > key) {
            values[i] = values[i - 1];
            --i;
        }
        values[i] = key;
    }
}

}  // namespace sorting
