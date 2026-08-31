package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CycleDetectionTest {

    @Test
    void undirectedDoesNotMistakeTheParentEdgeForACycle() {
        assertFalse(CycleDetection.hasCycleUndirected(
                Graphs.unweighted(3, new int[][] {{0, 1}, {1, 2}}, false)));
        assertFalse(CycleDetection.hasCycleUndirected(Graphs.sample()));
    }

    @Test
    void undirectedFindsARealCycle() {
        assertTrue(CycleDetection.hasCycleUndirected(
                Graphs.unweighted(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, false)));
    }

    @Test
    void undirectedChecksEveryComponent() {
        assertTrue(CycleDetection.hasCycleUndirected(
                Graphs.unweighted(6, new int[][] {{0, 1}, {2, 3}, {3, 4}, {4, 2}}, false)),
                "the cycle is in the second component");
    }

    @Test
    void directedFindsABackEdge() {
        assertFalse(CycleDetection.hasCycleDirected(
                Graphs.unweighted(3, new int[][] {{0, 1}, {1, 2}}, true)));
        assertTrue(CycleDetection.hasCycleDirected(
                Graphs.unweighted(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, true)));
    }

    @Test
    void directedAllowsTwoEdgesIntoOneVertex() {
        assertFalse(CycleDetection.hasCycleDirected(
                Graphs.unweighted(3, new int[][] {{0, 2}, {1, 2}}, true)),
                "a revisited but finished vertex is not a back edge");
    }

    @Test
    void directedAllowsADiamond() {
        assertFalse(CycleDetection.hasCycleDirected(
                Graphs.unweighted(4, new int[][] {{0, 1}, {0, 2}, {1, 3}, {2, 3}}, true)));
    }

    @Test
    void directedFindsASelfLoop() {
        assertTrue(CycleDetection.hasCycleDirected(Graphs.unweighted(1, new int[][] {{0, 0}}, true)));
    }
}
