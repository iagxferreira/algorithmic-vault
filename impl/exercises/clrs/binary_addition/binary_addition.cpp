#include "binary_addition.h"
#include <cstddef>
#include <vector>

namespace exercises::clrs {

std::vector<int> add_binary(const std::vector<int>& left,
                            const std::vector<int>& right) {
    std::vector<int> result(left.size() + 1, 0);
    int carry = 0;

    for (std::size_t i = left.size(); i > 0; --i) {
        const int sum = left[i - 1] + right[i - 1] + carry;
        result[i] = sum % 2;
        carry = sum / 2;
    }

    result[0] = carry;
    return result;
}

} // namespace exercises::clrs
