package dsa.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dsa.support.TreeNodes;
import java.util.List;
import org.junit.jupiter.api.Test;

class TreeMetricsTest {

    @Test
    void heightCountsEdges() {
        assertEquals(-1, TreeMetrics.height(null));
        assertEquals(0, TreeMetrics.height(TreeNodes.of(1)));
        assertEquals(2, TreeMetrics.height(Trees.sample()));
        assertEquals(2, TreeMetrics.height(Trees.chain()));
    }

    @Test
    void countsNodesAndLeaves() {
        assertEquals(0, TreeMetrics.countNodes(null));
        assertEquals(6, TreeMetrics.countNodes(Trees.sample()));
        assertEquals(0, TreeMetrics.countLeaves(null));
        assertEquals(3, TreeMetrics.countLeaves(Trees.sample()));
        assertEquals(1, TreeMetrics.countLeaves(Trees.chain()));
        assertEquals(1, TreeMetrics.countLeaves(TreeNodes.of(1)));
    }

    @Test
    void collectsRootToLeafPaths() {
        assertEquals(
                List.of(List.of(1, 2, 4), List.of(1, 2, 5), List.of(1, 3, 6)),
                TreeMetrics.rootToLeafPaths(Trees.sample()));
        assertEquals(List.of(), TreeMetrics.rootToLeafPaths(null));
        assertEquals(List.of(List.of(7)), TreeMetrics.rootToLeafPaths(TreeNodes.of(7)));
    }

    @Test
    void diameterCanPassThroughTheRoot() {
        assertEquals(3, TreeMetrics.diameter(TreeNodes.of(1, 2, 3, 4, 5)));
    }

    @Test
    void diameterCanSkipTheRoot() {
        assertEquals(3, TreeMetrics.diameter(TreeNodes.of(1, 2, null, 3, 4, null, null, 5)),
                "the longest path here is 3 - 2 - 4 - 5");
    }

    @Test
    void diameterOfTinyTrees() {
        assertEquals(0, TreeMetrics.diameter(null));
        assertEquals(0, TreeMetrics.diameter(TreeNodes.of(1)));
        assertEquals(1, TreeMetrics.diameter(TreeNodes.of(1, 2)));
    }
}
