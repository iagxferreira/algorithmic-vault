package dsa.exercises.stackqueue;

/**
 * Min Stack.
 *
 * <p>A stack that also reports its minimum in O(1). Push, pop, top and getMin
 * must all be O(1), so scanning on every getMin is out.
 *
 * <p>The idea: alongside each value, remember what the minimum was at the
 * moment it was pushed. A second stack of running minima is the easiest way,
 * and popping stays consistent for free.
 *
 * <p>All methods are called only when the stack is non-empty, except push.
 */
public class MinStack {

    public void push(int value) {
        throw new UnsupportedOperationException("TODO: MinStack.push");
    }

    public void pop() {
        throw new UnsupportedOperationException("TODO: MinStack.pop");
    }

    /** Top of the stack, without removing it. */
    public int top() {
        throw new UnsupportedOperationException("TODO: MinStack.top");
    }

    /** Smallest value currently on the stack. */
    public int getMin() {
        throw new UnsupportedOperationException("TODO: MinStack.getMin");
    }
}
