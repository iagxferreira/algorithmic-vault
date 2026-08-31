package dsa.usage;

import java.util.List;

/**
 * Driving {@link java.util.PriorityQueue} the easy way.
 *
 * <p>The JDK version of the {@link dsa.structures.MinHeap} you built.
 *
 * <p><b>It is a min-heap by default</b>, which is the opposite of C++'s
 * {@code priority_queue}. For a max-heap pass {@code Comparator.reverseOrder()}
 * or {@code (a, b) -> b - a} - and prefer the former, because the subtraction
 * form overflows on extreme values.
 *
 * <p>Two more things that surprise people: {@code peek}/{@code poll} are the
 * only ordered operations, so iterating or printing a {@code PriorityQueue}
 * gives you heap order, <b>not</b> sorted order. And {@code remove(Object)} is
 * O(n), not O(log n), because it has to find the element first.
 */
public final class PriorityQueueUsage {

    private PriorityQueueUsage() {
    }

    /** Every value, drained smallest first. */
    public static List<Integer> drainAscending(int[] values) {
        throw new UnsupportedOperationException("TODO: PriorityQueueUsage.drainAscending");
    }

    /** Every value, drained largest first. */
    public static List<Integer> drainDescending(int[] values) {
        throw new UnsupportedOperationException("TODO: PriorityQueueUsage.drainDescending");
    }

    /**
     * The {@code k} largest values, descending. Keep the heap at size k and
     * evict, so the memory is O(k) rather than O(n).
     */
    public static List<Integer> topK(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: PriorityQueueUsage.topK");
    }

    /** The {@code k} smallest values, ascending. */
    public static List<Integer> bottomK(int[] values, int k) {
        throw new UnsupportedOperationException("TODO: PriorityQueueUsage.bottomK");
    }

    /** Merges already-sorted arrays into one ascending list, using a heap. */
    public static List<Integer> mergeSorted(int[][] sortedArrays) {
        throw new UnsupportedOperationException("TODO: PriorityQueueUsage.mergeSorted");
    }

    /** Words ordered by length, longest first, and alphabetically within a length. */
    public static List<String> longestWordsFirst(List<String> words) {
        throw new UnsupportedOperationException("TODO: PriorityQueueUsage.longestWordsFirst");
    }
}
