package dsa.structures;

/**
 * A fixed capacity cache that evicts the least recently used key.
 *
 * <p>Why it matters: this is the classic "combine two structures" design
 * question. A hash map gives O(1) lookup; a doubly linked list gives O(1)
 * reordering. Neither alone is enough.
 *
 * <p>Both {@link #get(int)} and {@link #put(int, int)} count as a use and move
 * the key to the most recent end.
 *
 * <p>Target complexity: get/put O(1).
 */
public class LRUCache {

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /** @return the cached value, or -1 when absent. */
    public int get(int key) {
        throw new UnsupportedOperationException("TODO: LRUCache.get");
    }

    /** Inserts or updates, evicting the least recently used key when full. */
    public void put(int key, int value) {
        throw new UnsupportedOperationException("TODO: LRUCache.put");
    }
}
