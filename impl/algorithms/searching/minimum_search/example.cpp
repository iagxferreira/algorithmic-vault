#include "minimum_search.h"

#include <iostream>
#include <vector>

int main() {
    const std::vector<int> values{5, 2, 4, 1, 3};
    const int index = searching::minimum_search(values);

    if (index == -1) {
        std::cout << "The input is empty.\n";
    } else {
        std::cout << "Minimum value: " << values[index]
                  << " at index " << index << ".\n";
    }
}
