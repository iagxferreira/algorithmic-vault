package dsa.exercises.stackqueue;

/**
 * Daily Temperatures.
 *
 * <p>For each day, how many days until a warmer one; 0 when none comes.
 *
 * <p>Example: {@code [73, 74, 75, 71, 69, 72, 76, 73]} gives
 * {@code [1, 1, 4, 2, 1, 1, 0, 0]}.
 *
 * <p>Your introduction to the monotonic stack. Keep a stack of indices whose
 * answer is still unknown, in decreasing temperature order. Each new day
 * resolves everything on top that is colder than it. Every index is pushed and
 * popped once, so O(n).
 */
public final class DailyTemperatures {

    public static int[] solve(int[] temperatures) {
        throw new UnsupportedOperationException("TODO: DailyTemperatures.solve");
    }
}
