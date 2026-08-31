package dsa.exercises.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DynamicProgrammingExercisesTest {

    @Nested
    class MaximumSubarrayTest {

        @Test
        void findsTheBestRun() {
            assertEquals(6, MaximumSubarray.solve(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
            assertEquals(23, MaximumSubarray.solve(new int[] {5, 4, -1, 7, 8}));
        }

        @Test
        void handlesAllNegativeInput() {
            assertEquals(-1, MaximumSubarray.solve(new int[] {-3, -1, -2}));
            assertEquals(1, MaximumSubarray.solve(new int[] {1}));
        }
    }

    @Nested
    class ClimbingStairsTest {

        @Test
        void countsTheWays() {
            assertEquals(1, ClimbingStairs.solve(1));
            assertEquals(2, ClimbingStairs.solve(2));
            assertEquals(3, ClimbingStairs.solve(3));
            assertEquals(8, ClimbingStairs.solve(5));
        }

        @Test
        void staysFastForLargeInput() {
            assertEquals(1_836_311_903, ClimbingStairs.solve(45));
        }
    }

    @Nested
    class HouseRobberTest {

        @Test
        void skipsAdjacentHouses() {
            assertEquals(12, HouseRobber.solve(new int[] {2, 7, 9, 3, 1}));
            assertEquals(4, HouseRobber.solve(new int[] {1, 2, 3, 1}));
        }

        @Test
        void handlesTinyInput() {
            assertEquals(0, HouseRobber.solve(new int[] {}));
            assertEquals(5, HouseRobber.solve(new int[] {5}));
            assertEquals(5, HouseRobber.solve(new int[] {2, 5}));
        }
    }

    @Nested
    class CoinChangeTest {

        @Test
        void findsTheFewestCoins() {
            assertEquals(3, CoinChange.solve(new int[] {1, 2, 5}, 11));
            assertEquals(2, CoinChange.solve(new int[] {1, 3, 4}, 6), "greedy would answer 3 here");
        }

        @Test
        void reportsImpossibleAmounts() {
            assertEquals(-1, CoinChange.solve(new int[] {2}, 3));
            assertEquals(0, CoinChange.solve(new int[] {1}, 0));
        }
    }

    @Nested
    class LongestIncreasingSubsequenceTest {

        @Test
        void measuresTheLongestRun() {
            assertEquals(4, LongestIncreasingSubsequence.solve(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
            assertEquals(4, LongestIncreasingSubsequence.solve(new int[] {0, 1, 0, 3, 2, 3}));
        }

        @Test
        void requiresStrictIncrease() {
            assertEquals(1, LongestIncreasingSubsequence.solve(new int[] {7, 7, 7, 7}));
            assertEquals(0, LongestIncreasingSubsequence.solve(new int[] {}));
        }
    }

    @Nested
    class LongestCommonSubsequenceTest {

        @Test
        void findsTheSharedSubsequence() {
            assertEquals(3, LongestCommonSubsequence.solve("abcde", "ace"));
            assertEquals(3, LongestCommonSubsequence.solve("abc", "abc"));
        }

        @Test
        void reportsNothingInCommon() {
            assertEquals(0, LongestCommonSubsequence.solve("abc", "def"));
            assertEquals(0, LongestCommonSubsequence.solve("", "abc"));
        }
    }

    @Nested
    class WordBreakTest {

        @Test
        void segmentsWithReuse() {
            assertTrue(WordBreak.solve("leetcode", List.of("leet", "code")));
            assertTrue(WordBreak.solve("applepenapple", List.of("apple", "pen")));
            assertTrue(WordBreak.solve("", List.of("a")));
        }

        @Test
        void rejectsLeftoverCharacters() {
            assertFalse(WordBreak.solve("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
            assertFalse(WordBreak.solve("a", List.of()));
        }
    }

    @Nested
    class EditDistanceTest {

        @Test
        void countsTheEdits() {
            assertEquals(3, EditDistance.solve("horse", "ros"));
            assertEquals(5, EditDistance.solve("intention", "execution"));
        }

        @Test
        void handlesEmptyAndIdenticalStrings() {
            assertEquals(0, EditDistance.solve("abc", "abc"));
            assertEquals(3, EditDistance.solve("", "abc"));
            assertEquals(3, EditDistance.solve("abc", ""));
        }
    }

    @Nested
    class UniquePathsTest {

        @Test
        void countsRightAndDownPaths() {
            assertEquals(28, UniquePaths.solve(3, 7));
            assertEquals(3, UniquePaths.solve(3, 2));
            assertEquals(6, UniquePaths.solve(3, 3));
        }

        @Test
        void aSingleRowOrColumnHasOnePath() {
            assertEquals(1, UniquePaths.solve(1, 10));
            assertEquals(1, UniquePaths.solve(10, 1));
        }
    }
}
