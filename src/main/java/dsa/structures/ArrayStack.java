package dsa.structures;

/**
 * A LIFO stack over a growable array.
 *
 * <p>Why it matters: stacks drive parentheses matching, monotonic stack
 * problems, iterative DFS and expression evaluation.
 *
 * <p>Target complexity: push O(1) amortised, pop/peek O(1).
 */
public class ArrayStack<T> {

    private static final int DEFAULT_CAPACITY = 8;

    private Object[] items = new Object[DEFAULT_CAPACITY];
    private int size;

    public int size() {
        throw new UnsupportedOperationException("TODO: ArrayStack.size");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: ArrayStack.isEmpty");
    }

    public void push(T item) {
        throw new UnsupportedOperationException("TODO: ArrayStack.push");
    }

    /** @throws java.util.NoSuchElementException when the stack is empty. */
    public T pop() {
        throw new UnsupportedOperationException("TODO: ArrayStack.pop");
    }

    /** Top element without removing it. */
    public T peek() {
        throw new UnsupportedOperationException("TODO: ArrayStack.peek");
    }
}
