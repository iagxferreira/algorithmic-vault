#include "depth_first_search.h"

#include <cassert>
#include <iostream>
#include <string_view>

namespace {

void check_search(std::string_view test_name,
                  const searching::Box& main_box,
                  const searching::BoxItem& target,
                  bool expected) {
    const searching::Box* result =
        searching::iterative_depth_first_search(main_box, target);
    assert((result != nullptr) == expected);
    if (result != nullptr) {
        assert(result->key == target);
    }
    std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
    check_search("empty main box", {}, "key", false);
    check_search("key in main box", {"key", {}}, "key", true);
    check_search("key in nested box", {std::nullopt, {{"key", {}}}}, "key", true);
    check_search("key several levels deep",
                 {std::nullopt, {{std::nullopt, {{"key", {}}}}}}, "key", true);
    check_search("key is missing",
                 {std::nullopt, {{std::nullopt, {}}, {std::nullopt, {}}}},
                 "key",
                 false);
    check_search("different key", {"other", {}}, "key", false);
}
