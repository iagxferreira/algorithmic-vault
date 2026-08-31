package dsa.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.function.UnaryOperator;

/**
 * The behaviour every sort in this package has to satisfy.
 *
 * <p>Test-only plumbing so each sort's own test file stays one line. If your
 * sort passes this, it sorts.
 */
final class SortContract {

    private SortContract() {
    }

    /** Runs the shape cases and a randomised cross-check against the JDK. */
    static void verify(UnaryOperator<int[]> sort) {
        verifyShapes(sort);
        verifyAgainstJdk(sort, -100, 100);
    }

    /** Empty, single, sorted, reversed, all-equal, negatives. */
    static void verifyShapes(UnaryOperator<int[]> sort) {
        assertArrayEquals(new int[] {}, sort.apply(new int[] {}));
        assertArrayEquals(new int[] {1}, sort.apply(new int[] {1}));
        assertArrayEquals(new int[] {1, 2, 3}, sort.apply(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {1, 2, 3}, sort.apply(new int[] {3, 2, 1}));
        assertArrayEquals(new int[] {2, 2, 2}, sort.apply(new int[] {2, 2, 2}));
        assertArrayEquals(new int[] {1, 1, 2, 3, 3}, sort.apply(new int[] {3, 1, 3, 2, 1}));
    }

    /** Twenty random arrays, compared against Arrays.sort. */
    static void verifyAgainstJdk(UnaryOperator<int[]> sort, int minValue, int maxValue) {
        Random random = new Random(42);
        for (int round = 0; round < 20; round++) {
            int[] values = random.ints(random.nextInt(60), minValue, maxValue).toArray();
            int[] expected = values.clone();
            Arrays.sort(expected);
            assertArrayEquals(expected, sort.apply(values.clone()),
                    "failed on " + Arrays.toString(values));
        }
    }
}
