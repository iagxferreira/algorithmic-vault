package dsa.structures;

import java.util.List;

/**
 * An unbalanced binary search tree over ints.
 *
 * <p>Invariant: everything in the left subtree is smaller than the node, and
 * everything in the right subtree is larger. That invariant is what makes an
 * in-order walk come out sorted.
 *
 * <p>Deletion is the interesting case: a node with two children is replaced by
 * its in-order successor (the smallest value in the right subtree).
 *
 * <p>Target complexity: O(h) per operation, where h is the height, so O(log n)
 * when balanced and O(n) in the degenerate case.
 */
public class BinarySearchTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public int size() {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.size");
    }

    /** Inserts a value; duplicates are ignored. */
    public void insert(int value) {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.insert");
    }

    public boolean contains(int value) {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.contains");
    }

    /** @return true when the value was present and removed. */
    public boolean delete(int value) {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.delete");
    }

    /** @throws java.util.NoSuchElementException on an empty tree. */
    public int min() {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.min");
    }

    public int max() {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.max");
    }

    /** Number of edges on the longest root to leaf path; -1 for an empty tree. */
    public int height() {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.height");
    }

    /** In-order walk, which for a BST is the sorted order. */
    public List<Integer> inOrder() {
        throw new UnsupportedOperationException("TODO: BinarySearchTree.inOrder");
    }
}
