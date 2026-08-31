package dsa.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class PreOrderTest {

    @Test
    void visitsNodeBeforeItsChildren() {
        assertEquals(List.of(1, 2, 4, 5, 3, 6), PreOrder.traverse(Trees.sample()));
    }

    @Test
    void handlesEmptyAndSingleNodeTrees() {
        assertEquals(List.of(), PreOrder.traverse(null));
        assertEquals(List.of(), PreOrder.traverseIterative(null));
        assertEquals(List.of(7), PreOrder.traverse(dsa.support.TreeNodes.of(7)));
    }

    @Test
    void handlesADegenerateChain() {
        assertEquals(List.of(3, 2, 1), PreOrder.traverse(Trees.chain()));
    }

    @Test
    void theIterativeFormMatchesTheRecursiveOne() {
        assertEquals(PreOrder.traverse(Trees.sample()), PreOrder.traverseIterative(Trees.sample()));
        assertEquals(PreOrder.traverse(Trees.bst()), PreOrder.traverseIterative(Trees.bst()));
        assertEquals(PreOrder.traverse(Trees.chain()), PreOrder.traverseIterative(Trees.chain()));
    }
}
