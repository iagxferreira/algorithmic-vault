#include "depth_first_search.h"

#include <stack>

namespace searching {

const Box* iterative_depth_first_search(const Box& main_box,
                                        const BoxItem& target) {
    std::stack<const Box*> boxes_to_visit;
    boxes_to_visit.push(&main_box);

    while (!boxes_to_visit.empty()) {
        const Box* current = boxes_to_visit.top();
        boxes_to_visit.pop();

        if (current->key == target) {
            return current;
        }

        for (const Box& nested_box : current->nested_boxes) {
            boxes_to_visit.push(&nested_box);
        }
    }

    return nullptr;
}

}  // namespace searching
