package dsa.algorithms.list;

import dsa.support.ListNode;

/**
 * Two pointers moving at different speeds.
 *
 * <p>Send {@code slow} one step at a time and {@code fast} two. When
 * {@code fast} falls off the end, {@code slow} is at the middle - one pass, no
 * length count, no second traversal.
 *
 * <p>The related trick is two pointers at a <b>fixed gap</b>: move one k steps
 * ahead, then advance both together, and when the leader reaches the end the
 * follower is k from it.
 *
 * <p>Target: O(n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/linked-lists.md} for what to understand first.
 */
public final class FastSlowPointers {

    private FastSlowPointers() {
    }

    /**
     * The middle node. With an even number of nodes, return the second of the
     * two middles - decide where to start {@code fast} to get that.
     */
    public static ListNode middle(ListNode head) {
        throw new UnsupportedOperationException("TODO: FastSlowPointers.middle");
    }

    /** The k-th node from the end, where k = 1 is the last node, or null. */
    public static ListNode kthFromEnd(ListNode head, int k) {
        throw new UnsupportedOperationException("TODO: FastSlowPointers.kthFromEnd");
    }
}
