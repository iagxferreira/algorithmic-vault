#include "quick_sort.h"

#include <cassert>
#include <iostream>
#include <string_view>
#include <vector>

namespace {

void check_sort(std::string_view test_name,
                const std::vector<int>& input,
                const std::vector<int>& expected) {
    assert(sorting::quick_sort(input) == expected);
    std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
    check_sort("empty input", {}, {});
    check_sort("single element", {7}, {7});
    check_sort("already sorted", {1, 2, 3, 4}, {1, 2, 3, 4});
    check_sort("reverse order", {4, 3, 2, 1}, {1, 2, 3, 4});
    check_sort("duplicate values", {3, 1, 2, 1}, {1, 1, 2, 3});
    check_sort("negative values", {0, -3, 8, -1}, {-3, -1, 0, 8});
    check_sort("all equal values", {4, 4, 4, 4}, {4, 4, 4, 4});
}
