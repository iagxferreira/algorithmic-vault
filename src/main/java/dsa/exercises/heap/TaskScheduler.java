package dsa.exercises.heap;

/**
 * Task Scheduler.
 *
 * <p>Tasks are labelled A to Z and each takes one time unit. Two runs of the
 * same task must be at least {@code cooldown} units apart; idle units fill the
 * gaps. Return the shortest total time.
 *
 * <p>Example: {@code ["A", "A", "A", "B", "B", "B"], cooldown = 2} gives 8:
 * A B idle A B idle A B.
 *
 * <p>The greedy simulation always runs the most frequent available task, which
 * is a max-heap plus a cooldown queue. There is also a closed-form counting
 * argument based on the most frequent task; deriving it is the better exercise.
 */
public final class TaskScheduler {

    public static int solve(char[] tasks, int cooldown) {
        throw new UnsupportedOperationException("TODO: TaskScheduler.solve");
    }
}
