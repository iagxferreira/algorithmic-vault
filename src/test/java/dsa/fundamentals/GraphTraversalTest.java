package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.TestGraphs;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GraphTraversalTest {

    /**
     *   0 - 1 - 3      5
     *   |
     *   2 - 4
     */
    private static final List<List<Integer>> UNDIRECTED =
            TestGraphs.unweighted(6, new int[][] {{0, 1}, {0, 2}, {1, 3}, {2, 4}}, false);

    @Nested
    class Ordering {

        @Test
        void dfsDivesBeforeBacktracking() {
            assertEquals(List.of(0, 1, 3, 2, 4), GraphTraversal.dfs(UNDIRECTED, 0));
        }

        @Test
        void iterativeDfsMatchesTheRecursiveOne() {
            assertEquals(GraphTraversal.dfs(UNDIRECTED, 0), GraphTraversal.dfsIterative(UNDIRECTED, 0));
        }

        @Test
        void bfsExpandsInRings() {
            assertEquals(List.of(0, 1, 2, 3, 4), GraphTraversal.bfs(UNDIRECTED, 0));
        }

        @Test
        void anIsolatedVertexOnlyReachesItself() {
            assertEquals(List.of(5), GraphTraversal.dfs(UNDIRECTED, 5));
            assertEquals(List.of(5), GraphTraversal.bfs(UNDIRECTED, 5));
        }
    }

    @Nested
    class Distances {

        @Test
        void countsHopsAndMarksUnreachable() {
            assertArrayEquals(new int[] {0, 1, 1, 2, 2, -1}, GraphTraversal.distancesFrom(UNDIRECTED, 0));
        }

        @Test
        void rebuildsAShortestPath() {
            assertEquals(List.of(0, 2, 4), GraphTraversal.shortestPath(UNDIRECTED, 0, 4));
            assertEquals(List.of(0), GraphTraversal.shortestPath(UNDIRECTED, 0, 0));
            assertEquals(List.of(), GraphTraversal.shortestPath(UNDIRECTED, 0, 5));
        }
    }

    @Nested
    class Components {

        @Test
        void countsConnectedComponents() {
            assertEquals(2, GraphTraversal.countComponents(UNDIRECTED));
            assertEquals(4, GraphTraversal.countComponents(TestGraphs.unweighted(4, new int[][] {}, false)));
            assertEquals(1, GraphTraversal.countComponents(TestGraphs.unweighted(2, new int[][] {{0, 1}}, false)));
        }
    }

    @Nested
    class Cycles {

        @Test
        void doesNotMistakeTheParentEdgeForACycle() {
            assertFalse(GraphTraversal.hasCycleUndirected(
                    TestGraphs.unweighted(3, new int[][] {{0, 1}, {1, 2}}, false)));
        }

        @Test
        void findsAnUndirectedCycle() {
            assertTrue(GraphTraversal.hasCycleUndirected(
                    TestGraphs.unweighted(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, false)));
        }

        @Test
        void findsADirectedCycle() {
            assertFalse(GraphTraversal.hasCycleDirected(
                    TestGraphs.unweighted(3, new int[][] {{0, 1}, {1, 2}}, true)));
            assertTrue(GraphTraversal.hasCycleDirected(
                    TestGraphs.unweighted(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, true)));
        }

        @Test
        void twoEdgesIntoOneVertexAreNotACycle() {
            assertFalse(GraphTraversal.hasCycleDirected(
                    TestGraphs.unweighted(3, new int[][] {{0, 2}, {1, 2}}, true)));
        }
    }

    @Nested
    class TopologicalOrder {

        @Test
        void ordersADag() {
            List<List<Integer>> dag = TestGraphs.unweighted(
                    6, new int[][] {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}}, true);
            assertEquals(List.of(4, 5, 0, 2, 3, 1), GraphTraversal.topologicalSort(dag));
        }

        @Test
        void reportsCyclesAsAnEmptyOrder() {
            assertEquals(List.of(), GraphTraversal.topologicalSort(
                    TestGraphs.unweighted(2, new int[][] {{0, 1}, {1, 0}}, true)));
        }

        @Test
        void handlesAGraphWithNoEdges() {
            assertEquals(List.of(0, 1, 2), GraphTraversal.topologicalSort(
                    TestGraphs.unweighted(3, new int[][] {}, true)));
        }
    }

    @Nested
    class Bipartite {

        @Test
        void acceptsAnEvenCycle() {
            assertTrue(GraphTraversal.isBipartite(
                    TestGraphs.unweighted(4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, false)));
        }

        @Test
        void rejectsAnOddCycle() {
            assertFalse(GraphTraversal.isBipartite(
                    TestGraphs.unweighted(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, false)));
        }

        @Test
        void checksEveryComponent() {
            assertFalse(GraphTraversal.isBipartite(
                    TestGraphs.unweighted(5, new int[][] {{0, 1}, {2, 3}, {3, 4}, {4, 2}}, false)));
        }
    }
}
