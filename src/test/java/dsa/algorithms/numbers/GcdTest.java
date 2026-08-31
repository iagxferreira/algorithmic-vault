package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GcdTest {

    @Test
    void computesGcd() {
        assertEquals(6, Gcd.gcd(12, 18));
        assertEquals(1, Gcd.gcd(17, 5));
        assertEquals(5, Gcd.gcd(5, 5));
    }

    @Test
    void handlesZero() {
        assertEquals(7, Gcd.gcd(7, 0));
        assertEquals(7, Gcd.gcd(0, 7));
        assertEquals(0, Gcd.gcd(0, 0));
    }

    @Test
    void computesLcmWithoutOverflowing() {
        assertEquals(36, Gcd.lcm(12, 18));
        assertEquals(3_000_000_000L, Gcd.lcm(1_000_000_000L, 3_000L));
        assertEquals(999_999_999_000_000_000L, Gcd.lcm(999_999_999L, 1_000_000_000L),
                "a * b would overflow here; divide first");
    }

    @Test
    void reducesAWholeArray() {
        assertEquals(4, Gcd.gcdOf(new int[] {8, 12, 20}));
        assertEquals(1, Gcd.gcdOf(new int[] {8, 9}));
        assertEquals(5, Gcd.gcdOf(new int[] {5}));
        assertEquals(0, Gcd.gcdOf(new int[] {}));
    }
}
