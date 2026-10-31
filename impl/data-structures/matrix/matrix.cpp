#include "matrix.h"

void copy(const matrix<int> &from, matrix<int> &to) {
  for (int i = 0; i < to.numRows(); ++i) {
    to[i] = from[i];
  }
}
