#include "factorial.h"

#include <iostream>

int main() {
    constexpr unsigned int n = 5;
    std::unordered_map<unsigned int, std::uint64_t> memo;

    std::cout << "Recursive: " << recursion::factorial_recursive(n) << '\n';
    std::cout << "Iterative: " << recursion::factorial_iterative(n) << '\n';
    std::cout << "Memoized:  "
              << recursion::factorial_memoized(n, memo) << '\n';
}
