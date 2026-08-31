package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class XorTricksTest {

    @Test
    void findsTheUnpairedValue() {
        assertEquals(4, XorTricks.singleNumber(new int[] {2, 3, 2, 4, 3}));
        assertEquals(7, XorTricks.singleNumber(new int[] {7}));
        assertEquals(1, XorTricks.singleNumber(new int[] {4, 1, 2, 1, 2}));
    }

    @Test
    void findsTheMissingNumber() {
        assertEquals(2, XorTricks.missingNumber(new int[] {3, 0, 1}));
        assertEquals(2, XorTricks.missingNumber(new int[] {0, 1}));
        assertEquals(0, XorTricks.missingNumber(new int[] {1}));
        assertEquals(1, XorTricks.missingNumber(new int[] {0}));
        assertEquals(8, XorTricks.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    @Test
    void swapsWithoutATemporary() {
        int[] values = {1, 2, 3};
        XorTricks.swapInPlace(values, 0, 2);
        assertArrayEquals(new int[] {3, 2, 1}, values);
    }

    @Test
    void swappingASlotWithItselfMustNotZeroIt() {
        int[] values = {5, 6};
        XorTricks.swapInPlace(values, 1, 1);
        assertArrayEquals(new int[] {5, 6}, values, "a ^= a zeroes the slot; guard i == j");
    }
}
