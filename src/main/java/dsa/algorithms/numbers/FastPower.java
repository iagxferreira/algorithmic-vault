package dsa.algorithms.numbers;

/**
 * Exponentiation by squaring.
 *
 * <p>{@code x^n} is {@code (x^(n/2))^2} when n is even, and
 * {@code x * x^(n-1)} when it is odd. Halving the exponent instead of
 * decrementing it turns O(n) multiplications into O(log n).
 *
 * <p>{@link #modPow} is the version that actually matters in contests: take
 * the modulus at every step so nothing overflows, and you have the tool behind
 * modular inverses, hashing and matrix exponentiation.
 *
 * <p>Target: O(log exponent) time, O(1) space iteratively.
 *
 * <p>See {@code docs/algorithms/number-theory.md} for what to understand first.
 */
public final class FastPower {

    /** The prime modulus contest problems ask for most often. */
    public static final long MOD = 1_000_000_007L;

    private FastPower() {
    }

    /** {@code base^exponent}. {@code x^0} is 1, including {@code 0^0}. */
    public static long power(long base, long exponent) {
        throw new UnsupportedOperationException("TODO: FastPower.power");
    }

    /** {@code base^exponent mod modulus}, reducing at every step. */
    public static long modPow(long base, long exponent, long modulus) {
        throw new UnsupportedOperationException("TODO: FastPower.modPow");
    }

    /**
     * The modular inverse of {@code value} under {@link #MOD}, i.e. the x with
     * {@code value * x % MOD == 1}. Fermat's little theorem gives it as
     * {@code value^(MOD - 2) mod MOD}, which only works because MOD is prime.
     */
    public static long modInverse(long value) {
        throw new UnsupportedOperationException("TODO: FastPower.modInverse");
    }
}
