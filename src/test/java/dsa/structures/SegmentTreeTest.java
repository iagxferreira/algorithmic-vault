package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SegmentTreeTest {

    @Test
    void answersRangeSums() {
        SegmentTree tree = new SegmentTree(new int[] {1, 3, 5, 7, 9, 11});
        assertEquals(36, tree.rangeSum(0, 5));
        assertEquals(15, tree.rangeSum(1, 3));
        assertEquals(5, tree.rangeSum(2, 2));
    }

    @Test
    void answersRangeMinimums() {
        SegmentTree tree = new SegmentTree(new int[] {4, 2, 9, 1, 7});
        assertEquals(1, tree.rangeMin(0, 4));
        assertEquals(2, tree.rangeMin(0, 2));
        assertEquals(7, tree.rangeMin(4, 4));
    }

    @Test
    void pointAssignmentUpdatesBothAggregates() {
        SegmentTree tree = new SegmentTree(new int[] {4, 2, 9, 1, 7});
        tree.set(3, 100);
        assertEquals(122, tree.rangeSum(0, 4));
        assertEquals(2, tree.rangeMin(0, 4));
        assertEquals(9, tree.rangeMin(2, 3));
    }

    @Test
    void handlesASingleElement() {
        SegmentTree tree = new SegmentTree(new int[] {42});
        assertEquals(42, tree.rangeSum(0, 0));
        assertEquals(42, tree.rangeMin(0, 0));
        tree.set(0, -1);
        assertEquals(-1, tree.rangeSum(0, 0));
    }

    @Test
    void handlesNegativeValues() {
        SegmentTree tree = new SegmentTree(new int[] {-5, 3, -2, 8});
        assertEquals(4, tree.rangeSum(0, 3));
        assertEquals(-5, tree.rangeMin(0, 3));
        assertEquals(-2, tree.rangeMin(1, 2));
    }
}
