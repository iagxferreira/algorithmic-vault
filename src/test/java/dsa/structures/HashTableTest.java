package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HashTableTest {

    @Test
    void storesAndReadsBack() {
        HashTable<String, Integer> table = new HashTable<>();
        assertNull(table.put("a", 1));
        assertEquals(1, table.get("a"));
        assertEquals(1, table.size());
    }

    @Test
    void putOverwritesAndReturnsThePreviousValue() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("a", 1);
        assertEquals(1, table.put("a", 2));
        assertEquals(2, table.get("a"));
        assertEquals(1, table.size());
    }

    @Test
    void missingKeysReadAsNull() {
        HashTable<String, Integer> table = new HashTable<>();
        assertNull(table.get("nope"));
        assertFalse(table.containsKey("nope"));
    }

    @Test
    void removesKeys() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("a", 1);
        assertEquals(1, table.remove("a"));
        assertNull(table.remove("a"));
        assertEquals(0, table.size());
        assertFalse(table.containsKey("a"));
    }

    @Test
    void survivesCollisionsAndResizing() {
        HashTable<Integer, Integer> table = new HashTable<>();
        for (int i = 0; i < 500; i++) {
            table.put(i, i * 2);
        }
        assertEquals(500, table.size());
        for (int i = 0; i < 500; i++) {
            assertEquals(i * 2, table.get(i));
        }
        assertTrue(table.containsKey(499));
    }
}
