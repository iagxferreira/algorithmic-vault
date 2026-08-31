package dsa.exercises.backtracking;

/**
 * Word Search.
 *
 * <p>Return true when {@code word} can be spelled by walking orthogonally
 * adjacent cells of the board, using each cell at most once per path.
 *
 * <p>Example: on {@code [[A,B,C,E],[S,F,C,S],[A,D,E,E]]}, "ABCCED" is found
 * and "ABCB" is not, because it would reuse the B.
 *
 * <p>Dfs with an undo step, which is what separates backtracking from a plain
 * flood fill: mark a cell as used before recursing and unmark it afterwards,
 * so other paths can still use it.
 */
public final class WordSearch {

    public static boolean solve(char[][] board, String word) {
        throw new UnsupportedOperationException("TODO: WordSearch.solve");
    }
}
