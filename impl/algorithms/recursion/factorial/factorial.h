#pragma once

#include <cstdint>
#include <unordered_map>

namespace recursion {

// Precondition: n <= 20, so n! fits in std::uint64_t.
std::uint64_t factorial_recursive(unsigned int n);
std::uint64_t factorial_iterative(unsigned int n);
std::uint64_t factorial_memoized(
    unsigned int n,
    std::unordered_map<unsigned int, std::uint64_t>& memo);

}  // namespace recursion
