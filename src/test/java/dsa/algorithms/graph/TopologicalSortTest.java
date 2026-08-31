package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class TopologicalSortTest {

    private final List<List<Integer>> dag = Graphs.unweighted(
            6, new int[][] {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}}, true);

    @Test
    void ordersADag() {
        assertEquals(List.of(4, 5, 0, 2, 3, 1), TopologicalSort.sort(dag));
    }

    @Test
    void reportsCyclesAsAnEmptyOrder() {
        assertEquals(List.of(), TopologicalSort.sort(Graphs.unweighted(2, new int[][] {{0, 1}, {1, 0}}, true)));
        assertEquals(List.of(), TopologicalSort.sort(Graphs.unweighted(1, new int[][] {{0, 0}}, true)));
    }

    @Test
    void handlesAGraphWithNoEdges() {
        assertEquals(List.of(0, 1, 2), TopologicalSort.sort(Graphs.unweighted(3, new int[][] {}, true)));
        assertEquals(List.of(), TopologicalSort.sort(Graphs.unweighted(0, new int[][] {}, true)));
    }

    @Test
    void computesInDegrees() {
        assertArrayEquals(new int[] {2, 2, 1, 1, 0, 0}, TopologicalSort.inDegrees(dag));
        assertArrayEquals(new int[] {0, 0, 0}, TopologicalSort.inDegrees(Graphs.unweighted(3, new int[][] {}, true)));
    }
}
