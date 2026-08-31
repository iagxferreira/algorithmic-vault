package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SortingTest {

    private static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> sorters() {
        return java.util.stream.Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("bubble", (UnaryOperator<int[]>) Sorting::bubbleSort),
                org.junit.jupiter.params.provider.Arguments.of("selection", (UnaryOperator<int[]>) Sorting::selectionSort),
                org.junit.jupiter.params.provider.Arguments.of("insertion", (UnaryOperator<int[]>) Sorting::insertionSort),
                org.junit.jupiter.params.provider.Arguments.of("merge", (UnaryOperator<int[]>) Sorting::mergeSort),
                org.junit.jupiter.params.provider.Arguments.of("quick", (UnaryOperator<int[]>) Sorting::quickSort),
                org.junit.jupiter.params.provider.Arguments.of("heap", (UnaryOperator<int[]>) Sorting::heapSort));
    }

    @ParameterizedTest(name = "{0}Sort")
    @MethodSource("sorters")
    void sortsTheUsualShapes(String name, UnaryOperator<int[]> sort) {
        assertArrayEquals(new int[] {}, sort.apply(new int[] {}));
        assertArrayEquals(new int[] {1}, sort.apply(new int[] {1}));
        assertArrayEquals(new int[] {1, 2, 3}, sort.apply(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {1, 2, 3}, sort.apply(new int[] {3, 2, 1}));
        assertArrayEquals(new int[] {2, 2, 2}, sort.apply(new int[] {2, 2, 2}));
        assertArrayEquals(new int[] {-5, -1, 0, 3}, sort.apply(new int[] {3, -1, -5, 0}));
    }

    @ParameterizedTest(name = "{0}Sort")
    @MethodSource("sorters")
    void matchesTheJdkOnRandomInput(String name, UnaryOperator<int[]> sort) {
        Random random = new Random(42);
        for (int round = 0; round < 20; round++) {
            int[] values = random.ints(random.nextInt(60), -100, 100).toArray();
            int[] expected = values.clone();
            Arrays.sort(expected);
            assertArrayEquals(expected, sort.apply(values.clone()));
        }
    }

    @Test
    void countingSortHandlesTheRestrictedRange() {
        assertArrayEquals(new int[] {0, 2, 3, 3, 9}, Sorting.countingSort(new int[] {3, 9, 0, 3, 2}));
        assertArrayEquals(new int[] {}, Sorting.countingSort(new int[] {}));
        assertArrayEquals(new int[] {1000}, Sorting.countingSort(new int[] {1000}));
    }

    @Nested
    class Partitioning {

        @Test
        void partitionPutsSmallerValuesLeftOfThePivot() {
            int[] values = {5, 2, 9, 1, 7};
            int pivotIndex = Sorting.partition(values, 0, values.length - 1);
            int pivot = values[pivotIndex];
            for (int i = 0; i < pivotIndex; i++) {
                assertTrue(values[i] <= pivot, "left side must be <= pivot");
            }
            for (int i = pivotIndex + 1; i < values.length; i++) {
                assertTrue(values[i] >= pivot, "right side must be >= pivot");
            }
        }

        @Test
        void quickSelectFindsTheKthSmallest() {
            assertEquals(1, Sorting.quickSelect(new int[] {5, 2, 9, 1, 7}, 0));
            assertEquals(5, Sorting.quickSelect(new int[] {5, 2, 9, 1, 7}, 2));
            assertEquals(9, Sorting.quickSelect(new int[] {5, 2, 9, 1, 7}, 4));
        }

        @Test
        void quickSelectHandlesDuplicates() {
            assertEquals(2, Sorting.quickSelect(new int[] {2, 2, 2, 2}, 3));
        }
    }

    @Nested
    class Inversions {

        @Test
        void sortedInputHasNone() {
            assertEquals(0L, Sorting.countInversions(new int[] {1, 2, 3, 4}));
        }

        @Test
        void reversedInputHasEveryPair() {
            assertEquals(6L, Sorting.countInversions(new int[] {4, 3, 2, 1}));
        }

        @Test
        void countsMixedInput() {
            assertEquals(3L, Sorting.countInversions(new int[] {2, 4, 1, 3, 5}));
        }
    }
}
