package dsa.usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SetUsageTest {

    @Test
    void keepsFirstSeenOrder() {
        assertEquals(List.of(3, 1, 2), SetUsage.distinctInOrder(new int[] {3, 1, 3, 2, 1}));
        assertEquals(List.of(), SetUsage.distinctInOrder(new int[] {}));
    }

    @Test
    void sortsDistinctValues() {
        assertEquals(List.of(1, 2, 3), SetUsage.distinctSorted(new int[] {3, 1, 3, 2, 1}));
        assertEquals(List.of(-5, 0, 7), SetUsage.distinctSorted(new int[] {7, -5, 0, 7}));
    }

    @Test
    void intersectsWithoutMutatingTheInputs() {
        Set<Integer> a = new java.util.HashSet<>(Set.of(1, 2, 3));
        Set<Integer> b = new java.util.HashSet<>(Set.of(2, 3, 4));
        assertEquals(Set.of(2, 3), SetUsage.intersection(a, b));
        assertEquals(3, a.size(), "the inputs must be unchanged");
        assertEquals(3, b.size(), "the inputs must be unchanged");
    }

    @Test
    void unionsAndSubtracts() {
        Set<Integer> a = Set.of(1, 2, 3);
        Set<Integer> b = Set.of(3, 4);
        assertEquals(Set.of(1, 2, 3, 4), SetUsage.union(a, b));
        assertEquals(Set.of(1, 2), SetUsage.difference(a, b));
        assertEquals(Set.of(4), SetUsage.difference(b, a));
    }

    @Test
    void handlesDisjointAndEmptySets() {
        assertEquals(Set.of(), SetUsage.intersection(Set.of(1), Set.of(2)));
        assertEquals(Set.of(1), SetUsage.union(Set.of(1), Set.of()));
        assertEquals(Set.of(), SetUsage.difference(Set.of(), Set.of(1)));
    }

    @Test
    void spotsDuplicates() {
        assertTrue(SetUsage.hasDuplicate(new int[] {1, 2, 1}));
        assertFalse(SetUsage.hasDuplicate(new int[] {1, 2, 3}));
        assertFalse(SetUsage.hasDuplicate(new int[] {}));
    }

    @Test
    void findsTheLargestValueAtMostATarget() {
        Set<Integer> values = Set.of(1, 5, 9);
        assertEquals(Optional.of(5), SetUsage.largestAtMost(values, 7));
        assertEquals(Optional.of(9), SetUsage.largestAtMost(values, 9));
        assertTrue(SetUsage.largestAtMost(values, 0).isEmpty());
    }
}
