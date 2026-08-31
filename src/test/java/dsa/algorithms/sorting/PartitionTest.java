package dsa.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PartitionTest {

    private static void assertPartitioned(int[] values) {
        int[] before = values.clone();
        int p = Partition.partition(values, 0, values.length - 1);
        assertTrue(p >= 0 && p < values.length, "pivot index out of range: " + p);
        for (int i = 0; i < p; i++) {
            assertTrue(values[i] <= values[p], "left of pivot must be <= it: " + Arrays.toString(values));
        }
        for (int i = p + 1; i < values.length; i++) {
            assertTrue(values[i] >= values[p], "right of pivot must be >= it: " + Arrays.toString(values));
        }
        int[] sortedBefore = before.clone();
        int[] sortedAfter = values.clone();
        Arrays.sort(sortedBefore);
        Arrays.sort(sortedAfter);
        assertArrayEqualsMessage(sortedBefore, sortedAfter);
    }

    private static void assertArrayEqualsMessage(int[] expected, int[] actual) {
        assertEquals(Arrays.toString(expected), Arrays.toString(actual),
                "partition must permute the array, not change its contents");
    }

    @Test
    void splitsAroundThePivot() {
        assertPartitioned(new int[] {5, 2, 9, 1, 7});
        assertPartitioned(new int[] {1, 2, 3, 4, 5});
        assertPartitioned(new int[] {5, 4, 3, 2, 1});
    }

    @Test
    void handlesDuplicatesAndTinyRanges() {
        assertPartitioned(new int[] {2, 2, 2, 2});
        assertPartitioned(new int[] {1});
        assertPartitioned(new int[] {2, 1});
    }

    @Test
    void reportsTheIndexTheHighElementLandedOn() {
        int[] values = {1, 2, 3};
        assertEquals(2, Partition.partition(values, 0, 2), "pivot 3 is already the largest");
    }
}
