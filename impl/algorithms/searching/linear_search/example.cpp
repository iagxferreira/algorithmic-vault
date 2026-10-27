#include "linear_search.h"

#include <iostream>
#include <vector>

int main() {
    const std::vector<int> values{5, 2, 4, 6, 1, 3, 4};
    const int target = 4;
    const int first_index = searching::linear_search(values, target);
    const int last_index = searching::linear_search_from_end(values, target);

    if (first_index == -1) {
        std::cout << target << " was not found.\n";
    } else {
        std::cout << target << " first found at index " << first_index << ".\n";
        std::cout << target << " last found at index " << last_index << ".\n";
    }
}
