package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import dsa.support.TestGraphs;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ShortestPathsTest {

    private static final int INF = Integer.MAX_VALUE;

    @Nested
    class Dijkstra {

        /** 0->1 (4), 0->2 (1), 2->1 (2), 1->3 (1), 2->3 (5); vertex 4 is stranded. */
        private final List<List<int[]>> graph = TestGraphs.weighted(
                5, new int[][] {{0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {1, 3, 1}, {2, 3, 5}}, true);

        @Test
        void prefersTheCheapDetourOverTheDirectEdge() {
            assertArrayEquals(new int[] {0, 3, 1, 4, INF}, ShortestPaths.dijkstra(graph, 0));
        }

        @Test
        void rebuildsTheCheapestPath() {
            assertEquals(List.of(0, 2, 1, 3), ShortestPaths.dijkstraPath(graph, 0, 3));
            assertEquals(List.of(0), ShortestPaths.dijkstraPath(graph, 0, 0));
            assertEquals(List.of(), ShortestPaths.dijkstraPath(graph, 0, 4));
        }

        @Test
        void handlesAnUndirectedGraph() {
            List<List<int[]>> undirected =
                    TestGraphs.weighted(4, new int[][] {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 10}}, false);
            assertArrayEquals(new int[] {0, 1, 2, 3}, ShortestPaths.dijkstra(undirected, 0));
        }
    }

    @Nested
    class BellmanFord {

        @Test
        void handlesNegativeEdges() {
            int[][] edges = {{0, 1, 1}, {1, 2, -1}, {2, 3, -1}, {0, 3, 5}};
            assertArrayEquals(new int[] {0, 1, 0, -1}, ShortestPaths.bellmanFord(4, edges, 0));
        }

        @Test
        void reportsANegativeCycle() {
            int[][] edges = {{0, 1, 1}, {1, 2, -1}, {2, 1, -1}};
            assertNull(ShortestPaths.bellmanFord(3, edges, 0));
        }

        @Test
        void marksUnreachableVertices() {
            assertArrayEquals(new int[] {0, 2, INF}, ShortestPaths.bellmanFord(3, new int[][] {{0, 1, 2}}, 0));
        }
    }

    @Nested
    class FloydWarshall {

        @Test
        void fillsInTransitiveDistances() {
            int[][] matrix = {
                {0, 3, INF},
                {INF, 0, 1},
                {INF, INF, 0}
            };
            int[][] expected = {
                {0, 3, 4},
                {INF, 0, 1},
                {INF, INF, 0}
            };
            assertArrayEquals(expected, ShortestPaths.floydWarshall(matrix));
        }

        @Test
        void doesNotMutateTheInput() {
            int[][] matrix = {{0, 3, INF}, {INF, 0, 1}, {INF, INF, 0}};
            ShortestPaths.floydWarshall(matrix);
            assertEquals(INF, matrix[0][2]);
        }
    }
}
