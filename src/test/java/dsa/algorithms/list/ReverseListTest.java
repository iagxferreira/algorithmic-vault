package dsa.algorithms.list;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import dsa.support.ListNode;
import dsa.support.ListNodes;
import org.junit.jupiter.api.Test;

class ReverseListTest {

    @Test
    void reversesIteratively() {
        assertNull(ReverseList.reverse(null));
        assertArrayEquals(new int[] {1}, ListNodes.toArray(ReverseList.reverse(ListNodes.of(1))));
        assertArrayEquals(new int[] {4, 3, 2, 1},
                ListNodes.toArray(ReverseList.reverse(ListNodes.of(1, 2, 3, 4))));
    }

    @Test
    void reversesRecursively() {
        assertNull(ReverseList.reverseRecursive(null));
        assertArrayEquals(new int[] {3, 2, 1},
                ListNodes.toArray(ReverseList.reverseRecursive(ListNodes.of(1, 2, 3))));
    }

    @Test
    void theOldHeadBecomesTheTail() {
        ListNode head = ListNodes.of(1, 2, 3);
        ListNode reversed = ReverseList.reverse(head);
        assertEquals(3, ListNodes.size(reversed), "the old head must now point at null");
        assertNull(head.next, "the original head is the new tail");
    }

    @Test
    void bothVersionsAgree() {
        assertArrayEquals(
                ListNodes.toArray(ReverseList.reverse(ListNodes.of(5, 4, 3, 2, 1))),
                ListNodes.toArray(ReverseList.reverseRecursive(ListNodes.of(5, 4, 3, 2, 1))));
    }
}
