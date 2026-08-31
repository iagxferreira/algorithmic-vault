package dsa.algorithms.list;

import dsa.support.ListNode;
import java.util.List;

/**
 * Walking a singly linked list.
 *
 * <p>A linked list gives you exactly one primitive: follow {@code next}. Start
 * here so the loop shape - {@code for (node = head; node != null; node =
 * node.next)} - stops needing thought before you attempt anything harder.
 *
 * <p>Target: O(n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/linked-lists.md} for what to understand first.
 */
public final class TraverseList {

    private TraverseList() {
    }

    /** Number of nodes; 0 for an empty list. */
    public static int length(ListNode head) {
        throw new UnsupportedOperationException("TODO: TraverseList.length");
    }

    /** Sum of every value. */
    public static int sum(ListNode head) {
        throw new UnsupportedOperationException("TODO: TraverseList.sum");
    }

    /** Values in order, so you can eyeball a chain in a debugger or a test. */
    public static List<Integer> values(ListNode head) {
        throw new UnsupportedOperationException("TODO: TraverseList.values");
    }

    /** The last node, or null when the list is empty. */
    public static ListNode last(ListNode head) {
        throw new UnsupportedOperationException("TODO: TraverseList.last");
    }
}
