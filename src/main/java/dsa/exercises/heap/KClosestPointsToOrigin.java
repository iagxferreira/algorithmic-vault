package dsa.exercises.heap;

/**
 * K Closest Points to Origin.
 *
 * <p>Return the {@code k} points nearest the origin, sorted by distance then
 * by x then by y so the output is comparable. Points arrive as
 * {@code {x, y}} pairs.
 *
 * <p>Example: {@code [[1, 3], [-2, 2]], k = 1} gives {@code [[-2, 2]]}.
 *
 * <p>Compare squared distances and skip the square root entirely: it is
 * monotonic, so it cannot change the ordering, and it costs precision and
 * time. A max-heap of size k gives O(n log k).
 */
public final class KClosestPointsToOrigin {

    public static int[][] solve(int[][] points, int k) {
        throw new UnsupportedOperationException("TODO: KClosestPointsToOrigin.solve");
    }
}
