package dsa.support;

import java.util.ArrayList;
import java.util.List;

/** Builders and inspectors for {@link ListNode} chains, used mostly by tests. */
public final class ListNodes {

    private ListNodes() {
    }

    /** Builds a chain out of the given values. {@code of()} returns {@code null}. */
    public static ListNode of(int... values) {
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new ListNode(values[i], head);
        }
        return head;
    }

    /** Collects the values of a (finite) chain into an array. */
    public static int[] toArray(ListNode head) {
        List<Integer> out = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            out.add(node.val);
        }
        int[] values = new int[out.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = out.get(i);
        }
        return values;
    }

    /** Number of nodes in a finite chain. */
    public static int size(ListNode head) {
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    /**
     * Links the tail back to the node at {@code index} to create a cycle.
     * A negative index leaves the list acyclic.
     */
    public static ListNode withCycleAt(ListNode head, int index) {
        if (head == null || index < 0) {
            return head;
        }
        ListNode target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = target;
        return head;
    }
}
