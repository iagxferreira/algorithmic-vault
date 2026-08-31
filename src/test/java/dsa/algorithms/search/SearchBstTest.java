package dsa.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.TreeNode;
import dsa.support.TreeNodes;
import org.junit.jupiter.api.Test;

class SearchBstTest {

    private final TreeNode root = TreeNodes.of(8, 3, 10, 1, 6, null, 14);

    @Test
    void findsValuesAtEveryDepth() {
        assertTrue(SearchBst.contains(root, 8));
        assertTrue(SearchBst.contains(root, 3));
        assertTrue(SearchBst.contains(root, 1));
        assertTrue(SearchBst.contains(root, 14));
    }

    @Test
    void rejectsAbsentValues() {
        assertFalse(SearchBst.contains(root, 7));
        assertFalse(SearchBst.contains(root, 100));
    }

    @Test
    void handlesAnEmptyTree() {
        assertFalse(SearchBst.contains(null, 1));
    }

    @Test
    void walksADegenerateChain() {
        assertTrue(SearchBst.contains(TreeNodes.of(3, 2, null, 1), 1));
    }
}
