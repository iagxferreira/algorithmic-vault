package dsa.algorithms.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BitmasksTest {

    @Test
    void enumeratesSubsetsByMaskValue() {
        assertEquals(
                List.of(List.of(), List.of(1), List.of(2), List.of(1, 2)),
                Bitmasks.subsets(new int[] {1, 2}));
    }

    @Test
    void theEmptyArrayHasExactlyOneSubset() {
        assertEquals(List.of(List.of()), Bitmasks.subsets(new int[] {}));
    }

    @Test
    void producesTwoToTheN() {
        assertEquals(8, Bitmasks.subsets(new int[] {1, 2, 3}).size());
        assertEquals(32, Bitmasks.subsets(new int[] {1, 2, 3, 4, 5}).size());
    }

    @Test
    void readsTheElementsOfOneMask() {
        int[] values = {10, 20, 30};
        assertEquals(List.of(), Bitmasks.elementsOf(values, 0b000));
        assertEquals(List.of(10, 30), Bitmasks.elementsOf(values, 0b101));
        assertEquals(List.of(10, 20, 30), Bitmasks.elementsOf(values, 0b111));
    }

    @Test
    void sumsEverySubsetSum() {
        assertEquals(0L, Bitmasks.totalOfAllSubsetSums(new int[] {}));
        assertEquals(6L, Bitmasks.totalOfAllSubsetSums(new int[] {1, 2}),
                "each element appears in half of the 4 subsets: (1 + 2) * 2");
        assertEquals(24L, Bitmasks.totalOfAllSubsetSums(new int[] {1, 2, 3}));
    }
}
