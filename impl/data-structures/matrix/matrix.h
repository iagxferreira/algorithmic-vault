#ifndef MATRIX_H
#define MATRIX_H
#include <vector>

template <typename Object> class matrix {
public:
  matrix(int rows, int cols) : array(rows) {
    for (auto &row : array)
      row.resize(cols);
  }

  matrix(std::vector<std::vector<Object>> &value) : array{value} {};
  matrix(std::vector<std::vector<Object>> &&value) : array{std::move(value)} {};

  const std::vector<Object> &operator[](int row) const { return array[row]; }
  std::vector<Object> &operator[](int row) { return array[row]; }

  int numRows() const { return array.size(); }
  int numCols() const { return numRows() ? array[0].size() : 0; }

private:
  std::vector<std::vector<Object>> array;
};
#endif // !MATRIX_H
