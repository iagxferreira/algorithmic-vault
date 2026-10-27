#include "selection_sort.h"
#include "../../../utils/print_vector.h"

#include <iostream>
#include <vector>

int main() {
    std::vector<int> values{5, 2, 4, 6, 1, 3};
    utils::print_vector(std::cout, "Before: ", values);

    sorting::selection_sort(values);

    utils::print_vector(std::cout, "After:  ", values);
}
