package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    private static SinglyLinkedList<Integer> listOf(int... values) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int value : values) {
            list.addLast(value);
        }
        return list;
    }

    private static List<Integer> drain(SinglyLinkedList<Integer> list) {
        List<Integer> out = new ArrayList<>();
        list.forEach(out::add);
        return out;
    }

    @Test
    void startsEmpty() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertNull(list.removeFirst());
    }

    @Test
    void addFirstPrepends() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        assertEquals(List.of(1, 2), drain(list));
    }

    @Test
    void addLastAppends() {
        assertEquals(List.of(1, 2, 3), drain(listOf(1, 2, 3)));
    }

    @Test
    void removesFromBothEnds() {
        SinglyLinkedList<Integer> list = listOf(1, 2, 3);
        assertEquals(1, list.removeFirst());
        assertEquals(3, list.removeLast());
        assertEquals(1, list.size());
        assertEquals(List.of(2), drain(list));
    }

    @Test
    void getReadsByIndex() {
        SinglyLinkedList<Integer> list = listOf(10, 20, 30);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(2));
    }

    @Test
    void containsScansTheChain() {
        SinglyLinkedList<Integer> list = listOf(1, 2, 3);
        assertTrue(list.contains(2));
        assertFalse(list.contains(9));
    }

    @Test
    void reverseFlipsTheChainInPlace() {
        SinglyLinkedList<Integer> list = listOf(1, 2, 3, 4);
        list.reverse();
        assertEquals(List.of(4, 3, 2, 1), drain(list));
    }

    @Test
    void reverseKeepsAppendingCorrect() {
        SinglyLinkedList<Integer> list = listOf(1, 2, 3);
        list.reverse();
        list.addLast(0);
        assertEquals(List.of(3, 2, 1, 0), drain(list));
    }
}
