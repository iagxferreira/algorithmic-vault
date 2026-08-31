package dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void sortsEveryShapeAndAgreesWithTheJdk() {
        SortContract.verify(QuickSort::sort);
    }
}
