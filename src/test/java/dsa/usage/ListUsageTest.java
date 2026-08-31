package dsa.usage;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListUsageTest {

    @Test
    void buildsAMutableList() {
        List<Integer> list = ListUsage.build(1, 2, 3);
        assertEquals(List.of(1, 2, 3), list);
        list.add(4);
        assertEquals(List.of(1, 2, 3, 4), list, "build must not return an immutable list");
        assertEquals(List.of(), ListUsage.build());
    }

    @Test
    void convertsBetweenArrayAndList() {
        assertEquals(List.of(1, 2, 3), ListUsage.toList(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {1, 2, 3}, ListUsage.toArray(List.of(1, 2, 3)));
        assertEquals(List.of(), ListUsage.toList(new int[] {}));
        assertArrayEquals(new int[] {}, ListUsage.toArray(List.of()));
    }

    @Test
    void reversesWithoutTouchingTheInput() {
        List<Integer> input = List.of(1, 2, 3);
        assertEquals(List.of(3, 2, 1), ListUsage.reversed(input));
        assertEquals(List.of(1, 2, 3), input, "the input list must be unchanged");
    }

    @Test
    void rotatesRight() {
        assertEquals(List.of(4, 1, 2, 3), ListUsage.rotated(List.of(1, 2, 3, 4), 1));
        assertEquals(List.of(3, 4, 1, 2), ListUsage.rotated(List.of(1, 2, 3, 4), 2));
        assertEquals(List.of(1, 2, 3, 4), ListUsage.rotated(List.of(1, 2, 3, 4), 0));
    }

    @Test
    void rotationWrapsAndAcceptsNegativeSteps() {
        assertEquals(List.of(4, 1, 2, 3), ListUsage.rotated(List.of(1, 2, 3, 4), 5));
        assertEquals(List.of(2, 3, 4, 1), ListUsage.rotated(List.of(1, 2, 3, 4), -1));
        assertEquals(List.of(), ListUsage.rotated(List.of(), 3));
    }

    @Test
    void filtersIntoANewList() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(List.of(2, 4, 6), ListUsage.keepEven(input));
        assertEquals(6, input.size(), "the input list must be unchanged");
    }

    @Test
    void removesInPlaceWithoutConcurrentModification() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ListUsage.removeOddInPlace(list);
        assertEquals(List.of(2, 4), list);
    }

    @Test
    void sortsDescending() {
        assertEquals(List.of(9, 5, 3, 1), ListUsage.sortedDescending(List.of(3, 9, 1, 5)));
        assertEquals(List.of(2, 2, 1), ListUsage.sortedDescending(List.of(2, 1, 2)));
    }

    @Test
    void sortsByLengthThenAlphabetically() {
        assertEquals(
                List.of("be", "to", "not", "that", "question"),
                ListUsage.sortedByLengthThenAlphabetically(List.of("that", "to", "be", "question", "not")));
    }
}
