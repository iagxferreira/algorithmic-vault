#include "breadth_first_search.h"

#include <iostream>
#include <string>

int main() {
    const searching::Box main_box{
        std::nullopt,
        {
            {std::nullopt, {}},
            {std::string{"golden key"}, {}},
        },
    };

    const searching::Box* found =
        searching::iterative_breadth_first_search(main_box, "golden key");
    if (found != nullptr) {
        std::cout << "Found the key in its box!\n";
    } else {
        std::cout << "Key not found.\n";
    }
}
