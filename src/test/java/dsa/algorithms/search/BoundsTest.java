package dsa.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BoundsTest {

    private final int[] withRuns = {1, 2, 2, 2, 5};

    @Test
    void lowerBoundFindsTheFirstNotBelowTarget() {
        assertEquals(1, Bounds.lowerBound(withRuns, 2));
        assertEquals(0, Bounds.lowerBound(withRuns, 1));
        assertEquals(4, Bounds.lowerBound(withRuns, 3), "absent target gives the insertion point");
        assertEquals(5, Bounds.lowerBound(withRuns, 9), "past the end");
        assertEquals(0, Bounds.lowerBound(withRuns, -1));
    }

    @Test
    void upperBoundFindsTheFirstAboveTarget() {
        assertEquals(4, Bounds.upperBound(withRuns, 2));
        assertEquals(1, Bounds.upperBound(withRuns, 1));
        assertEquals(0, Bounds.upperBound(withRuns, 0));
        assertEquals(5, Bounds.upperBound(withRuns, 5));
    }

    @Test
    void boundsAgreeOnAnEmptyArray() {
        assertEquals(0, Bounds.lowerBound(new int[] {}, 1));
        assertEquals(0, Bounds.upperBound(new int[] {}, 1));
    }

    @Test
    void bracketsTheRunOfEqualValues() {
        assertArrayEquals(new int[] {1, 3}, Bounds.firstAndLastOccurrence(withRuns, 2));
        assertArrayEquals(new int[] {0, 0}, Bounds.firstAndLastOccurrence(withRuns, 1));
        assertArrayEquals(new int[] {-1, -1}, Bounds.firstAndLastOccurrence(withRuns, 9));
    }

    @Test
    void countsOccurrences() {
        assertEquals(3, Bounds.countOccurrences(withRuns, 2));
        assertEquals(1, Bounds.countOccurrences(withRuns, 5));
        assertEquals(0, Bounds.countOccurrences(withRuns, 4));
    }
}
