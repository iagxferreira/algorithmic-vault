package dsa.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RotatedArrayTest {

    private final int[] rotated = {4, 5, 6, 7, 0, 1, 2};

    @Test
    void findsValuesInEitherHalf() {
        assertEquals(0, RotatedArray.search(rotated, 4));
        assertEquals(3, RotatedArray.search(rotated, 7));
        assertEquals(4, RotatedArray.search(rotated, 0));
        assertEquals(6, RotatedArray.search(rotated, 2));
    }

    @Test
    void reportsAbsentValues() {
        assertEquals(-1, RotatedArray.search(rotated, 3));
        assertEquals(-1, RotatedArray.search(new int[] {1}, 0));
    }

    @Test
    void handlesAnUnrotatedArray() {
        assertEquals(1, RotatedArray.search(new int[] {1, 2, 3}, 2));
        assertEquals(1, RotatedArray.findMin(new int[] {1, 2, 3}));
    }

    @Test
    void findsTheRotationPoint() {
        assertEquals(0, RotatedArray.findMin(rotated));
        assertEquals(1, RotatedArray.findMin(new int[] {3, 1, 2}));
        assertEquals(5, RotatedArray.findMin(new int[] {5}));
        assertEquals(1, RotatedArray.findMin(new int[] {2, 3, 4, 5, 1}));
    }
}
