package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class ArrayStackTest {

    @Test
    void startsEmpty() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void popsInLastInFirstOutOrder() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peekDoesNotRemove() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(7);
        assertEquals(7, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void growsBeyondInitialCapacity() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 50; i++) {
            stack.push(i);
        }
        assertEquals(50, stack.size());
        assertEquals(49, stack.pop());
    }

    @Test
    void poppingAnEmptyStackFails() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertThrows(NoSuchElementException.class, stack::pop);
    }
}
