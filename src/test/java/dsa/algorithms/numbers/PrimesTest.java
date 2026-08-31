package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class PrimesTest {

    @Test
    void recognisesSmallPrimes() {
        assertFalse(Primes.isPrime(0));
        assertFalse(Primes.isPrime(1));
        assertTrue(Primes.isPrime(2));
        assertTrue(Primes.isPrime(3));
        assertFalse(Primes.isPrime(4));
        assertFalse(Primes.isPrime(9), "the square of a prime is the classic false positive");
    }

    @Test
    void recognisesLargerPrimes() {
        assertTrue(Primes.isPrime(97));
        assertFalse(Primes.isPrime(91), "91 is 7 times 13");
        assertTrue(Primes.isPrime(1_000_000_007L));
        assertFalse(Primes.isPrime(1_000_000_009L * 2));
    }

    @Test
    void sievesUpToALimit() {
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19), Primes.primesUpTo(20));
        assertEquals(List.of(2), Primes.primesUpTo(2));
        assertEquals(List.of(), Primes.primesUpTo(1));
        assertEquals(List.of(), Primes.primesUpTo(0));
    }

    @Test
    void theSieveScalesToAMillion() {
        assertEquals(168, Primes.primesUpTo(1000).size());
        assertEquals(78_498, Primes.primesUpTo(1_000_000).size());
    }

    @Test
    void countsPrimesBelowALimit() {
        assertEquals(0, Primes.countPrimesBelow(2), "strictly below, so 2 does not count");
        assertEquals(4, Primes.countPrimesBelow(10));
        assertEquals(25, Primes.countPrimesBelow(100));
    }
}
