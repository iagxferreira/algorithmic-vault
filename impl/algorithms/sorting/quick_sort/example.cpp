#include "quick_sort.h"

#include <iostream>
#include <vector>

int main() {
    const std::vector<int> values{5, 2, 4, 6, 1, 3};
    const std::vector<int> sorted = sorting::quick_sort(values);

    std::cout << "Sorted values: ";
    for (const int value : sorted) {
        std::cout << value << ' ';
    }
    std::cout << '\n';
}
