package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FactorisationTest {

    @Test
    void factorisesWithExponents() {
        assertEquals(Map.of(2L, 3, 3L, 2, 5L, 1), Factorisation.primeFactors(360));
        assertEquals(Map.of(13L, 1), Factorisation.primeFactors(13));
        assertEquals(Map.of(2L, 10), Factorisation.primeFactors(1024));
        assertEquals(Map.of(), Factorisation.primeFactors(1));
    }

    @Test
    void handlesALargePrimeFactor() {
        assertEquals(Map.of(2L, 1, 1_000_000_007L, 1), Factorisation.primeFactors(2_000_000_014L),
                "the leftover after the sqrt loop is itself prime");
    }

    @Test
    void listsDivisorsInOrder() {
        assertEquals(List.of(1L, 2L, 3L, 4L, 6L, 12L), Factorisation.divisors(12));
        assertEquals(List.of(1L), Factorisation.divisors(1));
        assertEquals(List.of(1L, 5L, 25L), Factorisation.divisors(25), "a perfect square must not repeat its root");
        assertEquals(List.of(1L, 7L), Factorisation.divisors(7));
    }

    @Test
    void countsDivisors() {
        assertEquals(6, Factorisation.countDivisors(12));
        assertEquals(1, Factorisation.countDivisors(1));
        assertEquals(3, Factorisation.countDivisors(25));
        assertEquals(24, Factorisation.countDivisors(360));
    }
}
