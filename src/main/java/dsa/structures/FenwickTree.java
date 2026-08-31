package dsa.structures;

/**
 * A Fenwick tree (binary indexed tree) over ints, supporting point updates and
 * prefix sums.
 *
 * <p>Why it matters: the competitive programming workhorse. Whenever a problem
 * interleaves "add to one position" and "sum a range", a Fenwick tree turns an
 * O(n) scan per query into O(log n), in about fifteen lines of code.
 *
 * <p>The trick is {@code i & -i}, which isolates the lowest set bit: that is
 * the size of the range each node covers. Walk upwards by adding it when
 * updating, and downwards by subtracting it when querying.
 *
 * <p>Indices in the public API are 0-based; internally the tree is usually
 * 1-based, which makes the bit arithmetic work out.
 *
 * <p>Target complexity: update/prefixSum O(log n), build O(n log n).
 */
public class FenwickTree {

    private final int[] tree;
    private final int size;

    public FenwickTree(int size) {
        this.size = size;
        this.tree = new int[size + 1];
    }

    /** Adds {@code delta} to the value at {@code index}. */
    public void update(int index, int delta) {
        throw new UnsupportedOperationException("TODO: FenwickTree.update");
    }

    /** Sum of {@code [0, index]}; 0 when index is negative. */
    public int prefixSum(int index) {
        throw new UnsupportedOperationException("TODO: FenwickTree.prefixSum");
    }

    /** Sum of the inclusive range {@code [from, to]}. */
    public int rangeSum(int from, int to) {
        throw new UnsupportedOperationException("TODO: FenwickTree.rangeSum");
    }

    /** Builds the tree from an initial array. */
    public static FenwickTree of(int[] values) {
        throw new UnsupportedOperationException("TODO: FenwickTree.of");
    }
}
