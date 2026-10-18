#include "linear_search.h"

#include <iostream>
#include <vector>

int main() {
    const std::vector<int> values{5, 2, 4, 6, 1, 3};
    const int target = 4;
    const int index = searching::linear_search(values, target);

    if (index == -1) {
        std::cout << target << " was not found.\n";
    } else {
        std::cout << target << " found at index " << index << ".\n";
    }
}
