package dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;

class HeapSortTest {

    @Test
    void sortsEveryShapeAndAgreesWithTheJdk() {
        SortContract.verify(HeapSort::sort);
    }
}
