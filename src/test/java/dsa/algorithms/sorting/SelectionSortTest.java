package dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;

class SelectionSortTest {

    @Test
    void sortsEveryShapeAndAgreesWithTheJdk() {
        SortContract.verify(SelectionSort::sort);
    }
}
