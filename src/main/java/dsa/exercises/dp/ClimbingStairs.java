package dsa.exercises.dp;

/**
 * Climbing Stairs.
 *
 * <p>Number of distinct ways to climb {@code n} steps taking 1 or 2 at a time.
 * {@code n = 3} gives 3: 1+1+1, 1+2, 2+1.
 *
 * <p>{@code ways(n) = ways(n - 1) + ways(n - 2)}, i.e. Fibonacci. Write it
 * three ways and watch the cost collapse: naive recursion is O(2^n),
 * memoised recursion is O(n) time and O(n) space, and the bottom-up loop
 * keeping only two values is O(n) time and O(1) space.
 */
public final class ClimbingStairs {

    public static int solve(int n) {
        throw new UnsupportedOperationException("TODO: ClimbingStairs.solve");
    }
}
