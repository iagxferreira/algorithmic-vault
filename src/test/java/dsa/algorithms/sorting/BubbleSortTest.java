package dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void sortsEveryShapeAndAgreesWithTheJdk() {
        SortContract.verify(BubbleSort::sort);
    }
}
