package dsa.structures;

/**
 * A segment tree over ints, supporting point assignment plus range sum and
 * range min queries.
 *
 * <p>Why it matters: more general than a Fenwick tree. Any associative merge
 * works (sum, min, max, gcd), so the same skeleton solves a whole family of
 * range problems.
 *
 * <p>Shape: an array of size {@code 4n} is always enough. Node {@code i}
 * covers a range whose halves live at {@code 2i} and {@code 2i + 1}. Build
 * recursively, and on a query stop early when a node's range is fully inside
 * or fully outside the query.
 *
 * <p>Target complexity: build O(n), update/query O(log n).
 */
public class SegmentTree {

    private final int size;

    public SegmentTree(int[] values) {
        this.size = values.length;
        throw new UnsupportedOperationException("TODO: SegmentTree constructor");
    }

    /** Sets position {@code index} to {@code value}. */
    public void set(int index, int value) {
        throw new UnsupportedOperationException("TODO: SegmentTree.set");
    }

    /** Sum of the inclusive range {@code [from, to]}. */
    public int rangeSum(int from, int to) {
        throw new UnsupportedOperationException("TODO: SegmentTree.rangeSum");
    }

    /** Minimum over the inclusive range {@code [from, to]}. */
    public int rangeMin(int from, int to) {
        throw new UnsupportedOperationException("TODO: SegmentTree.rangeMin");
    }
}
