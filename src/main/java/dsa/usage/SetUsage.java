package dsa.usage;

import java.util.List;
import java.util.Set;

/**
 * Driving {@link java.util.Set} the easy way.
 *
 * <p>A set is a map with the values thrown away, so it answers exactly one
 * question - "have I seen this?" - in O(1). That single question is what turns
 * a nested-loop scan into a single pass.
 *
 * <p>Pick the implementation by the order you need: {@code HashSet} for none,
 * {@code LinkedHashSet} for insertion order, {@code TreeSet} for sorted order.
 * A {@code TreeSet} also gives you {@code first}, {@code last},
 * {@code floor} and {@code ceiling}, which is a small ordered structure for
 * free.
 *
 * <p>The bulk operations {@code retainAll}, {@code removeAll} and
 * {@code addAll} mutate the receiver. Copy first when the input must survive.
 */
public final class SetUsage {

    private SetUsage() {
    }

    /** Distinct values, in the order they were first seen. */
    public static List<Integer> distinctInOrder(int[] values) {
        throw new UnsupportedOperationException("TODO: SetUsage.distinctInOrder");
    }

    /** Distinct values, ascending. */
    public static List<Integer> distinctSorted(int[] values) {
        throw new UnsupportedOperationException("TODO: SetUsage.distinctSorted");
    }

    /** Values present in both, ascending. Neither input is modified. */
    public static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
        throw new UnsupportedOperationException("TODO: SetUsage.intersection");
    }

    /** Values present in either, ascending. Neither input is modified. */
    public static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
        throw new UnsupportedOperationException("TODO: SetUsage.union");
    }

    /** Values in {@code a} but not in {@code b}, ascending. Neither input is modified. */
    public static Set<Integer> difference(Set<Integer> a, Set<Integer> b) {
        throw new UnsupportedOperationException("TODO: SetUsage.difference");
    }

    /** True when any value appears more than once, failing fast on the first repeat. */
    public static boolean hasDuplicate(int[] values) {
        throw new UnsupportedOperationException("TODO: SetUsage.hasDuplicate");
    }

    /**
     * The largest stored value less than or equal to {@code target}, or
     * {@code Optional.empty()}. A sorted set answers this without a scan.
     */
    public static java.util.Optional<Integer> largestAtMost(Set<Integer> values, int target) {
        throw new UnsupportedOperationException("TODO: SetUsage.largestAtMost");
    }
}
