package dsa.algorithms.scanning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubarrayCountTest {

    @Test
    void countsSubarraysWithAGivenSum() {
        assertEquals(2, SubarrayCount.withSum(new int[] {1, 1, 1}, 2));
        assertEquals(2, SubarrayCount.withSum(new int[] {1, 2, 3}, 3));
        assertEquals(0, SubarrayCount.withSum(new int[] {1, 2, 3}, 7));
    }

    @Test
    void handlesNegativesAndZeroSums() {
        assertEquals(4, SubarrayCount.withSum(new int[] {1, -1, 1, -1}, 0));
        assertEquals(3, SubarrayCount.withSum(new int[] {0, 0, 0}, 0));
    }

    @Test
    void countsSubarraysStartingAtIndexZero() {
        assertEquals(1, SubarrayCount.withSum(new int[] {5}, 5),
                "the map must be seeded with prefix 0 seen once");
        assertEquals(0, SubarrayCount.withSum(new int[] {5}, 4));
    }

    @Test
    void findsTheLongestSubarrayWithAGivenSum() {
        assertEquals(4, SubarrayCount.longestWithSum(new int[] {1, -1, 5, -2, 3}, 3));
        assertEquals(2, SubarrayCount.longestWithSum(new int[] {-2, -1, 2, 1}, 1));
        assertEquals(0, SubarrayCount.longestWithSum(new int[] {1, 2}, 7));
    }
}
