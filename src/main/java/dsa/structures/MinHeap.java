package dsa.structures;

/**
 * A binary min-heap over an int array, i.e. your own PriorityQueue.
 *
 * <p>Why it matters: heaps are the engine behind Dijkstra, "top k" problems,
 * merging k sorted lists and streaming medians.
 *
 * <p>Layout: for the node at index {@code i}, children live at {@code 2i + 1}
 * and {@code 2i + 2}, and the parent at {@code (i - 1) / 2}. Restore the heap
 * property by sifting up after a push and sifting down after a pop.
 *
 * <p>Target complexity: push/pop O(log n), peek O(1), heapify O(n).
 */
public class MinHeap {

    private int[] items = new int[8];
    private int size;

    public int size() {
        throw new UnsupportedOperationException("TODO: MinHeap.size");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: MinHeap.isEmpty");
    }

    public void push(int value) {
        throw new UnsupportedOperationException("TODO: MinHeap.push");
    }

    /** Removes and returns the smallest value.
     *
     * @throws java.util.NoSuchElementException when the heap is empty. */
    public int pop() {
        throw new UnsupportedOperationException("TODO: MinHeap.pop");
    }

    /** Smallest value without removing it. */
    public int peek() {
        throw new UnsupportedOperationException("TODO: MinHeap.peek");
    }

    /**
     * Rebuilds the heap from an arbitrary array in O(n) by sifting down from
     * the last internal node backwards. Notably faster than n pushes.
     */
    public void heapify(int[] values) {
        throw new UnsupportedOperationException("TODO: MinHeap.heapify");
    }
}
