package dsa.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class PostOrderTest {

    @Test
    void visitsChildrenBeforeTheirParent() {
        assertEquals(List.of(4, 5, 2, 6, 3, 1), PostOrder.traverse(Trees.sample()));
    }

    @Test
    void handlesEmptyAndChainTrees() {
        assertEquals(List.of(), PostOrder.traverse(null));
        assertEquals(List.of(), PostOrder.traverseIterative(null));
        assertEquals(List.of(1, 2, 3), PostOrder.traverse(Trees.chain()));
    }

    @Test
    void theRootIsAlwaysLast() {
        assertEquals(1, PostOrder.traverse(Trees.sample()).get(5));
        assertEquals(8, PostOrder.traverse(Trees.bst()).get(5));
    }

    @Test
    void theIterativeFormMatchesTheRecursiveOne() {
        assertEquals(PostOrder.traverse(Trees.sample()), PostOrder.traverseIterative(Trees.sample()));
        assertEquals(PostOrder.traverse(Trees.bst()), PostOrder.traverseIterative(Trees.bst()));
        assertEquals(PostOrder.traverse(Trees.chain()), PostOrder.traverseIterative(Trees.chain()));
    }
}
