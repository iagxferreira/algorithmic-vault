package dsa.support;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** Builders and inspectors for {@link TreeNode} trees, used mostly by tests. */
public final class TreeNodes {

    private TreeNodes() {
    }

    /**
     * Builds a tree from its level order form, where {@code null} marks a
     * missing child. Example: {@code of(1, 2, 3, null, 4)} builds
     *
     * <pre>
     *     1
     *    / \
     *   2   3
     *    \
     *     4
     * </pre>
     */
    public static TreeNode of(Integer... levelOrder) {
        if (levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode node = queue.poll();
            if (i < levelOrder.length && levelOrder[i] != null) {
                node.left = new TreeNode(levelOrder[i]);
                queue.add(node.left);
            }
            i++;
            if (i < levelOrder.length && levelOrder[i] != null) {
                node.right = new TreeNode(levelOrder[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    /** Level order values of the tree, with trailing nulls trimmed. */
    public static List<Integer> toLevelOrder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) {
            return out;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                out.add(null);
                continue;
            }
            out.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        while (!out.isEmpty() && out.get(out.size() - 1) == null) {
            out.remove(out.size() - 1);
        }
        return out;
    }
}
