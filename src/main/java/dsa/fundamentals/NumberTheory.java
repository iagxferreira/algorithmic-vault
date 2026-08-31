package dsa.fundamentals;

import java.util.List;
import java.util.Map;

/**
 * The arithmetic that keeps showing up in contest problems.
 *
 * <p>Why it matters: these are small routines you should be able to write
 * without thinking, because they appear as a sub-step of larger problems.
 * Fast exponentiation and modular arithmetic in particular are the difference
 * between a solution that fits in the time limit and one that overflows a
 * {@code long} halfway through.
 */
public final class NumberTheory {

    /** The modulus contest problems ask for most often. */
    public static final long MOD = 1_000_000_007L;

    private NumberTheory() {
    }

    /** Greatest common divisor via Euclid: {@code gcd(a, b) == gcd(b, a % b)}. O(log min(a, b)). */
    public static long gcd(long a, long b) {
        throw new UnsupportedOperationException("TODO: NumberTheory.gcd");
    }

    /** Lowest common multiple. Divide before multiplying so the product cannot overflow. */
    public static long lcm(long a, long b) {
        throw new UnsupportedOperationException("TODO: NumberTheory.lcm");
    }

    /**
     * {@code base^exponent} by squaring: halve the exponent each step instead
     * of multiplying one factor at a time. O(log exponent).
     */
    public static long power(long base, long exponent) {
        throw new UnsupportedOperationException("TODO: NumberTheory.power");
    }

    /** {@code base^exponent mod modulus}, taking the modulus at every step. */
    public static long modPow(long base, long exponent, long modulus) {
        throw new UnsupportedOperationException("TODO: NumberTheory.modPow");
    }

    /** Trial division up to sqrt(n). O(sqrt n). */
    public static boolean isPrime(long n) {
        throw new UnsupportedOperationException("TODO: NumberTheory.isPrime");
    }

    /**
     * Every prime up to and including {@code limit}, via the sieve of
     * Eratosthenes. O(n log log n), and the right tool when you need many
     * primality answers rather than one.
     */
    public static List<Integer> primesUpTo(int limit) {
        throw new UnsupportedOperationException("TODO: NumberTheory.primesUpTo");
    }

    /** Prime factorisation as prime to exponent, e.g. 360 becomes {2:3, 3:2, 5:1}. */
    public static Map<Long, Integer> primeFactors(long n) {
        throw new UnsupportedOperationException("TODO: NumberTheory.primeFactors");
    }

    /** Every divisor of n in ascending order. Pair them up around sqrt(n). */
    public static List<Long> divisors(long n) {
        throw new UnsupportedOperationException("TODO: NumberTheory.divisors");
    }

    /**
     * Binomial coefficient "n choose k" modulo {@link #MOD}, which is prime.
     * Division is not allowed under a modulus, so divide by multiplying with
     * the modular inverse, and Fermat's little theorem gives that inverse as
     * {@code x^(MOD - 2) mod MOD}.
     */
    public static long binomialMod(int n, int k) {
        throw new UnsupportedOperationException("TODO: NumberTheory.binomialMod");
    }
}
