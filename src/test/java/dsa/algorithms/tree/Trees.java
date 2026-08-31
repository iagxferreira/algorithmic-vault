package dsa.algorithms.tree;

import dsa.support.TreeNode;
import dsa.support.TreeNodes;

/** The sample trees the traversal tests share. Test-only plumbing. */
final class Trees {

    private Trees() {
    }

    /**
     * <pre>
     *        1
     *       / \
     *      2   3
     *     / \   \
     *    4   5   6
     * </pre>
     */
    static TreeNode sample() {
        return TreeNodes.of(1, 2, 3, 4, 5, null, 6);
    }

    /** A valid bst: 8, 3, 10, 1, 6, _, 14. */
    static TreeNode bst() {
        return TreeNodes.of(8, 3, 10, 1, 6, null, 14);
    }

    /** A left-leaning chain 3 - 2 - 1, i.e. the degenerate case. */
    static TreeNode chain() {
        return TreeNodes.of(3, 2, null, 1);
    }
}
