package dsa.exercises.dp;

/**
 * Edit Distance (Levenshtein).
 *
 * <p>Fewest single-character insertions, deletions or replacements that turn
 * {@code a} into {@code b}.
 *
 * <p>Example: {@code "horse"} to {@code "ros"} gives 3.
 *
 * <p>Same table shape as the longest common subsequence, with three
 * predecessors instead of two: insert, delete or replace. Fill the first row
 * and column with "delete everything" and "insert everything" before starting.
 * O(n * m).
 */
public final class EditDistance {

    public static int solve(String a, String b) {
        throw new UnsupportedOperationException("TODO: EditDistance.solve");
    }
}
