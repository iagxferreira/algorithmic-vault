package dsa.algorithms.numbers;

import java.util.List;
import java.util.Map;

/**
 * Breaking a number into its factors.
 *
 * <p>Both routines lean on the same fact: if n has a factor larger than
 * sqrt(n), it must also have the matching one below it. So you only ever need
 * to test up to sqrt(n) and pair the results.
 *
 * <p>Target: O(sqrt n) time.
 *
 * <p>See {@code docs/algorithms/number-theory.md} for what to understand first.
 */
public final class Factorisation {

    private Factorisation() {
    }

    /** Prime to exponent, so 360 gives {@code {2:3, 3:2, 5:1}}. 1 gives an empty map. */
    public static Map<Long, Integer> primeFactors(long n) {
        throw new UnsupportedOperationException("TODO: Factorisation.primeFactors");
    }

    /** Every divisor of n, ascending. Pair them up around sqrt(n). */
    public static List<Long> divisors(long n) {
        throw new UnsupportedOperationException("TODO: Factorisation.divisors");
    }

    /** How many divisors n has. Derivable from the exponents without listing them. */
    public static int countDivisors(long n) {
        throw new UnsupportedOperationException("TODO: Factorisation.countDivisors");
    }
}
