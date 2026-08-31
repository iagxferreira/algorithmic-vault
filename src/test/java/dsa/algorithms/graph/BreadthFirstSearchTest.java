package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BreadthFirstSearchTest {

    @Test
    void expandsInRings() {
        assertEquals(List.of(0, 1, 2, 3, 4), BreadthFirstSearch.traverse(Graphs.sample(), 0));
        assertEquals(List.of(5), BreadthFirstSearch.traverse(Graphs.sample(), 5));
    }

    @Test
    void countsHopsAndMarksUnreachable() {
        assertArrayEquals(new int[] {0, 1, 1, 2, 2, -1}, BreadthFirstSearch.distancesFrom(Graphs.sample(), 0));
    }

    @Test
    void rebuildsAShortestPath() {
        assertEquals(List.of(0, 2, 4), BreadthFirstSearch.shortestPath(Graphs.sample(), 0, 4));
        assertEquals(List.of(0), BreadthFirstSearch.shortestPath(Graphs.sample(), 0, 0));
        assertEquals(List.of(), BreadthFirstSearch.shortestPath(Graphs.sample(), 0, 5));
    }

    @Test
    void takesTheShortRouteNotTheFirstOneFound() {
        List<List<Integer>> graph = Graphs.unweighted(
                4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {0, 3}}, false);
        assertEquals(1, BreadthFirstSearch.distancesFrom(graph, 0)[3]);
        assertEquals(List.of(0, 3), BreadthFirstSearch.shortestPath(graph, 0, 3));
    }

    @Test
    void multiSourceMeasuresFromTheNearestStart() {
        assertArrayEquals(
                new int[] {1, 0, 2, 1, 3, -1},
                BreadthFirstSearch.distancesFromAny(Graphs.sample(), new int[] {1}));
        assertArrayEquals(
                new int[] {0, 0, 1, 1, 2, -1},
                BreadthFirstSearch.distancesFromAny(Graphs.sample(), new int[] {0, 1}));
    }

    @Test
    void noSourcesLeavesEverythingUnreachable() {
        assertArrayEquals(
                new int[] {-1, -1, -1, -1, -1, -1},
                BreadthFirstSearch.distancesFromAny(Graphs.sample(), new int[] {}));
    }
}
