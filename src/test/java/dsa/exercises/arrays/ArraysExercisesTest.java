package dsa.exercises.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ArraysExercisesTest {

    @Nested
    class TwoSumTest {

        @Test
        void findsThePair() {
            assertArrayEquals(new int[] {0, 1}, TwoSum.solve(new int[] {2, 7, 11, 15}, 9));
            assertArrayEquals(new int[] {1, 2}, TwoSum.solve(new int[] {3, 2, 4}, 6));
        }

        @Test
        void handlesDuplicatesAndNegatives() {
            assertArrayEquals(new int[] {0, 1}, TwoSum.solve(new int[] {3, 3}, 6));
            assertArrayEquals(new int[] {0, 2}, TwoSum.solve(new int[] {-3, 4, 3}, 0));
        }
    }

    @Nested
    class ContainsDuplicateTest {

        @Test
        void spotsRepeats() {
            assertTrue(ContainsDuplicate.solve(new int[] {1, 2, 3, 1}));
            assertTrue(ContainsDuplicate.solve(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        }

        @Test
        void acceptsDistinctInput() {
            assertFalse(ContainsDuplicate.solve(new int[] {1, 2, 3, 4}));
            assertFalse(ContainsDuplicate.solve(new int[] {}));
        }
    }

    @Nested
    class ValidAnagramTest {

        @Test
        void acceptsRearrangements() {
            assertTrue(ValidAnagram.solve("anagram", "nagaram"));
            assertTrue(ValidAnagram.solve("", ""));
        }

        @Test
        void rejectsDifferentLettersOrLengths() {
            assertFalse(ValidAnagram.solve("rat", "car"));
            assertFalse(ValidAnagram.solve("a", "ab"));
            assertFalse(ValidAnagram.solve("aab", "abb"));
        }
    }

    @Nested
    class GroupAnagramsTest {

        @Test
        void groupsAndOrdersDeterministically() {
            assertEquals(
                    List.of(List.of("bat"), List.of("eat", "tea", "ate"), List.of("tan", "nat")),
                    GroupAnagrams.solve(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        }

        @Test
        void handlesEmptyAndSingleWords() {
            assertEquals(List.of(), GroupAnagrams.solve(new String[] {}));
            assertEquals(List.of(List.of("")), GroupAnagrams.solve(new String[] {""}));
            assertEquals(List.of(List.of("a")), GroupAnagrams.solve(new String[] {"a"}));
        }
    }

    @Nested
    class ProductExceptSelfTest {

        @Test
        void multipliesEverythingElse() {
            assertArrayEquals(new int[] {24, 12, 8, 6}, ProductExceptSelf.solve(new int[] {1, 2, 3, 4}));
        }

        @Test
        void handlesZeroes() {
            assertArrayEquals(new int[] {0, 0, 9, 0, 0}, ProductExceptSelf.solve(new int[] {-1, 1, 0, -3, 3}));
            assertArrayEquals(new int[] {0, 0}, ProductExceptSelf.solve(new int[] {0, 0}));
        }
    }

    @Nested
    class TopKFrequentTest {

        @Test
        void picksTheMostFrequent() {
            assertArrayEquals(new int[] {1, 2}, TopKFrequent.solve(new int[] {1, 1, 1, 2, 2, 3}, 2));
            assertArrayEquals(new int[] {1}, TopKFrequent.solve(new int[] {1}, 1));
        }

        @Test
        void handlesKEqualToTheDistinctCount() {
            assertArrayEquals(new int[] {1, 2, 3}, TopKFrequent.solve(new int[] {3, 2, 1}, 3));
        }
    }

    @Nested
    class LongestConsecutiveSequenceTest {

        @Test
        void findsTheLongestRun() {
            assertEquals(4, LongestConsecutiveSequence.solve(new int[] {100, 4, 200, 1, 3, 2}));
            assertEquals(9, LongestConsecutiveSequence.solve(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        }

        @Test
        void handlesEmptyAndSingletonInput() {
            assertEquals(0, LongestConsecutiveSequence.solve(new int[] {}));
            assertEquals(1, LongestConsecutiveSequence.solve(new int[] {5}));
        }
    }
}
