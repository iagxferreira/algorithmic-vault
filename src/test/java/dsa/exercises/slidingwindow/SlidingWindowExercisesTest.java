package dsa.exercises.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SlidingWindowExercisesTest {

    @Nested
    class BestTimeToBuyAndSellStockTest {

        @Test
        void findsTheBestTrade() {
            assertEquals(5, BestTimeToBuyAndSellStock.solve(new int[] {7, 1, 5, 3, 6, 4}));
            assertEquals(4, BestTimeToBuyAndSellStock.solve(new int[] {2, 4, 1, 5, 3}));
        }

        @Test
        void returnsZeroWhenPricesOnlyFall() {
            assertEquals(0, BestTimeToBuyAndSellStock.solve(new int[] {7, 6, 4, 3, 1}));
            assertEquals(0, BestTimeToBuyAndSellStock.solve(new int[] {5}));
            assertEquals(0, BestTimeToBuyAndSellStock.solve(new int[] {}));
        }
    }

    @Nested
    class LongestRepeatingCharacterReplacementTest {

        @Test
        void countsTheBestWindow() {
            assertEquals(4, LongestRepeatingCharacterReplacement.solve("AABABBA", 1));
            assertEquals(4, LongestRepeatingCharacterReplacement.solve("ABAB", 2));
        }

        @Test
        void handlesNoReplacementsAndEmptyInput() {
            assertEquals(2, LongestRepeatingCharacterReplacement.solve("AABB", 0));
            assertEquals(0, LongestRepeatingCharacterReplacement.solve("", 2));
        }
    }

    @Nested
    class PermutationInStringTest {

        @Test
        void findsAScrambledMatch() {
            assertTrue(PermutationInString.solve("ab", "eidbaooo"));
            assertTrue(PermutationInString.solve("adc", "dcda"));
            assertTrue(PermutationInString.solve("a", "a"));
        }

        @Test
        void rejectsNonMatches() {
            assertFalse(PermutationInString.solve("ab", "eidboaoo"));
            assertFalse(PermutationInString.solve("abc", "ab"));
        }
    }

    @Nested
    class MinimumWindowSubstringTest {

        @Test
        void findsTheShortestCoveringWindow() {
            assertEquals("BANC", MinimumWindowSubstring.solve("ADOBECODEBANC", "ABC"));
            assertEquals("a", MinimumWindowSubstring.solve("a", "a"));
        }

        @Test
        void respectsDuplicateRequirements() {
            assertEquals("baa", MinimumWindowSubstring.solve("cabaa", "aab"));
        }

        @Test
        void returnsEmptyWhenNoWindowCovers() {
            assertEquals("", MinimumWindowSubstring.solve("a", "aa"));
            assertEquals("", MinimumWindowSubstring.solve("ab", "c"));
        }
    }

    @Nested
    class MaxConsecutiveOnesTest {

        @Test
        void flipsUpToKZeroes() {
            assertEquals(6, MaxConsecutiveOnes.solve(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
            assertEquals(10, MaxConsecutiveOnes.solve(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        }

        @Test
        void handlesZeroFlipsAndAllOnes() {
            assertEquals(3, MaxConsecutiveOnes.solve(new int[] {1, 1, 1, 0, 1, 1}, 0));
            assertEquals(4, MaxConsecutiveOnes.solve(new int[] {1, 1, 1, 1}, 2));
            assertEquals(0, MaxConsecutiveOnes.solve(new int[] {}, 1));
        }
    }
}
