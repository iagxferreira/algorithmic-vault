package dsa.exercises.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.TreeNodes;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TreesExercisesTest {

    @Nested
    class InvertBinaryTreeTest {

        @Test
        void mirrorsTheTree() {
            assertEquals(
                    List.of(4, 7, 2, 9, 6, 3, 1),
                    TreeNodes.toLevelOrder(InvertBinaryTree.solve(TreeNodes.of(4, 2, 7, 1, 3, 6, 9))));
        }

        @Test
        void handlesEmptyAndLopsidedTrees() {
            assertNull(InvertBinaryTree.solve(null));
            assertEquals(
                    Arrays.asList(2, 3, 1),
                    TreeNodes.toLevelOrder(InvertBinaryTree.solve(TreeNodes.of(2, 1, 3))));
        }
    }

    @Nested
    class SameTreeTest {

        @Test
        void acceptsIdenticalTrees() {
            assertTrue(SameTree.solve(TreeNodes.of(1, 2, 3), TreeNodes.of(1, 2, 3)));
            assertTrue(SameTree.solve(null, null));
        }

        @Test
        void rejectsDifferentShapesOrValues() {
            assertFalse(SameTree.solve(TreeNodes.of(1, 2), TreeNodes.of(1, null, 2)));
            assertFalse(SameTree.solve(TreeNodes.of(1, 2, 1), TreeNodes.of(1, 1, 2)));
            assertFalse(SameTree.solve(TreeNodes.of(1), null));
        }
    }

    @Nested
    class ValidateBinarySearchTreeTest {

        @Test
        void acceptsValidTrees() {
            assertTrue(ValidateBinarySearchTree.solve(TreeNodes.of(2, 1, 3)));
            assertTrue(ValidateBinarySearchTree.solve(null));
            assertTrue(ValidateBinarySearchTree.solve(TreeNodes.of(5, 1, 7, null, null, 6, 8)));
        }

        @Test
        void rejectsAViolationDeeperThanTheParent() {
            assertFalse(ValidateBinarySearchTree.solve(TreeNodes.of(5, 1, 4, null, null, 3, 6)));
        }

        @Test
        void rejectsDuplicates() {
            assertFalse(ValidateBinarySearchTree.solve(TreeNodes.of(2, 2, 3)));
        }

        @Test
        void handlesExtremeValues() {
            assertTrue(ValidateBinarySearchTree.solve(TreeNodes.of(Integer.MIN_VALUE, null, Integer.MAX_VALUE)));
        }
    }

    @Nested
    class LowestCommonAncestorTest {

        @Test
        void findsTheSplittingNode() {
            assertEquals(6, LowestCommonAncestor.solve(TreeNodes.of(6, 2, 8, 0, 4, 7, 9), 2, 8).val);
            assertEquals(2, LowestCommonAncestor.solve(TreeNodes.of(6, 2, 8, 0, 4, 7, 9), 0, 4).val);
        }

        @Test
        void treatsANodeAsItsOwnDescendant() {
            assertEquals(2, LowestCommonAncestor.solve(TreeNodes.of(6, 2, 8, 0, 4, 7, 9), 2, 4).val);
            assertEquals(2, LowestCommonAncestor.solve(TreeNodes.of(2, 1), 2, 1).val);
        }
    }

    @Nested
    class KthSmallestInBstTest {

        @Test
        void countsInSortedOrder() {
            assertEquals(1, KthSmallestInBst.solve(TreeNodes.of(3, 1, 4, null, 2), 1));
            assertEquals(2, KthSmallestInBst.solve(TreeNodes.of(3, 1, 4, null, 2), 2));
            assertEquals(4, KthSmallestInBst.solve(TreeNodes.of(3, 1, 4, null, 2), 4));
        }

        @Test
        void handlesADeeperTree() {
            assertEquals(3, KthSmallestInBst.solve(TreeNodes.of(5, 3, 6, 2, 4, null, null, 1), 3));
        }
    }

    @Nested
    class DiameterOfBinaryTreeTest {

        @Test
        void measuresThroughTheRoot() {
            assertEquals(3, DiameterOfBinaryTree.solve(TreeNodes.of(1, 2, 3, 4, 5)));
        }

        @Test
        void measuresAPathThatSkipsTheRoot() {
            assertEquals(3, DiameterOfBinaryTree.solve(TreeNodes.of(1, 2, null, 3, 4, null, null, 5)));
        }

        @Test
        void handlesTinyTrees() {
            assertEquals(0, DiameterOfBinaryTree.solve(TreeNodes.of(1)));
            assertEquals(1, DiameterOfBinaryTree.solve(TreeNodes.of(1, 2)));
            assertEquals(0, DiameterOfBinaryTree.solve(null));
        }
    }

    @Nested
    class BuildTreeFromTraversalsTest {

        @Test
        void rebuildsTheTree() {
            assertEquals(
                    Arrays.asList(3, 9, 20, null, null, 15, 7),
                    TreeNodes.toLevelOrder(BuildTreeFromTraversals.solve(
                            new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7})));
        }

        @Test
        void handlesSingleNodeAndEmptyInput() {
            assertEquals(
                    List.of(-1),
                    TreeNodes.toLevelOrder(BuildTreeFromTraversals.solve(new int[] {-1}, new int[] {-1})));
            assertNull(BuildTreeFromTraversals.solve(new int[] {}, new int[] {}));
        }

        @Test
        void rebuildsADegenerateChain() {
            assertEquals(
                    Arrays.asList(1, 2, null, 3),
                    TreeNodes.toLevelOrder(BuildTreeFromTraversals.solve(
                            new int[] {1, 2, 3}, new int[] {3, 2, 1})));
        }
    }
}
