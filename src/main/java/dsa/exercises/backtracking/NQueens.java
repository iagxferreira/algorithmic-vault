package dsa.exercises.backtracking;

/**
 * N-Queens.
 *
 * <p>Return how many ways {@code n} queens can be placed on an n x n board
 * with no two attacking each other. {@code n = 4} gives 2, {@code n = 8} gives
 * 92.
 *
 * <p>Place one queen per row, so only columns and diagonals can conflict.
 * Track the occupied columns and the two diagonal directions in sets: cells on
 * a "\" diagonal share {@code row - col}, and cells on a "/" diagonal share
 * {@code row + col}. Constant-time conflict checks are what make the search
 * finish.
 */
public final class NQueens {

    public static int solve(int n) {
        throw new UnsupportedOperationException("TODO: NQueens.solve");
    }
}
