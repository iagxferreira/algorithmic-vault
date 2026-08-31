package dsa.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private final int[] sorted = {1, 3, 5, 7, 9, 11};

    @Test
    void findsPresentValues() {
        assertEquals(0, BinarySearch.search(sorted, 1));
        assertEquals(3, BinarySearch.search(sorted, 7));
        assertEquals(5, BinarySearch.search(sorted, 11));
    }

    @Test
    void reportsMinusOneForAbsentValues() {
        assertEquals(-1, BinarySearch.search(sorted, 0));
        assertEquals(-1, BinarySearch.search(sorted, 6));
        assertEquals(-1, BinarySearch.search(sorted, 100));
    }

    @Test
    void handlesEmptyAndSingleElementArrays() {
        assertEquals(-1, BinarySearch.search(new int[] {}, 1));
        assertEquals(0, BinarySearch.search(new int[] {5}, 5));
        assertEquals(-1, BinarySearch.search(new int[] {5}, 4));
    }

    @Test
    void agreesWithTheJdkOnRandomInput() {
        Random random = new Random(11);
        for (int round = 0; round < 50; round++) {
            int[] values = random.ints(random.nextInt(40) + 1, -30, 30).distinct().sorted().toArray();
            int target = random.nextInt(70) - 35;
            int expected = Arrays.binarySearch(values, target);
            assertEquals(expected < 0 ? -1 : expected, BinarySearch.search(values, target),
                    "target " + target + " in " + Arrays.toString(values));
        }
    }
}
