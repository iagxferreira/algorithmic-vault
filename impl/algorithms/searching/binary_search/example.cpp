#include "binary_search.h"

#include <iostream>
#include <vector>

int main() {
    const std::vector<int> values{1, 3, 4, 6, 8, 9};
    const int target = 6;
    const int index = searching::binary_search(values, target);

    if (index == -1) {
        std::cout << target << " was not found.\n";
    } else {
        std::cout << target << " found at index " << index << ".\n";
    }
}
