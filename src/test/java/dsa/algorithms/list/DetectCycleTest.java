package dsa.algorithms.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.ListNode;
import dsa.support.ListNodes;
import org.junit.jupiter.api.Test;

class DetectCycleTest {

    @Test
    void acyclicListsHaveNoCycle() {
        assertFalse(DetectCycle.hasCycle(null));
        assertFalse(DetectCycle.hasCycle(ListNodes.of(1)));
        assertFalse(DetectCycle.hasCycle(ListNodes.of(1, 2, 3)));
        assertNull(DetectCycle.cycleStart(ListNodes.of(1, 2, 3)));
        assertEquals(0, DetectCycle.cycleLength(ListNodes.of(1, 2, 3)));
    }

    @Test
    void findsACycleAndItsEntrance() {
        ListNode head = ListNodes.withCycleAt(ListNodes.of(1, 2, 3, 4), 1);
        assertTrue(DetectCycle.hasCycle(head));
        assertEquals(2, DetectCycle.cycleStart(head).val);
        assertEquals(3, DetectCycle.cycleLength(head));
    }

    @Test
    void handlesASelfLoop() {
        ListNode head = ListNodes.withCycleAt(ListNodes.of(1), 0);
        assertTrue(DetectCycle.hasCycle(head));
        assertEquals(1, DetectCycle.cycleStart(head).val);
        assertEquals(1, DetectCycle.cycleLength(head));
    }

    @Test
    void handlesAWholeListLoopingBackToTheHead() {
        ListNode head = ListNodes.withCycleAt(ListNodes.of(1, 2, 3), 0);
        assertTrue(DetectCycle.hasCycle(head));
        assertEquals(1, DetectCycle.cycleStart(head).val);
        assertEquals(3, DetectCycle.cycleLength(head));
    }
}
