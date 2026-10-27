#include "factorial.h"

namespace recursion {

std::uint64_t factorial_recursive(unsigned int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial_recursive(n - 1);
}

std::uint64_t factorial_iterative(unsigned int n) {
    std::uint64_t product = 1;
    for (unsigned int factor = 2; factor <= n; ++factor) {
        product *= factor;
    }
    return product;
}

std::uint64_t factorial_memoized(
    unsigned int n,
    std::unordered_map<unsigned int, std::uint64_t>& memo) {
    if (n <= 1) {
        memo[n] = 1;
        return 1;
    }

    const auto cached = memo.find(n);
    if (cached != memo.end()) {
        return cached->second;
    }

    memo[n] = n * factorial_memoized(n - 1, memo);
    return memo[n];
}

} // namespace recursion
