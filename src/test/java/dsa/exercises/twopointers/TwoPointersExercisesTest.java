package dsa.exercises.twopointers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TwoPointersExercisesTest {

    @Nested
    class ValidPalindromeTest {

        @Test
        void ignoresPunctuationAndCase() {
            assertTrue(ValidPalindrome.solve("A man, a plan, a canal: Panama"));
            assertTrue(ValidPalindrome.solve(" "));
            assertTrue(ValidPalindrome.solve("0P0"));
        }

        @Test
        void rejectsNonPalindromes() {
            assertFalse(ValidPalindrome.solve("race a car"));
            assertFalse(ValidPalindrome.solve("0P"));
        }
    }

    @Nested
    class TwoSumSortedTest {

        @Test
        void findsThePair() {
            assertArrayEquals(new int[] {0, 1}, TwoSumSorted.solve(new int[] {2, 7, 11, 15}, 9));
            assertArrayEquals(new int[] {0, 2}, TwoSumSorted.solve(new int[] {2, 3, 4}, 6));
        }

        @Test
        void handlesNegatives() {
            assertArrayEquals(new int[] {0, 1}, TwoSumSorted.solve(new int[] {-1, 0}, -1));
        }
    }

    @Nested
    class ThreeSumTest {

        @Test
        void findsUniqueTriples() {
            assertEquals(
                    List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                    ThreeSum.solve(new int[] {-1, 0, 1, 2, -1, -4}));
        }

        @Test
        void handlesAllZeroesAndNoAnswer() {
            assertEquals(List.of(List.of(0, 0, 0)), ThreeSum.solve(new int[] {0, 0, 0, 0}));
            assertEquals(List.of(), ThreeSum.solve(new int[] {1, 2, 3}));
            assertEquals(List.of(), ThreeSum.solve(new int[] {0, 1}));
        }
    }

    @Nested
    class ContainerWithMostWaterTest {

        @Test
        void findsTheLargestArea() {
            assertEquals(49, ContainerWithMostWater.solve(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
            assertEquals(1, ContainerWithMostWater.solve(new int[] {1, 1}));
        }

        @Test
        void prefersWidthWhenHeightsAreEqual() {
            assertEquals(6, ContainerWithMostWater.solve(new int[] {2, 2, 2, 2}));
        }
    }

    @Nested
    class TrappingRainWaterTest {

        @Test
        void measuresTrappedWater() {
            assertEquals(6, TrappingRainWater.solve(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
            assertEquals(9, TrappingRainWater.solve(new int[] {4, 2, 0, 3, 2, 5}));
        }

        @Test
        void monotonicOrTinyInputTrapsNothing() {
            assertEquals(0, TrappingRainWater.solve(new int[] {1, 2, 3, 4}));
            assertEquals(0, TrappingRainWater.solve(new int[] {4, 3, 2, 1}));
            assertEquals(0, TrappingRainWater.solve(new int[] {5}));
        }
    }

    @Nested
    class SortColorsTest {

        @Test
        void sortsInPlace() {
            assertArrayEquals(new int[] {0, 0, 1, 1, 2, 2}, SortColors.solve(new int[] {2, 0, 2, 1, 1, 0}));
            assertArrayEquals(new int[] {0, 1, 2}, SortColors.solve(new int[] {2, 0, 1}));
        }

        @Test
        void handlesSingleColourAndTinyInput() {
            assertArrayEquals(new int[] {1, 1, 1}, SortColors.solve(new int[] {1, 1, 1}));
            assertArrayEquals(new int[] {0}, SortColors.solve(new int[] {0}));
            assertArrayEquals(new int[] {}, SortColors.solve(new int[] {}));
        }
    }
}
