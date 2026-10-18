#pragma once

#include <ostream>
#include <string_view>
#include <vector>

namespace utils {

inline void print_vector(std::ostream& output,
                         std::string_view label,
                         const std::vector<int>& values) {
    output << label;
    for (int value : values) {
        output << value << ' ';
    }
    output << '\n';
}

}  // namespace utils
