package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dsa.support.TestGraphs;
import java.util.List;
import org.junit.jupiter.api.Test;

class MinimumSpanningTreeTest {

    /** 0-1 (1), 0-2 (2), 1-2 (2), 2-3 (3): the two weight-2 edges are a tie. */
    private static final int[][] EDGES = {{0, 1, 1}, {0, 2, 2}, {1, 2, 2}, {2, 3, 3}};

    @Test
    void kruskalSkipsTheEdgeThatWouldCloseACycle() {
        assertEquals(6, MinimumSpanningTree.kruskal(4, EDGES));
    }

    @Test
    void kruskalReportsTheChosenEdges() {
        List<int[]> chosen = MinimumSpanningTree.kruskalEdges(4, EDGES);
        assertEquals(3, chosen.size());
        assertArrayEquals(new int[] {0, 1, 1}, chosen.get(0));
        assertArrayEquals(new int[] {0, 2, 2}, chosen.get(1));
        assertArrayEquals(new int[] {2, 3, 3}, chosen.get(2));
    }

    @Test
    void primAgreesWithKruskal() {
        assertEquals(6, MinimumSpanningTree.prim(TestGraphs.weighted(4, EDGES, false)));
    }

    @Test
    void aDisconnectedGraphHasNoSpanningTree() {
        int[][] split = {{0, 1, 1}};
        assertEquals(-1, MinimumSpanningTree.kruskal(3, split));
        assertEquals(List.of(), MinimumSpanningTree.kruskalEdges(3, split));
        assertEquals(-1, MinimumSpanningTree.prim(TestGraphs.weighted(3, split, false)));
    }

    @Test
    void aSingleVertexNeedsNoEdges() {
        assertEquals(0, MinimumSpanningTree.kruskal(1, new int[][] {}));
        assertEquals(0, MinimumSpanningTree.prim(TestGraphs.weighted(1, new int[][] {}, false)));
    }
}
