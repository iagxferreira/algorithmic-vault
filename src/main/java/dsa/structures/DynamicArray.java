package dsa.structures;

/**
 * A growable array backed by a plain Java array, i.e. your own ArrayList.
 *
 * <p>Why it matters: amortised O(1) append is the reason ArrayList is the
 * default list in practice. Doubling the backing array on overflow is what
 * buys it.
 *
 * <p>Target complexity: get/set O(1), add O(1) amortised, insert/remove O(n).
 */
public class DynamicArray<T> {

    /** Suggested starting capacity for the backing array. */
    private static final int DEFAULT_CAPACITY = 8;

    private Object[] items = new Object[DEFAULT_CAPACITY];
    private int size;

    /** Number of elements currently stored. */
    public int size() {
        throw new UnsupportedOperationException("TODO: DynamicArray.size");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: DynamicArray.isEmpty");
    }

    /** Appends to the end, growing the backing array when it is full. */
    public void add(T item) {
        throw new UnsupportedOperationException("TODO: DynamicArray.add");
    }

    /** Inserts at {@code index}, shifting the tail right. */
    public void insert(int index, T item) {
        throw new UnsupportedOperationException("TODO: DynamicArray.insert");
    }

    /** @throws IndexOutOfBoundsException when index is outside [0, size). */
    public T get(int index) {
        throw new UnsupportedOperationException("TODO: DynamicArray.get");
    }

    /** Replaces the element at {@code index} and returns the previous value. */
    public T set(int index, T item) {
        throw new UnsupportedOperationException("TODO: DynamicArray.set");
    }

    /** Removes the element at {@code index}, shifting the tail left. */
    public T removeAt(int index) {
        throw new UnsupportedOperationException("TODO: DynamicArray.removeAt");
    }

    /** Index of the first element equal to {@code item}, or -1. */
    public int indexOf(T item) {
        throw new UnsupportedOperationException("TODO: DynamicArray.indexOf");
    }
}
