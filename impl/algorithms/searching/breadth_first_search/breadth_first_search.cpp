#include "breadth_first_search.h"

#include <deque>
#include <utility>

namespace searching {

const Box *iterative_breadth_first_search(const Box &main_box,
                                          const BoxItem &target) {
  std::deque<const Box *> boxes_to_visit;
  boxes_to_visit.push_back(&main_box);

  while (!boxes_to_visit.empty()) {
    const Box *current = boxes_to_visit.front();
    boxes_to_visit.pop_front();

    if (current->key == target) {
      return current;
    }

    for (const Box &nested_box : current->nested_boxes) {
      boxes_to_visit.push_back(&nested_box);
    }
  }

  return nullptr;
}

namespace {

const Box *search_frontier(std::deque<const Box *> frontier,
                           const BoxItem &target) {
  if (frontier.empty())
    return nullptr;

  const Box *current = frontier.front();
  frontier.pop_front();

  if (current->key == target)
    return current;

  for (const Box &nested_box : current->nested_boxes) {
    frontier.push_back(&nested_box);
  }

  return search_frontier(std::move(frontier), target);
}

}  // namespace

const Box *recursive_breadth_first_search(const Box &main_box,
                                          const BoxItem &target) {
  std::deque<const Box *> frontier;
  frontier.push_back(&main_box);

  return search_frontier(std::move(frontier), target);
}

}  // namespace searching
