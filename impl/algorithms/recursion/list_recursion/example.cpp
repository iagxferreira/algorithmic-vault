#include "list_recursion.h"

#include <iostream>
#include <vector>

int main() {
    const std::vector<int> values{2, 4, 6, 8};

    std::cout << "Sum: " << recursion::recursive_sum(values) << '\n';
    std::cout << "Count: " << recursion::recursive_count(values) << '\n';

    const auto maximum = recursion::recursive_maximum(values);
    if (maximum.has_value()) {
        std::cout << "Maximum: " << *maximum << '\n';
    } else {
        std::cout << "Maximum: no value (empty list)\n";
    }
}
