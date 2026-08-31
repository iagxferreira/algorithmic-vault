package dsa.usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class DequeUsageTest {

    @Test
    void usedAsAStackItReverses() {
        assertEquals(List.of(3, 2, 1), DequeUsage.pushThenPopAll(new int[] {1, 2, 3}));
        assertEquals(List.of(), DequeUsage.pushThenPopAll(new int[] {}));
    }

    @Test
    void usedAsAQueueItPreservesOrder() {
        assertEquals(List.of(1, 2, 3), DequeUsage.enqueueThenDequeueAll(new int[] {1, 2, 3}));
        assertEquals(List.of(), DequeUsage.enqueueThenDequeueAll(new int[] {}));
    }

    @Test
    void reversesAString() {
        assertEquals("cba", DequeUsage.reverse("abc"));
        assertEquals("", DequeUsage.reverse(""));
        assertEquals("a", DequeUsage.reverse("a"));
    }

    @Test
    void drainsFromAlternatingEnds() {
        assertEquals(List.of(1, 4, 2, 3), DequeUsage.drainAlternatingEnds(new int[] {1, 2, 3, 4}));
        assertEquals(List.of(1, 5, 2, 4, 3), DequeUsage.drainAlternatingEnds(new int[] {1, 2, 3, 4, 5}));
        assertEquals(List.of(1), DequeUsage.drainAlternatingEnds(new int[] {1}));
    }

    @Test
    void checksPalindromesFromBothEnds() {
        assertTrue(DequeUsage.isPalindrome(new int[] {1, 2, 1}));
        assertTrue(DequeUsage.isPalindrome(new int[] {1, 2, 2, 1}));
        assertTrue(DequeUsage.isPalindrome(new int[] {}));
        assertFalse(DequeUsage.isPalindrome(new int[] {1, 2, 3}));
    }

    @Test
    void keepsOnlyTheMostRecentValues() {
        assertEquals(List.of(3, 4, 5), DequeUsage.lastN(new int[] {1, 2, 3, 4, 5}, 3));
        assertEquals(List.of(1, 2), DequeUsage.lastN(new int[] {1, 2}, 5));
        assertEquals(List.of(), DequeUsage.lastN(new int[] {1, 2}, 0));
    }
}
