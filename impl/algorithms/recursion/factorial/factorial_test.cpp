#include "factorial.h"

#include <cassert>
#include <cstdint>
#include <iostream>
#include <string_view>
#include <unordered_map>

namespace {

using FactorialFunction = std::uint64_t (*)(unsigned int);

void check_factorial(std::string_view test_name,
                     FactorialFunction factorial,
                     unsigned int n,
                     std::uint64_t expected) {
    assert(factorial(n) == expected);
    std::cout << test_name << " passed!\n";
}

void check_memoized(std::string_view test_name,
                    unsigned int n,
                    std::uint64_t expected,
                    std::unordered_map<unsigned int, std::uint64_t>& memo) {
    assert(recursion::factorial_memoized(n, memo) == expected);
    std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
    const FactorialFunction implementations[]{
        recursion::factorial_recursive,
        recursion::factorial_iterative,
    };

    for (const auto factorial : implementations) {
        check_factorial("zero factorial", factorial, 0, 1);
        check_factorial("one factorial", factorial, 1, 1);
        check_factorial("small factorial", factorial, 5, 120);
        check_factorial("largest uint64 factorial", factorial, 20,
                        2432902008176640000ULL);
    }

    std::unordered_map<unsigned int, std::uint64_t> memo;
    check_memoized("memoized zero factorial", 0, 1, memo);
    check_memoized("memoized small factorial", 5, 120, memo);
    check_memoized("memoized result reuse", 3, 6, memo);
    check_memoized("largest memoized factorial", 20,
                   2432902008176640000ULL, memo);
}
