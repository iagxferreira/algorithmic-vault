package dsa.exercises.graphs;

/**
 * Course Schedule.
 *
 * <p>{@code prerequisites[i] = {a, b}} means course b must come before course
 * a. Return true when all {@code courseCount} courses can be finished.
 *
 * <p>Example: 2 courses with {@code [[1, 0]]} gives true;
 * {@code [[1, 0], [0, 1]]} gives false.
 *
 * <p>Restated: does this directed graph have a cycle? Either run the
 * three-colour dfs, or Kahn's algorithm and check every vertex came out. Both
 * are O(V + E).
 */
public final class CourseSchedule {

    public static boolean solve(int courseCount, int[][] prerequisites) {
        throw new UnsupportedOperationException("TODO: CourseSchedule.solve");
    }
}
