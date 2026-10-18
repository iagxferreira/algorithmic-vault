#include "linear_search.h"

#include <cassert>
#include <iostream>
#include <string_view>
#include <vector>

namespace {

void check_search(std::string_view test_name,
                  const std::vector<int>& values,
                  int target,
                  int expected_index) {
    const int index = searching::linear_search(values, target);
    assert(index == expected_index);
    std::cout << test_name << " passed!" << std::endl;
}

}  // namespace

int main() {
    check_search("empty input", {}, 7, -1);
    check_search("first element", {7, 2, 4}, 7, 0);
    check_search("middle element", {7, 2, 4}, 2, 1);
    check_search("last element", {7, 2, 4}, 4, 2);
    check_search("missing value", {7, 2, 4}, 9, -1);
}
