package dsa.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SearchMatrixTest {

    private final int[][] matrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};

    @Test
    void findsValuesInEveryRow() {
        assertTrue(SearchMatrix.contains(matrix, 1));
        assertTrue(SearchMatrix.contains(matrix, 9));
        assertTrue(SearchMatrix.contains(matrix, 17));
    }

    @Test
    void rejectsAbsentValues() {
        assertFalse(SearchMatrix.contains(matrix, 0));
        assertFalse(SearchMatrix.contains(matrix, 8));
        assertFalse(SearchMatrix.contains(matrix, 20));
    }

    @Test
    void handlesSingleRowAndSingleColumn() {
        assertTrue(SearchMatrix.contains(new int[][] {{1, 2, 3}}, 3));
        assertTrue(SearchMatrix.contains(new int[][] {{1}, {2}, {3}}, 2));
        assertFalse(SearchMatrix.contains(new int[][] {{1}}, 2));
    }
}
