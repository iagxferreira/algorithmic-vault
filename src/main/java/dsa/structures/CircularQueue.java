package dsa.structures;

/**
 * A FIFO queue over a fixed size ring buffer.
 *
 * <p>Why it matters: BFS is a queue with extra steps. A ring buffer keeps
 * enqueue and dequeue at O(1) without ever shifting elements.
 *
 * <p>Hint: track {@code head} and {@code size}; the tail slot is
 * {@code (head + size) % capacity}.
 *
 * <p>Target complexity: enqueue/dequeue/peek O(1).
 */
public class CircularQueue<T> {

    private final Object[] items;
    private int head;
    private int size;

    public CircularQueue(int capacity) {
        this.items = new Object[capacity];
    }

    public int size() {
        throw new UnsupportedOperationException("TODO: CircularQueue.size");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: CircularQueue.isEmpty");
    }

    public boolean isFull() {
        throw new UnsupportedOperationException("TODO: CircularQueue.isFull");
    }

    /** @return false when the queue is already full. */
    public boolean enqueue(T item) {
        throw new UnsupportedOperationException("TODO: CircularQueue.enqueue");
    }

    /** @return the oldest element, or null when empty. */
    public T dequeue() {
        throw new UnsupportedOperationException("TODO: CircularQueue.dequeue");
    }

    /** Oldest element without removing it, or null when empty. */
    public T peek() {
        throw new UnsupportedOperationException("TODO: CircularQueue.peek");
    }
}
