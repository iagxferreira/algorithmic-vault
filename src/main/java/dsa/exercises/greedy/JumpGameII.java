package dsa.exercises.greedy;

/**
 * Jump Game II.
 *
 * <p>Same array, but now return the fewest jumps needed to reach the last
 * index. Reaching it is guaranteed.
 *
 * <p>Example: {@code [2, 3, 1, 1, 4]} gives 2, jumping 0 to 1 then 1 to 4.
 *
 * <p>This is really a breadth-first search over ranges: everything reachable
 * in one jump is a level, everything reachable from that level is the next.
 * Sweep once, tracking the end of the current level and the furthest reach of
 * the next; increment the count on crossing a boundary. O(n), no queue needed.
 */
public final class JumpGameII {

    public static int solve(int[] jumps) {
        throw new UnsupportedOperationException("TODO: JumpGameII.solve");
    }
}
