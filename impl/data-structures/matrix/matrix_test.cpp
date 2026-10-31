#include "matrix.h"

#include <cassert>
#include <iostream>
#include <string_view>
#include <vector>

namespace {

void check(std::string_view test_name, bool ok) {
  assert(ok);
  std::cout << test_name << " passed!\n";
}

}  // namespace

int main() {
  {
    matrix<int> m(2, 3);
    check("constructed matrix has the requested dimensions",
          m.numRows() == 2 && m.numCols() == 3);
    m[1][2] = 7;
    check("operator[] exposes mutable rows", m[1][2] == 7);
  }

  {
    std::vector<std::vector<int>> values{{1, 2}, {3, 4}};
    matrix<int> m(values);
    check("matrix can be built from a vector of rows",
          m.numRows() == 2 && m.numCols() == 2 && m[1][0] == 3);
  }

  // TODO(Exercise 1.16): add tests for the zero-parameter constructor and
  // resize once those members exist.
}
