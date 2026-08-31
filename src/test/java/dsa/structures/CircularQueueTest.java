package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CircularQueueTest {

    @Test
    void startsEmpty() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertNull(queue.dequeue());
        assertNull(queue.peek());
    }

    @Test
    void dequeuesInFirstInFirstOutOrder() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void refusesToEnqueueWhenFull() {
        CircularQueue<Integer> queue = new CircularQueue<>(2);
        assertTrue(queue.enqueue(1));
        assertTrue(queue.enqueue(2));
        assertTrue(queue.isFull());
        assertFalse(queue.enqueue(3));
    }

    @Test
    void wrapsAroundTheBackingArray() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertTrue(queue.enqueue(4));
        assertTrue(queue.enqueue(5));
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
