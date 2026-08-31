package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class DepthFirstSearchTest {

    @Test
    void divesBeforeBacktracking() {
        assertEquals(List.of(0, 1, 3, 2, 4), DepthFirstSearch.traverse(Graphs.sample(), 0));
    }

    @Test
    void theIterativeFormMatchesTheRecursiveOne() {
        assertEquals(
                DepthFirstSearch.traverse(Graphs.sample(), 0),
                DepthFirstSearch.traverseIterative(Graphs.sample(), 0));
    }

    @Test
    void anIsolatedVertexOnlyReachesItself() {
        assertEquals(List.of(5), DepthFirstSearch.traverse(Graphs.sample(), 5));
        assertEquals(List.of(5), DepthFirstSearch.traverseIterative(Graphs.sample(), 5));
    }

    @Test
    void reportsReachability() {
        assertArrayEquals(
                new boolean[] {true, true, true, true, true, false},
                DepthFirstSearch.reachableFrom(Graphs.sample(), 0));
    }

    @Test
    void followsDirectedEdgesOneWay() {
        List<List<Integer>> directed = Graphs.unweighted(3, new int[][] {{0, 1}, {1, 2}}, true);
        assertEquals(List.of(0, 1, 2), DepthFirstSearch.traverse(directed, 0));
        assertEquals(List.of(2), DepthFirstSearch.traverse(directed, 2));
    }
}
