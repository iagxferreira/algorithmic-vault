#include "binary_addition.h"
#include "../../../utils/print_vector.h"

#include <iostream>
#include <vector>

int main() {
    const std::vector<int> left{1, 0, 1, 1};
    const std::vector<int> right{0, 1, 1, 0};

    utils::print_vector(std::cout, "Left:  ", left);
    utils::print_vector(std::cout, "Right: ", right);
    utils::print_vector(std::cout, "Sum:   ",
                        exercises::clrs::add_binary(left, right));
}
