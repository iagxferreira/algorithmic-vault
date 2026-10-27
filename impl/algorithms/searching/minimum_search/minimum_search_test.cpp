#include "minimum_search.h"

#include <cassert>
#include <iostream>
#include <string_view>
#include <vector>

namespace {

void check_minimum(std::string_view test_name,
                   const std::vector<int>& values,
                   int expected_index) {
    assert(searching::minimum_search(values) == expected_index);
    std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
    check_minimum("empty input", {}, -1);
    check_minimum("single element", {7}, 0);
    check_minimum("minimum at beginning", {1, 3, 4}, 0);
    check_minimum("minimum in middle", {5, 1, 4}, 1);
    check_minimum("minimum at end", {5, 3, 1}, 2);
    check_minimum("negative values", {-2, -5, 0}, 1);
    check_minimum("duplicate minimum returns first index", {1, 0, 0, 2}, 1);
}
