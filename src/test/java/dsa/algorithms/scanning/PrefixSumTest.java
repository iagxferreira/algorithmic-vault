package dsa.algorithms.scanning;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrefixSumTest {

    @Test
    void buildsAnExclusivePrefixArray() {
        assertArrayEquals(new int[] {0, 1, 3, 6, 10}, PrefixSum.build(new int[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {0}, PrefixSum.build(new int[] {}));
        assertArrayEquals(new int[] {0, 5}, PrefixSum.build(new int[] {5}));
    }

    @Test
    void answersRangeSums() {
        int[] prefix = PrefixSum.build(new int[] {1, 2, 3, 4, 5});
        assertEquals(15, PrefixSum.rangeSum(prefix, 0, 4));
        assertEquals(9, PrefixSum.rangeSum(prefix, 1, 3));
        assertEquals(3, PrefixSum.rangeSum(prefix, 2, 2));
        assertEquals(1, PrefixSum.rangeSum(prefix, 0, 0));
    }

    @Test
    void handlesNegativeValues() {
        int[] prefix = PrefixSum.build(new int[] {2, -3, 4});
        assertEquals(3, PrefixSum.rangeSum(prefix, 0, 2));
        assertEquals(1, PrefixSum.rangeSum(prefix, 1, 2));
    }
}
