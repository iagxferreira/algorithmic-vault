package dsa.structures;

/**
 * A doubly linked list: every node knows its predecessor as well.
 *
 * <p>Why it matters: O(1) removal of a node you already hold is what makes an
 * LRU cache possible. Sentinel head/tail nodes remove most edge cases.
 *
 * <p>Target complexity: addFirst/addLast/removeFirst/removeLast O(1).
 */
public class DoublyLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.size");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.isEmpty");
    }

    public void addFirst(T value) {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.addFirst");
    }

    public void addLast(T value) {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.addLast");
    }

    public T removeFirst() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.removeFirst");
    }

    public T removeLast() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.removeLast");
    }

    public T peekFirst() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.peekFirst");
    }

    public T peekLast() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.peekLast");
    }

    /** Values from head to tail. */
    public java.util.List<T> toList() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.toList");
    }

    /** Values from tail to head, proving the back links are wired correctly. */
    public java.util.List<T> toReversedList() {
        throw new UnsupportedOperationException("TODO: DoublyLinkedList.toReversedList");
    }
}
