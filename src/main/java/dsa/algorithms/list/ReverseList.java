package dsa.algorithms.list;

import dsa.support.ListNode;

/**
 * Reversing a list in place - the single most important list exercise.
 *
 * <p>Three pointers: {@code previous}, {@code current}, {@code next}. On each
 * step you save the next node, flip the current link backwards, and shuffle
 * all three forward. Losing {@code next} before you flip is how you drop the
 * rest of the list.
 *
 * <p>Write both versions. The recursive one is shorter but costs O(n) stack;
 * the iterative one is what you actually want, and it is a building block of
 * reorder-list, palindrome checks and k-group reversal.
 *
 * <p>Target: O(n) time, O(1) space iteratively.
 *
 * <p>See {@code docs/algorithms/linked-lists.md} for what to understand first.
 */
public final class ReverseList {

    private ReverseList() {
    }

    /** Reverses with three pointers and returns the new head. */
    public static ListNode reverse(ListNode head) {
        throw new UnsupportedOperationException("TODO: ReverseList.reverse");
    }

    /** Reverses recursively: reverse the tail, then flip one link. */
    public static ListNode reverseRecursive(ListNode head) {
        throw new UnsupportedOperationException("TODO: ReverseList.reverseRecursive");
    }
}
