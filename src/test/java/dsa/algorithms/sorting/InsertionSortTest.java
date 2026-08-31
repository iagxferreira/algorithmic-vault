package dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

    @Test
    void sortsEveryShapeAndAgreesWithTheJdk() {
        SortContract.verify(InsertionSort::sort);
    }
}
