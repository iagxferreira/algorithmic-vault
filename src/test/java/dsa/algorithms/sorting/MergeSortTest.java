package dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    void sortsEveryShapeAndAgreesWithTheJdk() {
        SortContract.verify(MergeSort::sort);
    }
}
