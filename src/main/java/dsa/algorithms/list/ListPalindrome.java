package dsa.algorithms.list;

import dsa.support.ListNode;

/**
 * Checking a list reads the same both ways, in O(1) space.
 *
 * <p>Copying the values into an array makes this trivial and misses the point.
 * The O(1) version composes two things you have already written: find the
 * middle with {@link FastSlowPointers}, reverse the second half with
 * {@link ReverseList}, then walk the two halves in step.
 *
 * <p>This is the first exercise here that is <em>assembled</em> from earlier
 * ones rather than invented, which is most of what harder list problems are.
 *
 * <p>Target: O(n) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/linked-lists.md} for what to understand first.
 */
public final class ListPalindrome {

    private ListPalindrome() {
    }

    public static boolean isPalindrome(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListPalindrome.isPalindrome");
    }
}
