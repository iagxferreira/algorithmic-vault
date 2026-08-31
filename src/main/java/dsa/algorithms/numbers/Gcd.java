package dsa.algorithms.numbers;

/**
 * Greatest common divisor and lowest common multiple.
 *
 * <p>Euclid's algorithm: {@code gcd(a, b) == gcd(b, a % b)}, stopping when b
 * hits zero. Four lines, two and a half thousand years old, and still the
 * fastest thing available.
 *
 * <p>Target: O(log min(a, b)) time, O(1) space iteratively.
 *
 * <p>See {@code docs/algorithms/number-theory.md} for what to understand first.
 */
public final class Gcd {

    private Gcd() {
    }

    /** {@code gcd(a, 0)} is a, and {@code gcd(0, 0)} is 0. */
    public static long gcd(long a, long b) {
        throw new UnsupportedOperationException("TODO: Gcd.gcd");
    }

    /**
     * Lowest common multiple. Divide before multiplying - {@code a / gcd * b}
     * rather than {@code a * b / gcd} - so the intermediate cannot overflow.
     */
    public static long lcm(long a, long b) {
        throw new UnsupportedOperationException("TODO: Gcd.lcm");
    }

    /** Gcd of a whole array; 0 for an empty one. */
    public static long gcdOf(int[] values) {
        throw new UnsupportedOperationException("TODO: Gcd.gcdOf");
    }
}
