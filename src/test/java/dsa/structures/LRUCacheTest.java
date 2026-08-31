package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void readsBackWhatItStores() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        assertEquals(10, cache.get(1));
        assertEquals(-1, cache.get(2));
    }

    @Test
    void evictsTheLeastRecentlyUsedKey() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
    }

    @Test
    void readingRefreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
    }

    @Test
    void updatingAKeyRefreshesRecencyWithoutGrowing() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 100);
        cache.put(3, 3);
        assertEquals(100, cache.get(1));
        assertEquals(-1, cache.get(2));
    }

    @Test
    void capacityOfOneAlwaysHoldsTheLatest() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }
}
