package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class MinHeapTest {

    @Test
    void startsEmpty() {
        MinHeap heap = new MinHeap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        assertThrows(NoSuchElementException.class, heap::pop);
    }

    @Test
    void popsTheSmallestFirst() {
        MinHeap heap = new MinHeap();
        for (int value : new int[] {5, 3, 8, 1, 9, 2}) {
            heap.push(value);
        }
        assertEquals(1, heap.peek());
        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(3, heap.size());
    }

    @Test
    void drainsInSortedOrder() {
        MinHeap heap = new MinHeap();
        int[] values = {7, 7, -4, 0, 15, 3, 3, 100, -30};
        for (int value : values) {
            heap.push(value);
        }
        int[] drained = new int[values.length];
        for (int i = 0; i < drained.length; i++) {
            drained[i] = heap.pop();
        }
        int[] expected = values.clone();
        java.util.Arrays.sort(expected);
        assertEquals(java.util.Arrays.toString(expected), java.util.Arrays.toString(drained));
    }

    @Test
    void heapifyBuildsFromAnArbitraryArray() {
        MinHeap heap = new MinHeap();
        heap.heapify(new int[] {9, 4, 7, 1, 8, 2});
        assertEquals(6, heap.size());
        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(4, heap.pop());
    }

    @Test
    void growsBeyondInitialCapacity() {
        MinHeap heap = new MinHeap();
        for (int i = 100; i > 0; i--) {
            heap.push(i);
        }
        assertEquals(100, heap.size());
        assertEquals(1, heap.pop());
    }
}
