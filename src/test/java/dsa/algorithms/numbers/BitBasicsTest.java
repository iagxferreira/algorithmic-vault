package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BitBasicsTest {

    @Test
    void countsSetBits() {
        assertEquals(0, BitBasics.countOnes(0));
        assertEquals(1, BitBasics.countOnes(8));
        assertEquals(3, BitBasics.countOnes(7));
        assertEquals(32, BitBasics.countOnes(-1), "every bit of -1 is set");
    }

    @Test
    void isolatesTheLowestSetBit() {
        assertEquals(4, BitBasics.lowestSetBit(12));
        assertEquals(1, BitBasics.lowestSetBit(7));
        assertEquals(8, BitBasics.lowestSetBit(8));
        assertEquals(0, BitBasics.lowestSetBit(0));
    }

    @Test
    void recognisesPowersOfTwo() {
        assertTrue(BitBasics.isPowerOfTwo(1));
        assertTrue(BitBasics.isPowerOfTwo(64));
        assertFalse(BitBasics.isPowerOfTwo(0));
        assertFalse(BitBasics.isPowerOfTwo(6));
        assertFalse(BitBasics.isPowerOfTwo(-8), "x & (x-1) == 0 is not enough on its own");
    }

    @Test
    void readsAndWritesIndividualBits() {
        assertTrue(BitBasics.isSet(0b1010, 1));
        assertFalse(BitBasics.isSet(0b1010, 0));
        assertEquals(0b1011, BitBasics.set(0b1010, 0));
        assertEquals(0b1010, BitBasics.set(0b1010, 1), "setting a set bit changes nothing");
        assertEquals(0b1000, BitBasics.clear(0b1010, 1));
        assertEquals(0b1010, BitBasics.clear(0b1010, 0), "clearing a clear bit changes nothing");
    }

    @Test
    void togglesBits() {
        assertEquals(0b1011, BitBasics.toggle(0b1010, 0));
        assertEquals(0b1000, BitBasics.toggle(0b1010, 1));
    }

    @Test
    void countsOnesForEveryPrefixValue() {
        assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2, 2, 3}, BitBasics.countOnesUpTo(7));
        assertArrayEquals(new int[] {0}, BitBasics.countOnesUpTo(0));
        assertEquals(1025, BitBasics.countOnesUpTo(1024).length);
    }
}
