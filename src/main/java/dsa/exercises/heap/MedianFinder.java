package dsa.exercises.heap;

/**
 * Find Median from Data Stream.
 *
 * <p>Numbers arrive one at a time and the median can be asked for at any
 * point. Sorting on every query is far too slow.
 *
 * <p>Keep two heaps: a max-heap of the smaller half and a min-heap of the
 * larger half. Rebalance after each insert so their sizes differ by at most
 * one, and the median is then either the larger heap's top or the average of
 * both tops.
 *
 * <p>Target complexity: addNumber O(log n), findMedian O(1).
 */
public class MedianFinder {

    public void addNumber(int value) {
        throw new UnsupportedOperationException("TODO: MedianFinder.addNumber");
    }

    /** @throws java.util.NoSuchElementException when nothing has been added. */
    public double findMedian() {
        throw new UnsupportedOperationException("TODO: MedianFinder.findMedian");
    }
}
