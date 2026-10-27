#include "list_recursion.h"

#include <cassert>
#include <iostream>
#include <vector>

int main() {
    assert(recursion::recursive_sum({}) == 0);
    assert(recursion::recursive_sum({7}) == 7);
    assert(recursion::recursive_sum({2, 4, 6}) == 12);

    assert(recursion::recursive_count({}) == 0);
    assert(recursion::recursive_count({7}) == 1);
    assert(recursion::recursive_count({2, 4, 6}) == 3);

    assert(!recursion::recursive_maximum({}).has_value());
    assert(recursion::recursive_maximum({7}) == 7);
    assert(recursion::recursive_maximum({2, 9, 6, 9, -1}) == 9);
    assert(recursion::recursive_maximum({-8, -3, -5}) == -3);

    std::cout << "Recursive list operation tests passed!\n";
}
