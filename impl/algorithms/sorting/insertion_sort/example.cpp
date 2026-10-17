#include "insertion_sort.h"

#include <iostream>
#include <vector>

int main() {
    std::vector<int> values{5, 2, 4, 6, 1, 3};

    std::cout << "Before: ";
    for (int value : values) {
        std::cout << value << ' ';
    }
    std::cout << '\n';

    sorting::insertion_sort(values);

    std::cout << "After:  ";
    for (int value : values) {
        std::cout << value << ' ';
    }
    std::cout << '\n';
}
