package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BitsTest {

    @Test
    void countsSetBits() {
        assertEquals(0, Bits.countOnes(0));
        assertEquals(1, Bits.countOnes(8));
        assertEquals(3, Bits.countOnes(7));
        assertEquals(32, Bits.countOnes(-1));
    }

    @Test
    void isolatesTheLowestSetBit() {
        assertEquals(4, Bits.lowestSetBit(12));
        assertEquals(1, Bits.lowestSetBit(7));
        assertEquals(0, Bits.lowestSetBit(0));
    }

    @Test
    void recognisesPowersOfTwo() {
        assertTrue(Bits.isPowerOfTwo(1));
        assertTrue(Bits.isPowerOfTwo(64));
        assertFalse(Bits.isPowerOfTwo(0));
        assertFalse(Bits.isPowerOfTwo(6));
        assertFalse(Bits.isPowerOfTwo(-8));
    }

    @Test
    void readsAndWritesIndividualBits() {
        assertTrue(Bits.isSet(0b1010, 1));
        assertFalse(Bits.isSet(0b1010, 0));
        assertEquals(0b1011, Bits.set(0b1010, 0));
        assertEquals(0b1010, Bits.set(0b1010, 1));
        assertEquals(0b1000, Bits.clear(0b1010, 1));
        assertEquals(0b1010, Bits.clear(0b1010, 0));
    }

    @Test
    void enumeratesSubsetsByMask() {
        assertEquals(
                List.of(List.of(), List.of(1), List.of(2), List.of(1, 2)),
                Bits.subsets(new int[] {1, 2}));
        assertEquals(List.of(List.of()), Bits.subsets(new int[] {}));
        assertEquals(8, Bits.subsets(new int[] {1, 2, 3}).size());
    }

    @Test
    void xorFindsTheUnpairedValue() {
        assertEquals(4, Bits.singleNumber(new int[] {2, 3, 2, 4, 3}));
        assertEquals(7, Bits.singleNumber(new int[] {7}));
    }

    @Test
    void countsOnesForEveryPrefixValue() {
        assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2, 2, 3}, Bits.countOnesUpTo(7));
        assertArrayEquals(new int[] {0}, Bits.countOnesUpTo(0));
    }
}
