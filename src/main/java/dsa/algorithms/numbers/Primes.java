package dsa.algorithms.numbers;

import java.util.List;

/**
 * Primality, one number at a time and all at once.
 *
 * <p>{@link #isPrime} is trial division up to sqrt(n) - the right choice for a
 * single large number. {@link #primesUpTo} is the sieve of Eratosthenes -
 * cross out multiples of each prime, and whatever survives is prime. The sieve
 * is the right choice whenever you need many answers, and it is fast enough to
 * run over 10^6 or 10^7 without thinking about it.
 *
 * <p>Two optimisations to derive rather than copy: start crossing out at
 * {@code p * p}, because every smaller multiple already had a smaller prime
 * factor; and stop the outer loop at sqrt(limit).
 *
 * <p>Target: isPrime O(sqrt n); the sieve O(n log log n) and O(n) space.
 *
 * <p>See {@code docs/algorithms/number-theory.md} for what to understand first.
 */
public final class Primes {

    private Primes() {
    }

    /** 0 and 1 are not prime; 2 is. */
    public static boolean isPrime(long n) {
        throw new UnsupportedOperationException("TODO: Primes.isPrime");
    }

    /** Every prime up to and including {@code limit}, ascending. */
    public static List<Integer> primesUpTo(int limit) {
        throw new UnsupportedOperationException("TODO: Primes.primesUpTo");
    }

    /** How many primes are strictly less than {@code n}. */
    public static int countPrimesBelow(int n) {
        throw new UnsupportedOperationException("TODO: Primes.countPrimesBelow");
    }
}
