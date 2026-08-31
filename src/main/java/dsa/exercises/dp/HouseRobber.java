package dsa.exercises.dp;

/**
 * House Robber.
 *
 * <p>Maximum you can take from a row of houses without taking from two
 * adjacent ones.
 *
 * <p>Example: {@code [2, 7, 9, 3, 1]} gives 12, taking 2, 9 and 1.
 *
 * <p>At each house the decision is take-it-and-skip-one, or skip it:
 * {@code best(i) = max(best(i - 1), best(i - 2) + value)}. Only two previous
 * values matter, so O(1) space.
 */
public final class HouseRobber {

    public static int solve(int[] houses) {
        throw new UnsupportedOperationException("TODO: HouseRobber.solve");
    }
}
