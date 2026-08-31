package dsa.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class CountingSortTest {

    @Test
    void sortsWithinTheAllowedValueRange() {
        SortContract.verifyShapes(CountingSort::sort);
        SortContract.verifyAgainstJdk(CountingSort::sort, 0, 1001);
    }

    @Test
    void handlesTheRangeEndpoints() {
        assertArrayEquals(new int[] {0, 1000}, CountingSort.sort(new int[] {1000, 0}));
        assertArrayEquals(new int[] {0, 2, 3, 3, 9}, CountingSort.sort(new int[] {3, 9, 0, 3, 2}));
    }
}
