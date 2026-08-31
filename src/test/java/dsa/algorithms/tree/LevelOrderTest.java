package dsa.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dsa.support.TreeNodes;
import java.util.List;
import org.junit.jupiter.api.Test;

class LevelOrderTest {

    @Test
    void groupsByDepth() {
        assertEquals(List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6)), LevelOrder.traverse(Trees.sample()));
        assertEquals(List.of(), LevelOrder.traverse(null));
        assertEquals(List.of(List.of(7)), LevelOrder.traverse(TreeNodes.of(7)));
    }

    @Test
    void zigzagAlternatesDirection() {
        assertEquals(List.of(List.of(1), List.of(3, 2), List.of(4, 5, 6)), LevelOrder.zigzag(Trees.sample()));
        assertEquals(List.of(), LevelOrder.zigzag(null));
    }

    @Test
    void rightSideViewTakesTheLastOfEachLevel() {
        assertEquals(List.of(1, 3, 6), LevelOrder.rightSideView(Trees.sample()));
        assertEquals(List.of(3, 2, 1), LevelOrder.rightSideView(Trees.chain()),
                "a left-only chain is still visible from the right");
        assertEquals(List.of(), LevelOrder.rightSideView(null));
    }

    @Test
    void minDepthStopsAtTheShallowestLeaf() {
        assertEquals(0, LevelOrder.minDepth(TreeNodes.of(1)));
        assertEquals(2, LevelOrder.minDepth(Trees.sample()));
        assertEquals(2, LevelOrder.minDepth(Trees.chain()), "the only leaf is two edges down");
        assertEquals(-1, LevelOrder.minDepth(null));
    }

    @Test
    void minDepthDoesNotMistakeAOneChildNodeForALeaf() {
        assertEquals(2, LevelOrder.minDepth(TreeNodes.of(1, 2, null, 3)),
                "node 2 has a child, so it is not a leaf");
    }
}
