package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConnectedComponentsTest {

    @Test
    void countsThePieces() {
        assertEquals(2, ConnectedComponents.count(Graphs.sample()));
        assertEquals(4, ConnectedComponents.count(Graphs.unweighted(4, new int[][] {}, false)));
        assertEquals(1, ConnectedComponents.count(Graphs.unweighted(2, new int[][] {{0, 1}}, false)));
        assertEquals(0, ConnectedComponents.count(Graphs.unweighted(0, new int[][] {}, false)));
    }

    @Test
    void labelsVerticesByDiscoveryOrder() {
        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 1}, ConnectedComponents.labels(Graphs.sample()));
        assertArrayEquals(
                new int[] {0, 1, 0, 1},
                ConnectedComponents.labels(Graphs.unweighted(4, new int[][] {{0, 2}, {1, 3}}, false)));
    }

    @Test
    void measuresTheLargestComponent() {
        assertEquals(5, ConnectedComponents.largestComponentSize(Graphs.sample()));
        assertEquals(1, ConnectedComponents.largestComponentSize(Graphs.unweighted(3, new int[][] {}, false)));
        assertEquals(0, ConnectedComponents.largestComponentSize(Graphs.unweighted(0, new int[][] {}, false)));
    }
}
