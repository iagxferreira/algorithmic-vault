package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrefixSumsTest {

    @Nested
    class OneDimension {

        @Test
        void buildsAnExclusivePrefixArray() {
            assertArrayEquals(new int[] {0, 1, 3, 6, 10}, PrefixSums.build(new int[] {1, 2, 3, 4}));
            assertArrayEquals(new int[] {0}, PrefixSums.build(new int[] {}));
        }

        @Test
        void answersRangeSums() {
            int[] prefix = PrefixSums.build(new int[] {1, 2, 3, 4, 5});
            assertEquals(15, PrefixSums.rangeSum(prefix, 0, 4));
            assertEquals(9, PrefixSums.rangeSum(prefix, 1, 3));
            assertEquals(3, PrefixSums.rangeSum(prefix, 2, 2));
        }
    }

    @Nested
    class TwoDimensions {

        private final int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        @Test
        void answersRectangleSums() {
            int[][] prefix = PrefixSums.build2d(grid);
            assertEquals(45, PrefixSums.rangeSum2d(prefix, 0, 0, 2, 2));
            assertEquals(24, PrefixSums.rangeSum2d(prefix, 1, 0, 2, 1));
            assertEquals(5, PrefixSums.rangeSum2d(prefix, 1, 1, 1, 1));
        }

        @Test
        void prefixArrayIsPaddedByOne() {
            int[][] prefix = PrefixSums.build2d(grid);
            assertEquals(4, prefix.length);
            assertEquals(4, prefix[0].length);
            assertEquals(0, prefix[0][0]);
        }
    }

    @Nested
    class DifferenceArray {

        @Test
        void appliesOverlappingRangeUpdates() {
            int[][] updates = {{0, 2, 1}, {1, 3, 2}};
            assertArrayEquals(new int[] {1, 3, 3, 2, 0}, PrefixSums.applyRangeUpdates(5, updates));
        }

        @Test
        void handlesNoUpdates() {
            assertArrayEquals(new int[] {0, 0, 0}, PrefixSums.applyRangeUpdates(3, new int[][] {}));
        }
    }

    @Nested
    class Counting {

        @Test
        void countsSubarraysWithAGivenSum() {
            assertEquals(2, PrefixSums.countSubarraysWithSum(new int[] {1, 1, 1}, 2));
            assertEquals(2, PrefixSums.countSubarraysWithSum(new int[] {1, 2, 3}, 3));
            assertEquals(0, PrefixSums.countSubarraysWithSum(new int[] {1, 2, 3}, 7));
        }

        @Test
        void handlesNegativesAndZeroSums() {
            assertEquals(4, PrefixSums.countSubarraysWithSum(new int[] {1, -1, 1, -1}, 0));
        }
    }
}
