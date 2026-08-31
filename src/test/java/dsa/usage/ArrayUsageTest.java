package dsa.usage;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ArrayUsageTest {

    @Test
    void resizesWithTruncationAndPadding() {
        assertArrayEquals(new int[] {1, 2}, ArrayUsage.resized(new int[] {1, 2, 3}, 2));
        assertArrayEquals(new int[] {1, 2, 3, 0, 0}, ArrayUsage.resized(new int[] {1, 2, 3}, 5));
        assertArrayEquals(new int[] {}, ArrayUsage.resized(new int[] {1}, 0));
    }

    @Test
    void slicesAHalfOpenRange() {
        assertArrayEquals(new int[] {2, 3}, ArrayUsage.slice(new int[] {1, 2, 3, 4}, 1, 3));
        assertArrayEquals(new int[] {1, 2, 3, 4}, ArrayUsage.slice(new int[] {1, 2, 3, 4}, 0, 4));
        assertArrayEquals(new int[] {}, ArrayUsage.slice(new int[] {1, 2}, 1, 1));
    }

    @Test
    void fillsAndConcatenates() {
        assertArrayEquals(new int[] {7, 7, 7}, ArrayUsage.filled(3, 7));
        assertArrayEquals(new int[] {}, ArrayUsage.filled(0, 7));
        assertArrayEquals(new int[] {1, 2, 3, 4}, ArrayUsage.concat(new int[] {1, 2}, new int[] {3, 4}));
        assertArrayEquals(new int[] {1}, ArrayUsage.concat(new int[] {1}, new int[] {}));
    }

    @Test
    void sortsWithoutTouchingTheInput() {
        int[] input = {3, 1, 2};
        assertArrayEquals(new int[] {1, 2, 3}, ArrayUsage.sortedCopy(input));
        assertArrayEquals(new int[] {3, 1, 2}, input, "the input array must be unchanged");
    }

    @Test
    void sortsDescending() {
        assertArrayEquals(new int[] {5, 3, 1}, ArrayUsage.sortedDescendingCopy(new int[] {3, 5, 1}));
        assertArrayEquals(
                new int[] {Integer.MAX_VALUE, 0, Integer.MIN_VALUE},
                ArrayUsage.sortedDescendingCopy(new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE}));
    }

    @Test
    void sortsRowsByTheirFirstColumn() {
        assertArrayEquals(
                new int[][] {{1, 9}, {3, 0}, {8, 2}},
                ArrayUsage.sortRowsByFirstColumn(new int[][] {{8, 2}, {1, 9}, {3, 0}}));
    }

    @Test
    void searchesASortedArray() {
        assertEquals(2, ArrayUsage.indexInSorted(new int[] {1, 3, 5, 7}, 5));
        assertEquals(0, ArrayUsage.indexInSorted(new int[] {1, 3, 5, 7}, 1));
        assertEquals(-1, ArrayUsage.indexInSorted(new int[] {1, 3, 5, 7}, 4));
        assertEquals(-1, ArrayUsage.indexInSorted(new int[] {}, 1));
    }

    @Test
    void deepCopyDoesNotShareRows() {
        int[][] original = {{1, 2}, {3, 4}};
        int[][] copy = ArrayUsage.deepCopy(original);
        copy[0][0] = 99;
        assertEquals(1, original[0][0], "clone() would share the rows; this must not");
        assertArrayEquals(new int[] {3, 4}, copy[1]);
    }

    @Test
    void transposesAGrid() {
        assertArrayEquals(
                new int[][] {{1, 4}, {2, 5}, {3, 6}},
                ArrayUsage.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}}));
        assertArrayEquals(new int[][] {{1}}, ArrayUsage.transpose(new int[][] {{1}}));
    }
}
