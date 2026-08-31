package dsa.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.TreeNodes;
import java.util.List;
import org.junit.jupiter.api.Test;

class InOrderTest {

    @Test
    void visitsLeftThenNodeThenRight() {
        assertEquals(List.of(4, 2, 5, 1, 3, 6), InOrder.traverse(Trees.sample()));
    }

    @Test
    void aBstComesOutSorted() {
        assertEquals(List.of(1, 3, 6, 8, 10, 14), InOrder.traverse(Trees.bst()));
        assertEquals(List.of(1, 2, 3), InOrder.traverse(Trees.chain()));
    }

    @Test
    void handlesEmptyTrees() {
        assertEquals(List.of(), InOrder.traverse(null));
        assertEquals(List.of(), InOrder.traverseIterative(null));
    }

    @Test
    void theIterativeFormMatchesTheRecursiveOne() {
        assertEquals(InOrder.traverse(Trees.sample()), InOrder.traverseIterative(Trees.sample()));
        assertEquals(InOrder.traverse(Trees.bst()), InOrder.traverseIterative(Trees.bst()));
        assertEquals(InOrder.traverse(Trees.chain()), InOrder.traverseIterative(Trees.chain()));
    }

    @Test
    void recognisesAValidBst() {
        assertTrue(InOrder.isBinarySearchTree(Trees.bst()));
        assertTrue(InOrder.isBinarySearchTree(null));
        assertTrue(InOrder.isBinarySearchTree(TreeNodes.of(2, 1, 3)));
    }

    @Test
    void rejectsAViolationDeeperThanTheParent() {
        assertFalse(InOrder.isBinarySearchTree(TreeNodes.of(5, 1, 4, null, null, 3, 6)),
                "3 sits in the right subtree of 5");
        assertFalse(InOrder.isBinarySearchTree(TreeNodes.of(2, 2, 3)), "duplicates are not strictly increasing");
    }
}
