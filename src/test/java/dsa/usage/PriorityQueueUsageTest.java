package dsa.usage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class PriorityQueueUsageTest {

    @Test
    void drainsInBothDirections() {
        assertEquals(List.of(1, 2, 3, 5), PriorityQueueUsage.drainAscending(new int[] {3, 1, 5, 2}));
        assertEquals(List.of(5, 3, 2, 1), PriorityQueueUsage.drainDescending(new int[] {3, 1, 5, 2}));
        assertEquals(List.of(), PriorityQueueUsage.drainAscending(new int[] {}));
    }

    @Test
    void handlesExtremeValuesWithoutOverflowing() {
        assertEquals(
                List.of(Integer.MAX_VALUE, 0, Integer.MIN_VALUE),
                PriorityQueueUsage.drainDescending(new int[] {0, Integer.MIN_VALUE, Integer.MAX_VALUE}),
                "a (a - b) comparator overflows here; use Comparator.reverseOrder()");
    }

    @Test
    void picksTheExtremes() {
        assertEquals(List.of(6, 5, 4), PriorityQueueUsage.topK(new int[] {1, 6, 3, 5, 4, 2}, 3));
        assertEquals(List.of(1, 2, 3), PriorityQueueUsage.bottomK(new int[] {1, 6, 3, 5, 4, 2}, 3));
        assertEquals(List.of(), PriorityQueueUsage.topK(new int[] {1, 2}, 0));
    }

    @Test
    void countsDuplicatesSeparatelyInTopK() {
        assertEquals(List.of(7, 7), PriorityQueueUsage.topK(new int[] {7, 7, 1}, 2));
    }

    @Test
    void mergesSortedArrays() {
        assertEquals(
                List.of(1, 1, 2, 3, 4, 4, 5, 6),
                PriorityQueueUsage.mergeSorted(new int[][] {{1, 4, 5}, {1, 3, 4}, {2, 6}}));
        assertEquals(List.of(), PriorityQueueUsage.mergeSorted(new int[][] {}));
        assertEquals(List.of(1, 2), PriorityQueueUsage.mergeSorted(new int[][] {{}, {1, 2}}));
    }

    @Test
    void ordersWordsByLengthThenAlphabetically() {
        assertEquals(
                List.of("question", "that", "not", "be", "to"),
                PriorityQueueUsage.longestWordsFirst(List.of("that", "to", "be", "question", "not")));
    }
}
