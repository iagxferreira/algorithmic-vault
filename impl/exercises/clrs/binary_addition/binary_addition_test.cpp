#include "binary_addition.h"

#include <cassert>
#include <iostream>
#include <string_view>
#include <vector>

namespace {

void check_addition(std::string_view test_name,
                    const std::vector<int>& left,
                    const std::vector<int>& right,
                    const std::vector<int>& expected) {
    const auto sum = exercises::clrs::add_binary(left, right);
    assert(sum == expected);
    std::cout << test_name << " passed!" << std::endl;
}

}  // namespace

int main() {
    check_addition("mixed bits", {1, 0, 1, 1}, {0, 1, 1, 0}, {1, 0, 0, 0, 1});
    check_addition("all zeros", {0, 0, 0}, {0, 0, 0}, {0, 0, 0, 0});
    check_addition("final carry", {1, 1, 1, 1}, {0, 0, 0, 1}, {1, 0, 0, 0, 0});
    check_addition("single carry", {0, 0, 1}, {0, 0, 1}, {0, 0, 1, 0});
}
