package dsa.fundamentals;

import dsa.support.ListNode;
import java.util.List;

/**
 * Walking, measuring and rewiring a singly linked list.
 *
 * <p>Why it matters: a linked list gives you exactly one primitive, "follow
 * next", so every question becomes a pointer discipline exercise. Two patterns
 * cover most of them:
 *
 * <ul>
 *   <li><b>Two pointers at different speeds</b> - a slow pointer moving one
 *       step and a fast one moving two finds the middle in a single pass, and
 *       detects a cycle (Floyd's tortoise and hare).
 *   <li><b>Two pointers at a fixed gap</b> - move one pointer k ahead, then
 *       advance both; when the leader falls off the end the follower sits on
 *       the k-th node from the end.
 * </ul>
 *
 * <p>Target complexity: O(n) time and O(1) space for all of these, except
 * where a method explicitly asks for recursion.
 */
public final class ListTraversal {

    private ListTraversal() {
    }

    /** Number of nodes. */
    public static int length(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.length");
    }

    /** Sum of every value. */
    public static int sum(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.sum");
    }

    /** Values in order, so you can eyeball a chain. */
    public static List<Integer> values(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.values");
    }

    /**
     * Reverses the chain iteratively with three pointers (previous, current,
     * next) and returns the new head. The classic one-pass rewiring.
     */
    public static ListNode reverse(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.reverse");
    }

    /**
     * Reverses recursively: reverse the tail, then flip the link between the
     * head and the node after it. O(n) stack space, which is the trade-off.
     */
    public static ListNode reverseRecursive(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.reverseRecursive");
    }

    /**
     * Middle node via slow and fast pointers. With an even number of nodes,
     * return the second of the two middles.
     */
    public static ListNode middle(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.middle");
    }

    /** The k-th node from the end (k = 1 is the last node), or null. */
    public static ListNode kthFromEnd(ListNode head, int k) {
        throw new UnsupportedOperationException("TODO: ListTraversal.kthFromEnd");
    }

    /** True when the chain loops, detected in O(1) space. */
    public static boolean hasCycle(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.hasCycle");
    }

    /**
     * First node of the cycle, or null when the list is acyclic. After the
     * pointers meet, restart one from the head and advance both one step at a
     * time; they meet at the entry point.
     */
    public static ListNode cycleStart(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.cycleStart");
    }

    /** True when the values read the same forwards and backwards, in O(1) space. */
    public static boolean isPalindrome(ListNode head) {
        throw new UnsupportedOperationException("TODO: ListTraversal.isPalindrome");
    }
}
