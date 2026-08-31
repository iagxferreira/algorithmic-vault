package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrimTest {

    private static final int[][] EDGES = {{0, 1, 1}, {0, 2, 2}, {1, 2, 2}, {2, 3, 3}};

    @Test
    void agreesWithKruskal() {
        assertEquals(6, Prim.totalWeight(Graphs.weighted(4, EDGES, false)));
        assertEquals(Kruskal.totalWeight(4, EDGES), Prim.totalWeight(Graphs.weighted(4, EDGES, false)));
    }

    @Test
    void aDisconnectedGraphHasNoSpanningTree() {
        assertEquals(-1, Prim.totalWeight(Graphs.weighted(3, new int[][] {{0, 1, 1}}, false)));
    }

    @Test
    void aSingleVertexNeedsNoEdges() {
        assertEquals(0, Prim.totalWeight(Graphs.weighted(1, new int[][] {}, false)));
    }

    @Test
    void picksTheCheapEdgeOutOfTheTreeNotTheCheapestOverall() {
        int[][] edges = {{0, 1, 5}, {1, 2, 1}, {0, 2, 6}};
        assertEquals(6, Prim.totalWeight(Graphs.weighted(3, edges, false)));
    }
}
