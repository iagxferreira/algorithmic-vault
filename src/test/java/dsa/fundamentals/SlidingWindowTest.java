package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SlidingWindowTest {

    @Nested
    class FixedSize {

        @Test
        void findsTheBestWindowSum() {
            assertEquals(9, SlidingWindow.maxSumFixedWindow(new int[] {2, 1, 5, 1, 3, 2}, 3));
            assertEquals(7, SlidingWindow.maxSumFixedWindow(new int[] {2, 3, 4, 1, 5}, 2));
            assertEquals(-3, SlidingWindow.maxSumFixedWindow(new int[] {-1, -2, -3}, 2));
        }

        @Test
        void returnsZeroWhenTheWindowDoesNotFit() {
            assertEquals(0, SlidingWindow.maxSumFixedWindow(new int[] {1, 2}, 5));
        }

        @Test
        void computesWindowAverages() {
            assertEquals(List.of(2.0, 3.0, 4.0), SlidingWindow.averagesOfFixedWindows(new int[] {1, 2, 3, 4, 5}, 3));
            assertEquals(List.of(), SlidingWindow.averagesOfFixedWindows(new int[] {1}, 2));
        }
    }

    @Nested
    class VariableSize {

        @Test
        void findsTheShortestSubarrayReachingTheTarget() {
            assertEquals(2, SlidingWindow.minSubarrayLength(new int[] {2, 3, 1, 2, 4, 3}, 7));
            assertEquals(1, SlidingWindow.minSubarrayLength(new int[] {1, 4, 4}, 4));
            assertEquals(0, SlidingWindow.minSubarrayLength(new int[] {1, 1, 1}, 11));
        }

        @Test
        void findsTheLongestSubstringWithoutRepeats() {
            assertEquals(3, SlidingWindow.longestUniqueSubstring("abcabcbb"));
            assertEquals(1, SlidingWindow.longestUniqueSubstring("bbbbb"));
            assertEquals(3, SlidingWindow.longestUniqueSubstring("pwwkew"));
            assertEquals(0, SlidingWindow.longestUniqueSubstring(""));
        }

        @Test
        void limitsTheNumberOfDistinctCharacters() {
            assertEquals(3, SlidingWindow.longestWithAtMostKDistinct("eceba", 2));
            assertEquals(2, SlidingWindow.longestWithAtMostKDistinct("aa", 1));
            assertEquals(0, SlidingWindow.longestWithAtMostKDistinct("abc", 0));
        }
    }

    @Nested
    class MonotonicDeque {

        @Test
        void reportsTheMaximumOfEveryWindow() {
            assertArrayEquals(
                    new int[] {3, 3, 5, 5, 6, 7},
                    SlidingWindow.maxOfEachWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
        }

        @Test
        void handlesAWindowOfOne() {
            assertArrayEquals(new int[] {4, 2, 9}, SlidingWindow.maxOfEachWindow(new int[] {4, 2, 9}, 1));
        }

        @Test
        void handlesAWindowCoveringEverything() {
            assertArrayEquals(new int[] {9}, SlidingWindow.maxOfEachWindow(new int[] {4, 2, 9}, 3));
        }
    }
}
