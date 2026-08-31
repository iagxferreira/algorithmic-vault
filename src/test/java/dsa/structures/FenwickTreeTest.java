package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FenwickTreeTest {

    @Test
    void startsAllZero() {
        FenwickTree tree = new FenwickTree(5);
        assertEquals(0, tree.prefixSum(4));
        assertEquals(0, tree.rangeSum(1, 3));
    }

    @Test
    void accumulatesPointUpdates() {
        FenwickTree tree = new FenwickTree(5);
        tree.update(0, 3);
        tree.update(2, 5);
        tree.update(4, 7);
        assertEquals(3, tree.prefixSum(0));
        assertEquals(8, tree.prefixSum(2));
        assertEquals(15, tree.prefixSum(4));
    }

    @Test
    void answersInclusiveRangeSums() {
        FenwickTree tree = FenwickTree.of(new int[] {1, 2, 3, 4, 5});
        assertEquals(15, tree.rangeSum(0, 4));
        assertEquals(9, tree.rangeSum(1, 3));
        assertEquals(3, tree.rangeSum(2, 2));
    }

    @Test
    void updatesAreVisibleToLaterQueries() {
        FenwickTree tree = FenwickTree.of(new int[] {1, 2, 3, 4, 5});
        tree.update(2, 10);
        assertEquals(25, tree.rangeSum(0, 4));
        assertEquals(19, tree.rangeSum(1, 3));
    }

    @Test
    void handlesNegativeDeltas() {
        FenwickTree tree = FenwickTree.of(new int[] {5, 5, 5});
        tree.update(1, -5);
        assertEquals(10, tree.rangeSum(0, 2));
        assertEquals(0, tree.rangeSum(1, 1));
    }
}
