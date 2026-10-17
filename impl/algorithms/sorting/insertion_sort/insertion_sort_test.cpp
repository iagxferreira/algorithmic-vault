#include "insertion_sort.h"

#include <cassert>
#include <vector>

namespace {

void check_sort(const std::vector<int>& input,
                const std::vector<int>& expected) {
    std::vector<int> values = input;
    sorting::insertion_sort(values);
    assert(values == expected);
}

}  // namespace

int main() {
    check_sort({}, {});
    check_sort({7}, {7});
    check_sort({1, 2, 3, 4}, {1, 2, 3, 4});
    check_sort({4, 3, 2, 1}, {1, 2, 3, 4});
    check_sort({3, 1, 2, 1}, {1, 1, 2, 3});
    check_sort({0, -3, 8, -1}, {-3, -1, 0, 8});
}
