package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class KruskalTest {

    /** 0-1 (1), 0-2 (2), 1-2 (2), 2-3 (3): the two weight-2 edges are a tie. */
    private static final int[][] EDGES = {{0, 1, 1}, {0, 2, 2}, {1, 2, 2}, {2, 3, 3}};

    @Test
    void skipsTheEdgeThatWouldCloseACycle() {
        assertEquals(6, Kruskal.totalWeight(4, EDGES));
    }

    @Test
    void reportsTheChosenEdges() {
        List<int[]> chosen = Kruskal.edges(4, EDGES);
        assertEquals(3, chosen.size(), "a spanning tree of n vertices has n - 1 edges");
        assertArrayEquals(new int[] {0, 1, 1}, chosen.get(0));
        assertArrayEquals(new int[] {0, 2, 2}, chosen.get(1));
        assertArrayEquals(new int[] {2, 3, 3}, chosen.get(2));
    }

    @Test
    void aDisconnectedGraphHasNoSpanningTree() {
        assertEquals(-1, Kruskal.totalWeight(3, new int[][] {{0, 1, 1}}));
        assertEquals(List.of(), Kruskal.edges(3, new int[][] {{0, 1, 1}}));
    }

    @Test
    void aSingleVertexNeedsNoEdges() {
        assertEquals(0, Kruskal.totalWeight(1, new int[][] {}));
        assertEquals(List.of(), Kruskal.edges(1, new int[][] {}));
    }

    @Test
    void ignoresDuplicateAndSelfEdges() {
        int[][] edges = {{0, 0, 5}, {0, 1, 4}, {0, 1, 1}};
        assertEquals(1, Kruskal.totalWeight(2, edges));
    }
}
