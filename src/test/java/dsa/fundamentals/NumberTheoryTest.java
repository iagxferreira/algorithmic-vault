package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NumberTheoryTest {

    @Nested
    class Divisibility {

        @Test
        void computesGcd() {
            assertEquals(6, NumberTheory.gcd(12, 18));
            assertEquals(1, NumberTheory.gcd(17, 5));
            assertEquals(7, NumberTheory.gcd(7, 0));
        }

        @Test
        void computesLcmWithoutOverflowing() {
            assertEquals(36, NumberTheory.lcm(12, 18));
            assertEquals(3_000_000_000L, NumberTheory.lcm(1_000_000_000L, 3_000L));
        }

        @Test
        void listsDivisorsInOrder() {
            assertEquals(List.of(1L, 2L, 3L, 4L, 6L, 12L), NumberTheory.divisors(12));
            assertEquals(List.of(1L), NumberTheory.divisors(1));
            assertEquals(List.of(1L, 5L, 25L), NumberTheory.divisors(25));
        }
    }

    @Nested
    class Exponentiation {

        @Test
        void squaresItsWayUp() {
            assertEquals(1, NumberTheory.power(2, 0));
            assertEquals(1024, NumberTheory.power(2, 10));
            assertEquals(59049, NumberTheory.power(3, 10));
        }

        @Test
        void takesTheModulusAtEveryStep() {
            assertEquals(24, NumberTheory.modPow(2, 10, 1000));
            assertEquals(1, NumberTheory.modPow(5, 0, 7));
            assertEquals(976_371_285L, NumberTheory.modPow(2, 100, NumberTheory.MOD));
        }
    }

    @Nested
    class Primes {

        @Test
        void recognisesPrimes() {
            assertFalse(NumberTheory.isPrime(1));
            assertTrue(NumberTheory.isPrime(2));
            assertTrue(NumberTheory.isPrime(97));
            assertFalse(NumberTheory.isPrime(91));
            assertTrue(NumberTheory.isPrime(1_000_000_007L));
        }

        @Test
        void sievesUpToALimit() {
            assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19), NumberTheory.primesUpTo(20));
            assertEquals(List.of(), NumberTheory.primesUpTo(1));
            assertEquals(168, NumberTheory.primesUpTo(1000).size());
        }

        @Test
        void factorisesWithExponents() {
            assertEquals(Map.of(2L, 3, 3L, 2, 5L, 1), NumberTheory.primeFactors(360));
            assertEquals(Map.of(13L, 1), NumberTheory.primeFactors(13));
            assertEquals(Map.of(), NumberTheory.primeFactors(1));
        }
    }

    @Nested
    class Combinatorics {

        @Test
        void computesSmallBinomials() {
            assertEquals(1, NumberTheory.binomialMod(5, 0));
            assertEquals(10, NumberTheory.binomialMod(5, 2));
            assertEquals(1, NumberTheory.binomialMod(5, 5));
            assertEquals(0, NumberTheory.binomialMod(5, 6));
        }

        @Test
        void staysInsideTheModulus() {
            long result = NumberTheory.binomialMod(100_000, 50_000);
            assertTrue(result >= 0 && result < NumberTheory.MOD, "result must be reduced mod 1e9+7");
        }
    }
}
