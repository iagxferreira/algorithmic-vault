#include "quick_sort.h"

namespace sorting {

std::vector<int> quick_sort(const std::vector<int>& values) {
    if (values.empty()) {
        return {};
    }
    if (values.size() == 1) {
        return {values.front()};
    }

    const int pivot = values[values.size() / 2];
    std::vector<int> lesser;
    std::vector<int> equal;
    std::vector<int> greater;

    for (const int value : values) {
        if (value < pivot) {
            lesser.push_back(value);
        } else if (value > pivot) {
            greater.push_back(value);
        } else {
            equal.push_back(value);
        }
    }

    std::vector<int> sorted = quick_sort(lesser);
    sorted.insert(sorted.end(), equal.begin(), equal.end());

    const std::vector<int> sorted_greater = quick_sort(greater);
    sorted.insert(sorted.end(), sorted_greater.begin(), sorted_greater.end());
    return sorted;
}

} // namespace sorting
