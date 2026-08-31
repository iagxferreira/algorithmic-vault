package dsa.exercises.heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HeapExercisesTest {

    @Nested
    class KthLargestElementTest {

        @Test
        void countsFromTheTop() {
            assertEquals(5, KthLargestElement.solve(new int[] {3, 2, 1, 5, 6, 4}, 2));
            assertEquals(4, KthLargestElement.solve(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        }

        @Test
        void countsDuplicatesSeparately() {
            assertEquals(2, KthLargestElement.solve(new int[] {2, 2, 2}, 3));
            assertEquals(1, KthLargestElement.solve(new int[] {1}, 1));
        }
    }

    @Nested
    class KClosestPointsToOriginTest {

        @Test
        void picksTheNearestPoints() {
            assertArrayEquals(
                    new int[][] {{-2, 2}},
                    KClosestPointsToOrigin.solve(new int[][] {{1, 3}, {-2, 2}}, 1));
            assertArrayEquals(
                    new int[][] {{3, 3}, {-2, 4}},
                    KClosestPointsToOrigin.solve(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2));
        }

        @Test
        void handlesTiesAndKCoveringEverything() {
            assertArrayEquals(
                    new int[][] {{-1, 0}, {0, 1}, {1, 0}},
                    KClosestPointsToOrigin.solve(new int[][] {{1, 0}, {0, 1}, {-1, 0}}, 3));
        }
    }

    @Nested
    class LastStoneWeightTest {

        @Test
        void simulatesTheSmashing() {
            assertEquals(1, LastStoneWeight.solve(new int[] {2, 7, 4, 1, 8, 1}));
            assertEquals(1, LastStoneWeight.solve(new int[] {1}));
        }

        @Test
        void returnsZeroWhenEverythingCancels() {
            assertEquals(0, LastStoneWeight.solve(new int[] {2, 2}));
            assertEquals(0, LastStoneWeight.solve(new int[] {}));
        }
    }

    @Nested
    class TaskSchedulerTest {

        @Test
        void insertsIdleUnits() {
            assertEquals(8, TaskScheduler.solve(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
            assertEquals(16, TaskScheduler.solve(new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
        }

        @Test
        void needsNoIdleWhenThereIsEnoughVariety() {
            assertEquals(6, TaskScheduler.solve(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 0));
            assertEquals(6, TaskScheduler.solve(new char[] {'A', 'B', 'C', 'D', 'E', 'F'}, 2));
        }
    }

    @Nested
    class MedianFinderTest {

        @Test
        void tracksTheMedianAsNumbersArrive() {
            MedianFinder finder = new MedianFinder();
            finder.addNumber(1);
            assertEquals(1.0, finder.findMedian());
            finder.addNumber(2);
            assertEquals(1.5, finder.findMedian());
            finder.addNumber(3);
            assertEquals(2.0, finder.findMedian());
        }

        @Test
        void handlesUnsortedArrivalAndNegatives() {
            MedianFinder finder = new MedianFinder();
            for (int value : new int[] {5, -1, 3, 8, 0}) {
                finder.addNumber(value);
            }
            assertEquals(3.0, finder.findMedian());
            finder.addNumber(4);
            assertEquals(3.5, finder.findMedian());
        }

        @Test
        void failsBeforeAnythingIsAdded() {
            assertThrows(NoSuchElementException.class, () -> new MedianFinder().findMedian());
        }
    }
}
