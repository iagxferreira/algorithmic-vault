package dsa.usage;

import java.util.List;

/**
 * Driving {@link java.util.List} the easy way.
 *
 * <p>You built {@link dsa.structures.DynamicArray} and
 * {@link dsa.structures.SinglyLinkedList} by hand. In real code you reach for
 * {@code ArrayList} instead, and the skill that matters becomes knowing the
 * idioms cold: what each method returns, which ones mutate, and where the
 * traps are.
 *
 * <p>Three traps these drills walk you into:
 *
 * <ul>
 *   <li>{@code List.of(...)} is <b>immutable</b>. Adding to it throws
 *       {@code UnsupportedOperationException}, so wrap it in
 *       {@code new ArrayList<>(...)} when you need to change it.
 *   <li>{@code list.remove(int)} removes by <b>index</b> and
 *       {@code list.remove(Object)} by <b>value</b>. On a
 *       {@code List<Integer>} those are two different methods and picking the
 *       wrong one is silent.
 *   <li>Removing inside a for-each loop throws
 *       {@code ConcurrentModificationException}. Use an explicit
 *       {@code Iterator} and its {@code remove}, or {@code removeIf}.
 * </ul>
 */
public final class ListUsage {

    private ListUsage() {
    }

    /** A mutable list holding the given values, in order. */
    public static List<Integer> build(int... values) {
        throw new UnsupportedOperationException("TODO: ListUsage.build");
    }

    /** {@code int[]} to {@code List<Integer>}. Note that streams box for you. */
    public static List<Integer> toList(int[] values) {
        throw new UnsupportedOperationException("TODO: ListUsage.toList");
    }

    /** {@code List<Integer>} back to {@code int[]}, unboxing on the way. */
    public static int[] toArray(List<Integer> values) {
        throw new UnsupportedOperationException("TODO: ListUsage.toArray");
    }

    /** A new list with the elements in the opposite order; the input is unchanged. */
    public static List<Integer> reversed(List<Integer> values) {
        throw new UnsupportedOperationException("TODO: ListUsage.reversed");
    }

    /**
     * A new list rotated right by {@code steps}, so {@code [1,2,3,4]} by 1
     * gives {@code [4,1,2,3]}. Handle {@code steps} larger than the list and
     * negative steps, remembering that {@code %} can return a negative.
     */
    public static List<Integer> rotated(List<Integer> values, int steps) {
        throw new UnsupportedOperationException("TODO: ListUsage.rotated");
    }

    /** A new list with every value failing the "is even" test dropped. */
    public static List<Integer> keepEven(List<Integer> values) {
        throw new UnsupportedOperationException("TODO: ListUsage.keepEven");
    }

    /** Removes every odd value from the given list <b>in place</b>. */
    public static void removeOddInPlace(List<Integer> values) {
        throw new UnsupportedOperationException("TODO: ListUsage.removeOddInPlace");
    }

    /** A new list sorted descending, using a comparator rather than sort-then-reverse. */
    public static List<Integer> sortedDescending(List<Integer> values) {
        throw new UnsupportedOperationException("TODO: ListUsage.sortedDescending");
    }

    /** The words sorted by length, and alphabetically within the same length. */
    public static List<String> sortedByLengthThenAlphabetically(List<String> words) {
        throw new UnsupportedOperationException("TODO: ListUsage.sortedByLengthThenAlphabetically");
    }
}
