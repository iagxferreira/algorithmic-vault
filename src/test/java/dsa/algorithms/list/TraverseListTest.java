package dsa.algorithms.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import dsa.support.ListNodes;
import java.util.List;
import org.junit.jupiter.api.Test;

class TraverseListTest {

    @Test
    void measuresLength() {
        assertEquals(0, TraverseList.length(null));
        assertEquals(1, TraverseList.length(ListNodes.of(9)));
        assertEquals(4, TraverseList.length(ListNodes.of(1, 2, 3, 4)));
    }

    @Test
    void sumsValues() {
        assertEquals(0, TraverseList.sum(null));
        assertEquals(10, TraverseList.sum(ListNodes.of(1, 2, 3, 4)));
        assertEquals(-1, TraverseList.sum(ListNodes.of(2, -3)));
    }

    @Test
    void collectsValuesInOrder() {
        assertEquals(List.of(), TraverseList.values(null));
        assertEquals(List.of(1, 2, 3), TraverseList.values(ListNodes.of(1, 2, 3)));
    }

    @Test
    void findsTheLastNode() {
        assertNull(TraverseList.last(null));
        assertEquals(3, TraverseList.last(ListNodes.of(1, 2, 3)).val);
        assertEquals(1, TraverseList.last(ListNodes.of(1)).val);
    }
}
