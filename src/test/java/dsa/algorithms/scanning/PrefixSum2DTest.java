package dsa.algorithms.scanning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrefixSum2DTest {

    private final int[][] grid = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    @Test
    void padsTheArrayByOne() {
        int[][] prefix = PrefixSum2D.build(grid);
        assertEquals(4, prefix.length);
        assertEquals(4, prefix[0].length);
        assertEquals(0, prefix[0][0]);
        assertEquals(0, prefix[0][3]);
    }

    @Test
    void answersRectangleSums() {
        int[][] prefix = PrefixSum2D.build(grid);
        assertEquals(45, PrefixSum2D.rangeSum(prefix, 0, 0, 2, 2));
        assertEquals(24, PrefixSum2D.rangeSum(prefix, 1, 0, 2, 1));
        assertEquals(5, PrefixSum2D.rangeSum(prefix, 1, 1, 1, 1));
    }

    @Test
    void answersSingleRowAndColumnQueries() {
        int[][] prefix = PrefixSum2D.build(grid);
        assertEquals(6, PrefixSum2D.rangeSum(prefix, 0, 0, 0, 2), "the first row");
        assertEquals(12, PrefixSum2D.rangeSum(prefix, 0, 0, 2, 0), "the first column");
    }

    @Test
    void handlesASingleCellGrid() {
        int[][] prefix = PrefixSum2D.build(new int[][] {{7}});
        assertEquals(7, PrefixSum2D.rangeSum(prefix, 0, 0, 0, 0));
    }
}
