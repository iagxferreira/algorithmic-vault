#include "binary_search.h"

#include <cassert>
#include <iostream>
#include <string_view>
#include <vector>

namespace {

void check_search(std::string_view test_name,
                  const std::vector<int>& values,
                  int target,
                  int expected_index) {
    assert(searching::binary_search(values, target) == expected_index);
    std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
    check_search("empty input", {}, 7, -1);
    check_search("single-element match", {7}, 7, 0);
    check_search("single-element miss", {7}, 9, -1);
    check_search("first element", {1, 3, 4, 6, 8}, 1, 0);
    check_search("middle element", {1, 3, 4, 6, 8}, 4, 2);
    check_search("last element", {1, 3, 4, 6, 8}, 8, 4);
    check_search("missing between elements", {1, 3, 4, 6, 8}, 5, -1);
    check_search("missing outside range", {1, 3, 4, 6, 8}, 9, -1);
    check_search("duplicate value", {1, 3, 3, 3, 8}, 3, 2);
}
