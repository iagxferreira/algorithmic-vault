package dsa.algorithms.scanning;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class FixedWindowTest {

    @Test
    void findsTheBestWindowSum() {
        assertEquals(9, FixedWindow.maxSum(new int[] {2, 1, 5, 1, 3, 2}, 3));
        assertEquals(7, FixedWindow.maxSum(new int[] {2, 3, 4, 1, 5}, 2));
        assertEquals(-3, FixedWindow.maxSum(new int[] {-1, -2, -3}, 2), "all-negative input still has a best window");
    }

    @Test
    void returnsZeroWhenTheWindowDoesNotFit() {
        assertEquals(0, FixedWindow.maxSum(new int[] {1, 2}, 5));
        assertEquals(0, FixedWindow.maxSum(new int[] {}, 1));
        assertEquals(0, FixedWindow.maxSum(new int[] {1, 2}, 0));
    }

    @Test
    void computesEveryWindowSum() {
        assertArrayEquals(new int[] {6, 9, 12}, FixedWindow.sums(new int[] {1, 2, 3, 4, 5}, 3));
        assertArrayEquals(new int[] {}, FixedWindow.sums(new int[] {1}, 2));
    }

    @Test
    void computesWindowAverages() {
        assertEquals(List.of(2.0, 3.0, 4.0), FixedWindow.averages(new int[] {1, 2, 3, 4, 5}, 3));
        assertEquals(List.of(), FixedWindow.averages(new int[] {1}, 2));
    }

    @Test
    void aWindowCoveringEverythingIsOneWindow() {
        assertArrayEquals(new int[] {6}, FixedWindow.sums(new int[] {1, 2, 3}, 3));
    }
}
