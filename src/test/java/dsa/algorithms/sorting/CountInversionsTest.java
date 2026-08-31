package dsa.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

class CountInversionsTest {

    private static long bruteForce(int[] values) {
        long count = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] > values[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    void sortedInputHasNone() {
        assertEquals(0L, CountInversions.count(new int[] {1, 2, 3, 4}));
        assertEquals(0L, CountInversions.count(new int[] {}));
        assertEquals(0L, CountInversions.count(new int[] {5}));
    }

    @Test
    void reversedInputHasEveryPair() {
        assertEquals(6L, CountInversions.count(new int[] {4, 3, 2, 1}));
        assertEquals(45L, CountInversions.count(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    @Test
    void countsMixedInput() {
        assertEquals(3L, CountInversions.count(new int[] {2, 4, 1, 3, 5}));
    }

    @Test
    void equalValuesAreNotInverted() {
        assertEquals(0L, CountInversions.count(new int[] {2, 2, 2}));
    }

    @Test
    void agreesWithTheQuadraticVersion() {
        Random random = new Random(3);
        for (int round = 0; round < 30; round++) {
            int[] values = random.ints(random.nextInt(50), -20, 20).toArray();
            assertEquals(bruteForce(values), CountInversions.count(values.clone()));
        }
    }
}
