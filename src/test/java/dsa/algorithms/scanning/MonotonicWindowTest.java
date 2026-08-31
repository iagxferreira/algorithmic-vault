package dsa.algorithms.scanning;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MonotonicWindowTest {

    @Test
    void reportsTheMaximumOfEveryWindow() {
        assertArrayEquals(
                new int[] {3, 3, 5, 5, 6, 7},
                MonotonicWindow.maxOfEachWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    @Test
    void reportsTheMinimumOfEveryWindow() {
        assertArrayEquals(
                new int[] {-1, -3, -3, -3, 3, 3},
                MonotonicWindow.minOfEachWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    @Test
    void handlesAWindowOfOne() {
        assertArrayEquals(new int[] {4, 2, 9}, MonotonicWindow.maxOfEachWindow(new int[] {4, 2, 9}, 1));
    }

    @Test
    void handlesAWindowCoveringEverything() {
        assertArrayEquals(new int[] {9}, MonotonicWindow.maxOfEachWindow(new int[] {4, 2, 9}, 3));
    }

    @Test
    void handlesDecreasingAndEqualInput() {
        assertArrayEquals(new int[] {5, 4, 3}, MonotonicWindow.maxOfEachWindow(new int[] {5, 4, 3, 2}, 2));
        assertArrayEquals(new int[] {7, 7, 7}, MonotonicWindow.maxOfEachWindow(new int[] {7, 7, 7, 7}, 2));
    }
}
