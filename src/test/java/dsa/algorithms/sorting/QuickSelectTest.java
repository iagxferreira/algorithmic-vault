package dsa.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class QuickSelectTest {

    @Test
    void findsTheKthSmallest() {
        assertEquals(1, QuickSelect.kthSmallest(new int[] {5, 2, 9, 1, 7}, 0));
        assertEquals(5, QuickSelect.kthSmallest(new int[] {5, 2, 9, 1, 7}, 2));
        assertEquals(9, QuickSelect.kthSmallest(new int[] {5, 2, 9, 1, 7}, 4));
    }

    @Test
    void handlesDuplicatesAndSingletons() {
        assertEquals(2, QuickSelect.kthSmallest(new int[] {2, 2, 2, 2}, 3));
        assertEquals(7, QuickSelect.kthSmallest(new int[] {7}, 0));
    }

    @Test
    void agreesWithSortingOnRandomInput() {
        Random random = new Random(7);
        for (int round = 0; round < 30; round++) {
            int[] values = random.ints(random.nextInt(40) + 1, -50, 50).toArray();
            int k = random.nextInt(values.length);
            int[] sorted = values.clone();
            Arrays.sort(sorted);
            assertEquals(sorted[k], QuickSelect.kthSmallest(values.clone(), k),
                    "k=" + k + " on " + Arrays.toString(values));
        }
    }
}
