package dsa.exercises.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BacktrackingExercisesTest {

    @Nested
    class SubsetsTest {

        @Test
        void enumeratesThePowerSet() {
            assertEquals(
                    List.of(
                            List.of(),
                            List.of(1),
                            List.of(1, 2),
                            List.of(1, 2, 3),
                            List.of(1, 3),
                            List.of(2),
                            List.of(2, 3),
                            List.of(3)),
                    Subsets.solve(new int[] {1, 2, 3}));
        }

        @Test
        void handlesEmptyAndSingletonInput() {
            assertEquals(List.of(List.of()), Subsets.solve(new int[] {}));
            assertEquals(List.of(List.of(), List.of(7)), Subsets.solve(new int[] {7}));
        }

        @Test
        void producesTwoToTheN() {
            assertEquals(16, Subsets.solve(new int[] {1, 2, 3, 4}).size());
        }
    }

    @Nested
    class PermutationsTest {

        @Test
        void enumeratesEveryOrdering() {
            assertEquals(
                    List.of(
                            List.of(1, 2, 3),
                            List.of(1, 3, 2),
                            List.of(2, 1, 3),
                            List.of(2, 3, 1),
                            List.of(3, 1, 2),
                            List.of(3, 2, 1)),
                    Permutations.solve(new int[] {1, 2, 3}));
        }

        @Test
        void handlesTinyInput() {
            assertEquals(List.of(List.of(1)), Permutations.solve(new int[] {1}));
            assertEquals(List.of(List.of()), Permutations.solve(new int[] {}));
        }

        @Test
        void producesNFactorial() {
            assertEquals(24, Permutations.solve(new int[] {1, 2, 3, 4}).size());
        }
    }

    @Nested
    class CombinationSumTest {

        @Test
        void reusesCandidates() {
            assertEquals(
                    List.of(List.of(2, 2, 3), List.of(7)),
                    CombinationSum.solve(new int[] {2, 3, 6, 7}, 7));
        }

        @Test
        void findsSeveralCombinations() {
            assertEquals(
                    List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)),
                    CombinationSum.solve(new int[] {2, 3, 5}, 8));
        }

        @Test
        void reportsNoCombination() {
            assertEquals(List.of(), CombinationSum.solve(new int[] {2}, 1));
        }
    }

    @Nested
    class WordSearchTest {

        private final char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        @Test
        void findsWindingPaths() {
            assertTrue(WordSearch.solve(board, "ABCCED"));
            assertTrue(WordSearch.solve(board, "SEE"));
            assertTrue(WordSearch.solve(board, "A"));
        }

        @Test
        void refusesToReuseACell() {
            assertFalse(WordSearch.solve(board, "ABCB"));
        }

        @Test
        void rejectsAbsentWords() {
            assertFalse(WordSearch.solve(board, "ABCD"));
            assertFalse(WordSearch.solve(board, "ABCESEEEFSZ"));
        }
    }

    @Nested
    class GenerateParenthesesTest {

        @Test
        void generatesInPruningOrder() {
            assertEquals(List.of("()"), GenerateParentheses.solve(1));
            assertEquals(
                    List.of("((()))", "(()())", "(())()", "()(())", "()()()"),
                    GenerateParentheses.solve(3));
        }

        @Test
        void countsTheCatalanNumbers() {
            assertEquals(List.of(""), GenerateParentheses.solve(0));
            assertEquals(2, GenerateParentheses.solve(2).size());
            assertEquals(14, GenerateParentheses.solve(4).size());
        }
    }

    @Nested
    class NQueensTest {

        @Test
        void countsTheClassicBoards() {
            assertEquals(1, NQueens.solve(1));
            assertEquals(2, NQueens.solve(4));
            assertEquals(10, NQueens.solve(5));
        }

        @Test
        void findsNoSolutionForTwoAndThree() {
            assertEquals(0, NQueens.solve(2));
            assertEquals(0, NQueens.solve(3));
        }

        @Test
        void countsTheEightQueensSolutions() {
            assertEquals(92, NQueens.solve(8));
        }
    }
}
