package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BellmanFordTest {

    private static final int INF = Integer.MAX_VALUE;

    @Test
    void handlesNegativeEdges() {
        int[][] edges = {{0, 1, 1}, {1, 2, -1}, {2, 3, -1}, {0, 3, 5}};
        assertArrayEquals(new int[] {0, 1, 0, -1}, BellmanFord.distances(4, edges, 0));
    }

    @Test
    void reportsANegativeCycle() {
        int[][] edges = {{0, 1, 1}, {1, 2, -1}, {2, 1, -1}};
        assertNull(BellmanFord.distances(3, edges, 0));
    }

    @Test
    void ignoresANegativeCycleTheSourceCannotReach() {
        int[][] edges = {{0, 1, 1}, {2, 3, -1}, {3, 2, -1}};
        assertArrayEquals(new int[] {0, 1, INF, INF}, BellmanFord.distances(4, edges, 0));
    }

    @Test
    void marksUnreachableVertices() {
        assertArrayEquals(new int[] {0, 2, INF}, BellmanFord.distances(3, new int[][] {{0, 1, 2}}, 0));
    }

    @Test
    void agreesWithDijkstraWhenAllWeightsArePositive() {
        int[][] edges = {{0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {1, 3, 1}, {2, 3, 5}};
        assertArrayEquals(new int[] {0, 3, 1, 4}, BellmanFord.distances(4, edges, 0));
    }

    @Test
    void capsTheNumberOfEdgesUsed() {
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}};
        assertArrayEquals(new int[] {0, 1, INF, INF}, BellmanFord.distancesWithin(4, edges, 0, 1));
        assertArrayEquals(new int[] {0, 1, 2, INF}, BellmanFord.distancesWithin(4, edges, 0, 2));
        assertArrayEquals(new int[] {0, 1, 2, 3}, BellmanFord.distancesWithin(4, edges, 0, 3));
    }

    @Test
    void aCappedRunPrefersFewerEdgesOverLowerCost() {
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {0, 2, 10}};
        assertArrayEquals(new int[] {0, 1, 10}, BellmanFord.distancesWithin(3, edges, 0, 1),
                "with one edge allowed, the expensive direct route is the only option");
    }
}
