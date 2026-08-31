package dsa.exercises.greedy;

/**
 * Gas Station.
 *
 * <p>Stations sit in a circle; station i gives {@code gas[i]} and driving to
 * the next one costs {@code cost[i]}. Return the index to start from to
 * complete the loop, or -1 when it is impossible. The answer is unique when it
 * exists.
 *
 * <p>Example: {@code gas = [1, 2, 3, 4, 5], cost = [3, 4, 5, 1, 2]} gives 3.
 *
 * <p>Two observations turn the O(n^2) simulation into one pass: the trip is
 * possible exactly when total gas is at least total cost, and if you run dry
 * partway from a start, no station in between works either, so restart from
 * the next one. O(n).
 */
public final class GasStation {

    public static int solve(int[] gas, int[] cost) {
        throw new UnsupportedOperationException("TODO: GasStation.solve");
    }
}
