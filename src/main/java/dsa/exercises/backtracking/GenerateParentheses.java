package dsa.exercises.backtracking;

import java.util.List;

/**
 * Generate Parentheses.
 *
 * <p>Every well-formed string of {@code n} pairs of parentheses, in the order
 * produced by always trying "(" before ")". For {@code n = 3} that is
 * {@code ["((()))", "(()())", "(())()", "()(())", "()()()"]}.
 *
 * <p>The lesson here is pruning. Generating all 2^(2n) strings and filtering
 * works but is wasteful; instead only place "(" while some remain, and ")"
 * only while it would not outnumber the "(" already placed. That way every
 * leaf of the recursion is a valid answer.
 */
public final class GenerateParentheses {

    public static List<String> solve(int n) {
        throw new UnsupportedOperationException("TODO: GenerateParentheses.solve");
    }
}
