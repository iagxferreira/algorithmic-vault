package dsa.algorithms.numbers;

/**
 * Binomial coefficients, modulo a prime.
 *
 * <p>"n choose k" grows astronomically, so contest problems always ask for it
 * modulo {@link FastPower#MOD}. The obstacle: the formula
 * {@code n! / (k! * (n-k)!)} needs division, and division is not defined under
 * a modulus.
 *
 * <p>The fix is the modular inverse - multiply by
 * {@code x^(MOD-2) mod MOD} instead of dividing by x. Get {@link FastPower}
 * working first; this is one line on top of it.
 *
 * <p>Target: O(n) after an O(n) factorial table, or O(k log MOD) directly.
 *
 * <p>See {@code docs/algorithms/number-theory.md} for what to understand first.
 */
public final class Binomial {

    private Binomial() {
    }

    /** "n choose k" mod {@link FastPower#MOD}; 0 when k is negative or exceeds n. */
    public static long choose(int n, int k) {
        throw new UnsupportedOperationException("TODO: Binomial.choose");
    }

    /** {@code n! mod MOD}. */
    public static long factorialMod(int n) {
        throw new UnsupportedOperationException("TODO: Binomial.factorialMod");
    }
}
