package dsa.fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dsa.support.TreeNode;
import dsa.support.TreeNodes;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TreeTraversalTest {

    /**
     *        1
     *       / \
     *      2   3
     *     / \   \
     *    4   5   6
     */
    private static final TreeNode TREE = TreeNodes.of(1, 2, 3, 4, 5, null, 6);

    @Nested
    class DepthFirst {

        @Test
        void preOrderVisitsNodeThenChildren() {
            assertEquals(List.of(1, 2, 4, 5, 3, 6), TreeTraversal.preOrder(TREE));
            assertEquals(List.of(), TreeTraversal.preOrder(null));
        }

        @Test
        void inOrderVisitsLeftThenNodeThenRight() {
            assertEquals(List.of(4, 2, 5, 1, 3, 6), TreeTraversal.inOrder(TREE));
            assertEquals(List.of(), TreeTraversal.inOrder(null));
        }

        @Test
        void postOrderVisitsChildrenThenNode() {
            assertEquals(List.of(4, 5, 2, 6, 3, 1), TreeTraversal.postOrder(TREE));
            assertEquals(List.of(), TreeTraversal.postOrder(null));
        }

        @Test
        void iterativeFormsMatchTheRecursiveOnes() {
            assertEquals(TreeTraversal.preOrder(TREE), TreeTraversal.preOrderIterative(TREE));
            assertEquals(TreeTraversal.inOrder(TREE), TreeTraversal.inOrderIterative(TREE));
            assertEquals(TreeTraversal.postOrder(TREE), TreeTraversal.postOrderIterative(TREE));
        }

        @Test
        void inOrderOfABstIsSorted() {
            TreeNode bst = TreeNodes.of(8, 3, 10, 1, 6, null, 14);
            assertEquals(List.of(1, 3, 6, 8, 10, 14), TreeTraversal.inOrder(bst));
        }

        @Test
        void handlesADegenerateLeftChain() {
            TreeNode chain = TreeNodes.of(3, 2, null, 1);
            assertEquals(List.of(1, 2, 3), TreeTraversal.inOrder(chain));
            assertEquals(List.of(3, 2, 1), TreeTraversal.preOrder(chain));
            assertEquals(List.of(1, 2, 3), TreeTraversal.postOrder(chain));
        }
    }

    @Nested
    class BreadthFirst {

        @Test
        void levelOrderGroupsByDepth() {
            assertEquals(List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6)), TreeTraversal.levelOrder(TREE));
            assertEquals(List.of(), TreeTraversal.levelOrder(null));
        }

        @Test
        void zigzagAlternatesDirection() {
            assertEquals(List.of(List.of(1), List.of(3, 2), List.of(4, 5, 6)), TreeTraversal.zigzagLevelOrder(TREE));
        }

        @Test
        void rightSideViewTakesTheLastOfEachLevel() {
            assertEquals(List.of(1, 3, 6), TreeTraversal.rightSideView(TREE));
            assertEquals(List.of(), TreeTraversal.rightSideView(null));
        }
    }

    @Nested
    class Aggregates {

        @Test
        void heightCountsEdges() {
            assertEquals(-1, TreeTraversal.height(null));
            assertEquals(0, TreeTraversal.height(TreeNodes.of(1)));
            assertEquals(2, TreeTraversal.height(TREE));
        }

        @Test
        void countsNodes() {
            assertEquals(0, TreeTraversal.countNodes(null));
            assertEquals(6, TreeTraversal.countNodes(TREE));
        }

        @Test
        void collectsRootToLeafPaths() {
            assertEquals(
                    List.of(List.of(1, 2, 4), List.of(1, 2, 5), List.of(1, 3, 6)),
                    TreeTraversal.rootToLeafPaths(TREE));
            assertEquals(List.of(), TreeTraversal.rootToLeafPaths(null));
            assertEquals(List.of(List.of(7)), TreeTraversal.rootToLeafPaths(TreeNodes.of(7)));
        }
    }
}
