package dsa.structures;

/**
 * A singly linked list you build from scratch, with a head and a tail pointer.
 *
 * <p>Why it matters: every list exercise (reversal, cycle detection, merging)
 * is pointer rewiring. Get comfortable here first.
 *
 * <p>Target complexity: addFirst/addLast/removeFirst O(1), get/removeLast O(n).
 */
public class SinglyLinkedList<T> implements Iterable<T> {

    /** Internal node; nothing outside this class should see it. */
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.size");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.isEmpty");
    }

    public void addFirst(T value) {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.addFirst");
    }

    public void addLast(T value) {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.addLast");
    }

    /** Removes and returns the head value, or null when empty. */
    public T removeFirst() {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.removeFirst");
    }

    /** Removes and returns the tail value, or null when empty. */
    public T removeLast() {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.removeLast");
    }

    public T get(int index) {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.get");
    }

    public boolean contains(T value) {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.contains");
    }

    /** Reverses the list in place, in a single pass, without allocating nodes. */
    public void reverse() {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.reverse");
    }

    /** Left to right iteration over the stored values. */
    @Override
    public java.util.Iterator<T> iterator() {
        throw new UnsupportedOperationException("TODO: SinglyLinkedList.iterator");
    }
}
