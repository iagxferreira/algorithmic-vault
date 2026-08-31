package dsa.structures;

/**
 * Disjoint set union over the elements {@code 0..n-1}.
 *
 * <p>Why it matters: connectivity questions, cycle detection in undirected
 * graphs and Kruskal's MST all reduce to union-find.
 *
 * <p>Two optimisations make it near constant time, and you want both:
 * path compression in {@link #find(int)}, and union by rank or size so the
 * shallower tree is hung under the deeper one.
 *
 * <p>Target complexity: effectively O(1) amortised per operation.
 */
public class UnionFind {

    private final int[] parent;
    private final int[] rank;
    private int components;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.components = n;
    }

    /** Representative of the set containing x, with path compression. */
    public int find(int x) {
        throw new UnsupportedOperationException("TODO: UnionFind.find");
    }

    /** @return false when a and b were already in the same set. */
    public boolean union(int a, int b) {
        throw new UnsupportedOperationException("TODO: UnionFind.union");
    }

    public boolean connected(int a, int b) {
        throw new UnsupportedOperationException("TODO: UnionFind.connected");
    }

    /** Number of disjoint sets remaining. */
    public int components() {
        throw new UnsupportedOperationException("TODO: UnionFind.components");
    }
}
