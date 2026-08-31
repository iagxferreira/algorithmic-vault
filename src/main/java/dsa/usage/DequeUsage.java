package dsa.usage;

import java.util.List;

/**
 * Driving {@link java.util.Deque} the easy way.
 *
 * <p>The JDK version of the {@link dsa.structures.ArrayStack} and
 * {@link dsa.structures.CircularQueue} you built - and it is both at once.
 * {@code ArrayDeque} is the right default for a stack <em>and</em> for a
 * queue: it beats the legacy {@code Stack} (synchronised) and
 * {@code LinkedList} (a node allocation per element) on both.
 *
 * <p>Two naming families do the same work with different failure modes.
 * {@code addFirst}/{@code removeFirst} throw on an empty deque;
 * {@code offerFirst}/{@code pollFirst} return {@code false}/{@code null}
 * instead. Pick one family and stay in it.
 *
 * <p>The stack aliases are the confusing part: {@code push} is
 * {@code addFirst} and {@code pop} is {@code removeFirst}, so a deque used as
 * a stack grows at the <b>front</b>. Iterating it therefore walks from the top
 * of the stack down.
 */
public final class DequeUsage {

    private DequeUsage() {
    }

    /** Pushes each value, then pops everything. The result is the reversed input. */
    public static List<Integer> pushThenPopAll(int[] values) {
        throw new UnsupportedOperationException("TODO: DequeUsage.pushThenPopAll");
    }

    /** Enqueues each value, then dequeues everything. The result matches the input order. */
    public static List<Integer> enqueueThenDequeueAll(int[] values) {
        throw new UnsupportedOperationException("TODO: DequeUsage.enqueueThenDequeueAll");
    }

    /** The text reversed, by pushing its characters and popping them back off. */
    public static String reverse(String text) {
        throw new UnsupportedOperationException("TODO: DequeUsage.reverse");
    }

    /**
     * Reads values from alternating ends, front first, until the deque is
     * empty. For {@code [1,2,3,4]} that is {@code [1,4,2,3]}.
     */
    public static List<Integer> drainAlternatingEnds(int[] values) {
        throw new UnsupportedOperationException("TODO: DequeUsage.drainAlternatingEnds");
    }

    /**
     * True when the values read the same from both ends, comparing a value
     * taken from the front against one taken from the back until they meet.
     */
    public static boolean isPalindrome(int[] values) {
        throw new UnsupportedOperationException("TODO: DequeUsage.isPalindrome");
    }

    /**
     * Keeps only the most recent {@code capacity} values, dropping the oldest
     * when full. A bounded history buffer in a handful of lines.
     */
    public static List<Integer> lastN(int[] values, int capacity) {
        throw new UnsupportedOperationException("TODO: DequeUsage.lastN");
    }
}
