package dsa.support;

/**
 * Singly linked list node shared by the linked list exercises.
 *
 * <p>This is plumbing, not an exercise: it is already implemented so the
 * exercises can focus on the algorithm.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
