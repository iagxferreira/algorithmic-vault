package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class DijkstraTest {

    private static final int INF = Integer.MAX_VALUE;

    /** 0->1 (4), 0->2 (1), 2->1 (2), 1->3 (1), 2->3 (5); vertex 4 is stranded. */
    private final List<List<int[]>> graph = Graphs.weighted(
            5, new int[][] {{0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {1, 3, 1}, {2, 3, 5}}, true);

    @Test
    void prefersTheCheapDetourOverTheDirectEdge() {
        assertArrayEquals(new int[] {0, 3, 1, 4, INF}, Dijkstra.distances(graph, 0));
    }

    @Test
    void rebuildsTheCheapestPath() {
        assertEquals(List.of(0, 2, 1, 3), Dijkstra.path(graph, 0, 3));
        assertEquals(List.of(0), Dijkstra.path(graph, 0, 0));
        assertEquals(List.of(), Dijkstra.path(graph, 0, 4));
    }

    @Test
    void handlesAnUndirectedGraph() {
        List<List<int[]>> undirected =
                Graphs.weighted(4, new int[][] {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 10}}, false);
        assertArrayEquals(new int[] {0, 1, 2, 3}, Dijkstra.distances(undirected, 0));
    }

    @Test
    void aSingleVertexCostsNothing() {
        assertArrayEquals(new int[] {0}, Dijkstra.distances(Graphs.weighted(1, new int[][] {}, true), 0));
    }

    @Test
    void zeroWeightEdgesAreFine() {
        List<List<int[]>> zeroes = Graphs.weighted(3, new int[][] {{0, 1, 0}, {1, 2, 0}}, true);
        assertArrayEquals(new int[] {0, 0, 0}, Dijkstra.distances(zeroes, 0));
    }
}
