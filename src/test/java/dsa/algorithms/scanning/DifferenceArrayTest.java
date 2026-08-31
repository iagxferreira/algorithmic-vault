package dsa.algorithms.scanning;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DifferenceArrayTest {

    @Test
    void appliesOverlappingRangeUpdates() {
        int[][] updates = {{0, 2, 1}, {1, 3, 2}};
        assertArrayEquals(new int[] {1, 3, 3, 2, 0}, DifferenceArray.applyRangeUpdates(5, updates));
    }

    @Test
    void handlesNoUpdatesAndFullRangeUpdates() {
        assertArrayEquals(new int[] {0, 0, 0}, DifferenceArray.applyRangeUpdates(3, new int[][] {}));
        assertArrayEquals(new int[] {5, 5, 5}, DifferenceArray.applyRangeUpdates(3, new int[][] {{0, 2, 5}}));
    }

    @Test
    void updatingTheLastIndexDoesNotOverflowTheArray() {
        assertArrayEquals(new int[] {0, 0, 4}, DifferenceArray.applyRangeUpdates(3, new int[][] {{2, 2, 4}}),
                "the -delta goes at index to + 1, which is off the end");
    }

    @Test
    void handlesNegativeDeltas() {
        assertArrayEquals(new int[] {3, -2, -2}, DifferenceArray.applyRangeUpdates(3, new int[][] {{0, 2, 3}, {1, 2, -5}}));
    }

    @Test
    void reportsTheMaximumAsALong() {
        assertEquals(3L, DifferenceArray.maxAfterRangeUpdates(5, new int[][] {{0, 2, 1}, {1, 3, 2}}));
        assertEquals(0L, DifferenceArray.maxAfterRangeUpdates(3, new int[][] {}));
    }

    @Test
    void theRunningSumCanExceedIntRange() {
        int[][] updates = {{0, 2, 1_000_000_000}, {0, 2, 1_000_000_000}, {0, 2, 1_000_000_000}};
        assertEquals(3_000_000_000L, DifferenceArray.maxAfterRangeUpdates(3, updates),
                "an int accumulator wraps negative here");
    }
}
