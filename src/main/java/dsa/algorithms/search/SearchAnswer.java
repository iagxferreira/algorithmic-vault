package dsa.algorithms.search;

import java.util.function.IntPredicate;

/**
 * Binary search over the answer space instead of over an array.
 *
 * <p>The most valuable idea in this package, and the least obvious. You are
 * not searching a collection: you are searching the range of possible answers,
 * and the only thing you need is a <b>monotonic</b> feasibility test - once
 * something is true it stays true.
 *
 * <p>"Minimum speed to finish in time", "smallest capacity that fits", "least
 * time until the path opens" are all this function plus a feasibility check.
 *
 * <p>Target: O(log range) calls to the predicate.
 *
 * <p>See {@code docs/algorithms/binary-search.md} for what to understand first.
 */
public final class SearchAnswer {

    private SearchAnswer() {
    }

    /**
     * The smallest value in {@code [low, high]} for which {@code predicate} is
     * true, or {@code high + 1} when it never is.
     *
     * <p>{@code predicate} must be monotonic: false, false, ..., true, true.
     */
    public static int firstTrue(int low, int high, IntPredicate predicate) {
        throw new UnsupportedOperationException("TODO: SearchAnswer.firstTrue");
    }

    /**
     * The largest value in {@code [low, high]} for which {@code predicate} is
     * true, or {@code low - 1} when it never is. The mirror image, and worth
     * writing so you can see where the two differ.
     */
    public static int lastTrue(int low, int high, IntPredicate predicate) {
        throw new UnsupportedOperationException("TODO: SearchAnswer.lastTrue");
    }

    /**
     * Integer square root: the largest x with {@code x * x <= n}. A small,
     * self-contained instance of searching an answer space.
     */
    public static int integerSquareRoot(int n) {
        throw new UnsupportedOperationException("TODO: SearchAnswer.integerSquareRoot");
    }
}
