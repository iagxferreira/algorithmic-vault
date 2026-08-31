package dsa.algorithms.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import dsa.support.ListNode;
import dsa.support.ListNodes;
import org.junit.jupiter.api.Test;

class FastSlowPointersTest {

    @Test
    void findsTheMiddleOfAnOddLengthList() {
        assertEquals(3, FastSlowPointers.middle(ListNodes.of(1, 2, 3, 4, 5)).val);
        assertEquals(1, FastSlowPointers.middle(ListNodes.of(1)).val);
    }

    @Test
    void evenLengthPicksTheSecondMiddle() {
        assertEquals(4, FastSlowPointers.middle(ListNodes.of(1, 2, 3, 4, 5, 6)).val);
        assertEquals(2, FastSlowPointers.middle(ListNodes.of(1, 2)).val);
    }

    @Test
    void handlesAnEmptyList() {
        assertNull(FastSlowPointers.middle(null));
        assertNull(FastSlowPointers.kthFromEnd(null, 1));
    }

    @Test
    void findsTheKthNodeFromTheEnd() {
        ListNode head = ListNodes.of(1, 2, 3, 4, 5);
        assertEquals(5, FastSlowPointers.kthFromEnd(head, 1).val);
        assertEquals(3, FastSlowPointers.kthFromEnd(head, 3).val);
        assertEquals(1, FastSlowPointers.kthFromEnd(head, 5).val);
    }

    @Test
    void reportsNullWhenKIsTooLarge() {
        ListNode head = ListNodes.of(1, 2, 3);
        assertNull(FastSlowPointers.kthFromEnd(head, 4));
        assertNull(FastSlowPointers.kthFromEnd(head, 0), "k is 1-based");
    }
}
