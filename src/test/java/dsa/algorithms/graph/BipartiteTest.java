package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BipartiteTest {

    @Test
    void acceptsAnEvenCycle() {
        assertTrue(Bipartite.isBipartite(
                Graphs.unweighted(4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, false)));
    }

    @Test
    void rejectsAnOddCycle() {
        assertFalse(Bipartite.isBipartite(
                Graphs.unweighted(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, false)));
    }

    @Test
    void checksEveryComponent() {
        assertFalse(Bipartite.isBipartite(
                Graphs.unweighted(5, new int[][] {{0, 1}, {2, 3}, {3, 4}, {4, 2}}, false)),
                "the odd cycle is hidden in the second component");
    }

    @Test
    void anEdgelessGraphIsTrivallyBipartite() {
        assertTrue(Bipartite.isBipartite(Graphs.unweighted(3, new int[][] {}, false)));
        assertArrayEquals(new int[] {0, 0, 0}, Bipartite.colours(Graphs.unweighted(3, new int[][] {}, false)));
    }

    @Test
    void producesAValidTwoColouring() {
        int[] colours = Bipartite.colours(Graphs.unweighted(4, new int[][] {{0, 1}, {1, 2}, {2, 3}}, false));
        assertArrayEquals(new int[] {0, 1, 0, 1}, colours);
    }

    @Test
    void colouringIsNullWhenNotBipartite() {
        assertNull(Bipartite.colours(Graphs.unweighted(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, false)));
    }
}
