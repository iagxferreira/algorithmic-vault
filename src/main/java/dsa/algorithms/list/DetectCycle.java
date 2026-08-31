package dsa.algorithms.list;

import dsa.support.ListNode;

/**
 * Floyd's tortoise and hare.
 *
 * <p>If the list loops, a pointer moving two steps per tick must eventually
 * lap one moving a single step, so they meet. If it does not loop, the fast
 * one runs off the end. That is the whole detection argument, and it costs
 * O(1) memory where a visited-set costs O(n).
 *
 * <p>Finding the cycle's <b>entrance</b> is the surprising part: after the
 * two meet, restart one pointer at the head and advance both one step at a
 * time. They meet again exactly at the entrance. Derive why before you code
 * it - the algebra is short and it is the reason this is worth knowing.
 *
 * <p>Target: O(n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/linked-lists.md} for what to understand first.
 */
public final class DetectCycle {

    private DetectCycle() {
    }

    /** True when the chain loops. */
    public static boolean hasCycle(ListNode head) {
        throw new UnsupportedOperationException("TODO: DetectCycle.hasCycle");
    }

    /** First node of the cycle, or null when the list is acyclic. */
    public static ListNode cycleStart(ListNode head) {
        throw new UnsupportedOperationException("TODO: DetectCycle.cycleStart");
    }

    /** Number of nodes in the cycle, or 0 when there is none. */
    public static int cycleLength(ListNode head) {
        throw new UnsupportedOperationException("TODO: DetectCycle.cycleLength");
    }
}
