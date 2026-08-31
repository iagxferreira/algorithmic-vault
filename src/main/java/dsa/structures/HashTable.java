package dsa.structures;

/**
 * A hash map using separate chaining, i.e. your own HashMap.
 *
 * <p>Why it matters: nearly every "make it O(n)" trick is a hash map. Building
 * one shows you why collisions and load factor decide whether lookups really
 * are constant time.
 *
 * <p>Hint: bucket index is {@code Math.floorMod(key.hashCode(), buckets.length)};
 * resize (rehashing everything) once size / buckets exceeds the load factor.
 *
 * <p>Target complexity: put/get/remove O(1) on average, O(n) worst case.
 */
public class HashTable<K, V> {

    protected static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] buckets = new Entry[16];
    private int size;

    public int size() {
        throw new UnsupportedOperationException("TODO: HashTable.size");
    }

    /** @return the previous value for the key, or null. */
    public V put(K key, V value) {
        throw new UnsupportedOperationException("TODO: HashTable.put");
    }

    /** @return the stored value, or null when the key is absent. */
    public V get(K key) {
        throw new UnsupportedOperationException("TODO: HashTable.get");
    }

    public boolean containsKey(K key) {
        throw new UnsupportedOperationException("TODO: HashTable.containsKey");
    }

    /** @return the removed value, or null when the key was absent. */
    public V remove(K key) {
        throw new UnsupportedOperationException("TODO: HashTable.remove");
    }
}
