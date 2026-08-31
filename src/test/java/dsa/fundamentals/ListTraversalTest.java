package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.ListNode;
import dsa.support.ListNodes;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ListTraversalTest {

    @Nested
    class Walking {

        @Test
        void measuresAndSums() {
            assertEquals(0, ListTraversal.length(null));
            assertEquals(0, ListTraversal.sum(null));
            assertEquals(4, ListTraversal.length(ListNodes.of(1, 2, 3, 4)));
            assertEquals(10, ListTraversal.sum(ListNodes.of(1, 2, 3, 4)));
        }

        @Test
        void collectsValuesInOrder() {
            assertEquals(List.of(), ListTraversal.values(null));
            assertEquals(List.of(1, 2, 3), ListTraversal.values(ListNodes.of(1, 2, 3)));
        }

        @Test
        void findsTheMiddleNode() {
            assertNull(ListTraversal.middle(null));
            assertEquals(1, ListTraversal.middle(ListNodes.of(1)).val);
            assertEquals(3, ListTraversal.middle(ListNodes.of(1, 2, 3, 4, 5)).val);
            assertEquals(4, ListTraversal.middle(ListNodes.of(1, 2, 3, 4, 5, 6)).val, "even length picks the second middle");
        }

        @Test
        void findsTheKthNodeFromTheEnd() {
            ListNode head = ListNodes.of(1, 2, 3, 4, 5);
            assertEquals(5, ListTraversal.kthFromEnd(head, 1).val);
            assertEquals(3, ListTraversal.kthFromEnd(head, 3).val);
            assertEquals(1, ListTraversal.kthFromEnd(head, 5).val);
            assertNull(ListTraversal.kthFromEnd(head, 6));
        }
    }

    @Nested
    class Reversing {

        @Test
        void reversesIteratively() {
            assertNull(ListTraversal.reverse(null));
            assertArrayEquals(new int[] {1}, ListNodes.toArray(ListTraversal.reverse(ListNodes.of(1))));
            assertArrayEquals(new int[] {4, 3, 2, 1}, ListNodes.toArray(ListTraversal.reverse(ListNodes.of(1, 2, 3, 4))));
        }

        @Test
        void reversesRecursively() {
            assertNull(ListTraversal.reverseRecursive(null));
            assertArrayEquals(new int[] {3, 2, 1}, ListNodes.toArray(ListTraversal.reverseRecursive(ListNodes.of(1, 2, 3))));
        }

        @Test
        void reversedListEndsProperly() {
            ListNode reversed = ListTraversal.reverse(ListNodes.of(1, 2, 3));
            assertEquals(3, ListNodes.size(reversed), "old head must now point at null");
        }
    }

    @Nested
    class Cycles {

        @Test
        void detectsAnAcyclicList() {
            assertFalse(ListTraversal.hasCycle(null));
            assertFalse(ListTraversal.hasCycle(ListNodes.of(1, 2, 3)));
            assertNull(ListTraversal.cycleStart(ListNodes.of(1, 2, 3)));
        }

        @Test
        void detectsACycle() {
            ListNode head = ListNodes.withCycleAt(ListNodes.of(1, 2, 3, 4), 1);
            assertTrue(ListTraversal.hasCycle(head));
            assertEquals(2, ListTraversal.cycleStart(head).val);
        }

        @Test
        void detectsASelfLoop() {
            ListNode head = ListNodes.withCycleAt(ListNodes.of(1), 0);
            assertTrue(ListTraversal.hasCycle(head));
            assertEquals(1, ListTraversal.cycleStart(head).val);
        }
    }

    @Nested
    class Palindromes {

        @Test
        void acceptsPalindromes() {
            assertTrue(ListTraversal.isPalindrome(null));
            assertTrue(ListTraversal.isPalindrome(ListNodes.of(1)));
            assertTrue(ListTraversal.isPalindrome(ListNodes.of(1, 2, 1)));
            assertTrue(ListTraversal.isPalindrome(ListNodes.of(1, 2, 2, 1)));
        }

        @Test
        void rejectsNonPalindromes() {
            assertFalse(ListTraversal.isPalindrome(ListNodes.of(1, 2)));
            assertFalse(ListTraversal.isPalindrome(ListNodes.of(1, 2, 3, 1)));
        }
    }
}
