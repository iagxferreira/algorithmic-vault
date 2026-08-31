package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DynamicArrayTest {

    @Test
    void startsEmpty() {
        DynamicArray<String> array = new DynamicArray<>();
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    void appendsAndReads() {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("a");
        array.add("b");
        assertEquals(2, array.size());
        assertEquals("a", array.get(0));
        assertEquals("b", array.get(1));
    }

    @Test
    void growsBeyondInitialCapacity() {
        DynamicArray<Integer> array = new DynamicArray<>();
        for (int i = 0; i < 100; i++) {
            array.add(i);
        }
        assertEquals(100, array.size());
        assertEquals(99, array.get(99));
    }

    @Test
    void insertsShiftTheTailRight() {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("a");
        array.add("c");
        array.insert(1, "b");
        assertEquals(3, array.size());
        assertEquals("b", array.get(1));
        assertEquals("c", array.get(2));
    }

    @Test
    void setReplacesAndReturnsThePreviousValue() {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("a");
        assertEquals("a", array.set(0, "z"));
        assertEquals("z", array.get(0));
    }

    @Test
    void removeShiftsTheTailLeft() {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("a");
        array.add("b");
        array.add("c");
        assertEquals("b", array.removeAt(1));
        assertEquals(2, array.size());
        assertEquals("c", array.get(1));
    }

    @Test
    void indexOfReportsMinusOneWhenAbsent() {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("a");
        assertEquals(0, array.indexOf("a"));
        assertEquals(-1, array.indexOf("nope"));
    }

    @Test
    void rejectsOutOfBoundsReads() {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("a");
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
    }
}
