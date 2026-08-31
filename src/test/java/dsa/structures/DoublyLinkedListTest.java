package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    void startsEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
    }

    @Test
    void addsAtBothEnds() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addFirst(1);
        assertEquals(List.of(1, 2, 3), list.toList());
        assertEquals(1, list.peekFirst());
        assertEquals(3, list.peekLast());
    }

    @Test
    void removesFromBothEnds() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(1, list.removeFirst());
        assertEquals(3, list.removeLast());
        assertEquals(List.of(2), list.toList());
    }

    @Test
    void backLinksAreWiredBothWays() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(List.of(3, 2, 1), list.toReversedList());
    }

    @Test
    void emptyingAndRefillingKeepsBothEndsConsistent() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.removeLast();
        list.addLast(2);
        assertEquals(List.of(2), list.toList());
        assertEquals(List.of(2), list.toReversedList());
        assertEquals(2, list.peekFirst());
        assertEquals(2, list.peekLast());
    }
}
