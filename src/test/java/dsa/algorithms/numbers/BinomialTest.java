package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinomialTest {

    @Test
    void computesSmallBinomials() {
        assertEquals(1, Binomial.choose(5, 0));
        assertEquals(5, Binomial.choose(5, 1));
        assertEquals(10, Binomial.choose(5, 2));
        assertEquals(1, Binomial.choose(5, 5));
    }

    @Test
    void outOfRangeChoicesAreZero() {
        assertEquals(0, Binomial.choose(5, 6));
        assertEquals(0, Binomial.choose(5, -1));
        assertEquals(1, Binomial.choose(0, 0));
    }

    @Test
    void isSymmetric() {
        assertEquals(Binomial.choose(20, 7), Binomial.choose(20, 13));
    }

    @Test
    void staysInsideTheModulus() {
        long result = Binomial.choose(100_000, 50_000);
        assertTrue(result >= 0 && result < FastPower.MOD, "result must be reduced mod 1e9+7");
    }

    @Test
    void computesFactorialsModulo() {
        assertEquals(1, Binomial.factorialMod(0));
        assertEquals(120, Binomial.factorialMod(5));
        assertTrue(Binomial.factorialMod(100_000) < FastPower.MOD);
    }
}
