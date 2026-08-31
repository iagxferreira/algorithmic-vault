package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FastPowerTest {

    @Test
    void squaresItsWayUp() {
        assertEquals(1, FastPower.power(2, 0));
        assertEquals(2, FastPower.power(2, 1));
        assertEquals(1024, FastPower.power(2, 10));
        assertEquals(59049, FastPower.power(3, 10));
        assertEquals(1, FastPower.power(0, 0));
        assertEquals(0, FastPower.power(0, 5));
    }

    @Test
    void takesTheModulusAtEveryStep() {
        assertEquals(24, FastPower.modPow(2, 10, 1000));
        assertEquals(1, FastPower.modPow(5, 0, 7));
        assertEquals(0, FastPower.modPow(10, 3, 5));
    }

    @Test
    void survivesExponentsThatWouldNeverFinishNaively() {
        assertEquals(976_371_285L, FastPower.modPow(2, 100, FastPower.MOD));
        assertEquals(235_939_645L, FastPower.modPow(3, 1_000_000_000L, FastPower.MOD));
    }

    @Test
    void modInverseUndoesMultiplication() {
        for (long value : new long[] {2, 3, 12345, 999_999_937L}) {
            long inverse = FastPower.modInverse(value);
            assertEquals(1L, value % FastPower.MOD * inverse % FastPower.MOD,
                    "value * inverse must be 1 mod MOD, for value " + value);
        }
    }
}
