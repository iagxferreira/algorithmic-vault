package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    private static BinarySearchTree treeOf(int... values) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : values) {
            tree.insert(value);
        }
        return tree;
    }

    @Test
    void inOrderWalkIsSorted() {
        BinarySearchTree tree = treeOf(5, 3, 8, 1, 4, 7, 9);
        assertEquals(List.of(1, 3, 4, 5, 7, 8, 9), tree.inOrder());
    }

    @Test
    void ignoresDuplicates() {
        BinarySearchTree tree = treeOf(5, 5, 5);
        assertEquals(1, tree.size());
        assertEquals(List.of(5), tree.inOrder());
    }

    @Test
    void findsMinMaxAndMembership() {
        BinarySearchTree tree = treeOf(5, 3, 8, 1, 9);
        assertEquals(1, tree.min());
        assertEquals(9, tree.max());
        assertTrue(tree.contains(8));
        assertFalse(tree.contains(6));
    }

    @Test
    void heightCountsEdgesOnTheLongestPath() {
        assertEquals(-1, new BinarySearchTree().height());
        assertEquals(0, treeOf(5).height());
        assertEquals(2, treeOf(5, 3, 8, 1).height());
    }

    @Test
    void deletesALeaf() {
        BinarySearchTree tree = treeOf(5, 3, 8);
        assertTrue(tree.delete(3));
        assertEquals(List.of(5, 8), tree.inOrder());
        assertEquals(2, tree.size());
    }

    @Test
    void deletesANodeWithOneChild() {
        BinarySearchTree tree = treeOf(5, 3, 8, 1);
        assertTrue(tree.delete(3));
        assertEquals(List.of(1, 5, 8), tree.inOrder());
    }

    @Test
    void deletesANodeWithTwoChildren() {
        BinarySearchTree tree = treeOf(5, 3, 8, 7, 9);
        assertTrue(tree.delete(8));
        assertEquals(List.of(3, 5, 7, 9), tree.inOrder());
    }

    @Test
    void deletesTheRoot() {
        BinarySearchTree tree = treeOf(5, 3, 8, 1, 4, 7, 9);
        assertTrue(tree.delete(5));
        assertEquals(List.of(1, 3, 4, 7, 8, 9), tree.inOrder());
    }

    @Test
    void deletingAnAbsentValueChangesNothing() {
        BinarySearchTree tree = treeOf(5, 3, 8);
        assertFalse(tree.delete(42));
        assertEquals(3, tree.size());
    }
}
