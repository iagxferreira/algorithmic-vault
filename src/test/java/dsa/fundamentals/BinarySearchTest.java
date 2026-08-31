package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.TreeNode;
import dsa.support.TreeNodes;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Nested
    class SortedArrays {

        private final int[] sorted = {1, 3, 5, 7, 9, 11};

        @Test
        void findsPresentValues() {
            assertEquals(0, BinarySearch.search(sorted, 1));
            assertEquals(3, BinarySearch.search(sorted, 7));
            assertEquals(5, BinarySearch.search(sorted, 11));
        }

        @Test
        void reportsMinusOneForAbsentValues() {
            assertEquals(-1, BinarySearch.search(sorted, 0));
            assertEquals(-1, BinarySearch.search(sorted, 6));
            assertEquals(-1, BinarySearch.search(sorted, 100));
            assertEquals(-1, BinarySearch.search(new int[] {}, 1));
        }

        @Test
        void boundsBracketEqualRuns() {
            int[] withRuns = {1, 2, 2, 2, 5};
            assertEquals(1, BinarySearch.lowerBound(withRuns, 2));
            assertEquals(4, BinarySearch.upperBound(withRuns, 2));
            assertEquals(5, BinarySearch.lowerBound(withRuns, 9));
            assertEquals(0, BinarySearch.upperBound(withRuns, 0));
        }

        @Test
        void findsFirstAndLastOccurrence() {
            assertArrayEquals(new int[] {1, 3}, BinarySearch.firstAndLastOccurrence(new int[] {1, 2, 2, 2, 5}, 2));
            assertArrayEquals(new int[] {0, 0}, BinarySearch.firstAndLastOccurrence(new int[] {1, 2}, 1));
            assertArrayEquals(new int[] {-1, -1}, BinarySearch.firstAndLastOccurrence(new int[] {1, 2}, 9));
        }
    }

    @Nested
    class RotatedArrays {

        private final int[] rotated = {4, 5, 6, 7, 0, 1, 2};

        @Test
        void findsValuesInEitherHalf() {
            assertEquals(0, BinarySearch.searchRotated(rotated, 4));
            assertEquals(3, BinarySearch.searchRotated(rotated, 7));
            assertEquals(4, BinarySearch.searchRotated(rotated, 0));
            assertEquals(6, BinarySearch.searchRotated(rotated, 2));
        }

        @Test
        void reportsAbsentValues() {
            assertEquals(-1, BinarySearch.searchRotated(rotated, 3));
        }

        @Test
        void handlesAnUnrotatedArray() {
            assertEquals(1, BinarySearch.searchRotated(new int[] {1, 2, 3}, 2));
            assertEquals(1, BinarySearch.findMinInRotated(new int[] {1, 2, 3}));
        }

        @Test
        void findsTheRotationPoint() {
            assertEquals(0, BinarySearch.findMinInRotated(rotated));
            assertEquals(1, BinarySearch.findMinInRotated(new int[] {3, 1, 2}));
            assertEquals(5, BinarySearch.findMinInRotated(new int[] {5}));
        }
    }

    @Nested
    class OtherStructures {

        @Test
        void searchesARowSortedMatrix() {
            int[][] matrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
            assertTrue(BinarySearch.searchMatrix(matrix, 1));
            assertTrue(BinarySearch.searchMatrix(matrix, 9));
            assertTrue(BinarySearch.searchMatrix(matrix, 17));
            assertFalse(BinarySearch.searchMatrix(matrix, 8));
        }

        @Test
        void searchesABinarySearchTree() {
            TreeNode root = TreeNodes.of(8, 3, 10, 1, 6, null, 14);
            assertTrue(BinarySearch.searchBst(root, 8));
            assertTrue(BinarySearch.searchBst(root, 1));
            assertTrue(BinarySearch.searchBst(root, 14));
            assertFalse(BinarySearch.searchBst(root, 7));
            assertFalse(BinarySearch.searchBst(null, 1));
        }
    }

    @Nested
    class AnswerSpace {

        @Test
        void firstTrueFindsTheBoundary() {
            assertEquals(5, BinarySearch.firstTrue(0, 10, x -> x >= 5));
            assertEquals(0, BinarySearch.firstTrue(0, 10, x -> true));
            assertEquals(11, BinarySearch.firstTrue(0, 10, x -> false));
        }

        @Test
        void integerSquareRootFloorsTheResult() {
            assertEquals(0, BinarySearch.integerSquareRoot(0));
            assertEquals(1, BinarySearch.integerSquareRoot(3));
            assertEquals(4, BinarySearch.integerSquareRoot(16));
            assertEquals(4, BinarySearch.integerSquareRoot(24));
            assertEquals(46340, BinarySearch.integerSquareRoot(Integer.MAX_VALUE));
        }

        @Test
        void findsAPeak() {
            assertEquals(2, BinarySearch.findPeak(new int[] {1, 2, 3, 1}));
            assertEquals(0, BinarySearch.findPeak(new int[] {5}));
            int peak = BinarySearch.findPeak(new int[] {1, 2, 1, 3, 5, 6, 4});
            assertTrue(peak == 1 || peak == 5, "expected index 1 or 5 but was " + peak);
        }
    }
}
