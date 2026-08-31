# Hash tables and the LRU cache

`dsa.structures.HashTable`, `dsa.structures.LRUCache`

## Why build them

Nearly every "make it O(n)" trick is a hash map. Building one shows you why
"O(1) lookup" depends on assumptions that can fail, and the LRU cache is
the classic example of combining two structures to get properties neither
has alone.

## Understand before you write code

1. **Why hashing gives O(1) *on average* and O(n) worst case.** If every key
   lands in the same bucket you have a linked list. Real-world safety comes
   from a decent hash function and a bounded load factor, not from the data
   structure.
2. **Bucket index is `Math.floorMod(key.hashCode(), buckets.length)`.**
   Plain `%` can return negative for a negative `hashCode`, which indexes
   out of bounds. `hashCode` is very often negative.
3. **What the load factor is for.** Once `size / buckets > 0.75`, collisions
   get common and lookups drift towards O(n). Resizing means allocating a
   bigger array and **rehashing every entry** — the index depends on the
   array length, so you cannot just copy.
4. **Separate chaining vs open addressing.** Chaining puts a list in each
   bucket (what you are building). Open addressing probes for the next free
   slot — better cache behaviour, but deletion needs tombstones. Know both
   exist.
5. **The `equals`/`hashCode` contract.** Equal objects *must* have equal
   hash codes, or the map loses entries. Unequal objects may collide. Break
   this and your map silently misbehaves — this is the most important
   practical fact in this file.
6. **For the LRU cache: why one structure is not enough.** A hash map gives
   O(1) lookup but no ordering. A list gives ordering but O(n) lookup. You
   need the map to point *at the list nodes*, so you can unlink in O(1).

## Implement

`HashTable`:
- [ ] `put` — including overwrite, returning the previous value
- [ ] `get`, `containsKey` — null means absent
- [ ] `remove`
- [ ] resizing when the load factor is exceeded

`LRUCache`:
- [ ] `get` — returns −1 when absent, **and counts as a use**
- [ ] `put` — insert, update, and evict the least recently used when full

## Traps

- **Negative hash codes** — see point 2.
- **Rehashing on resize.** Copying buckets across without recomputing
  indices makes entries unfindable.
- **`get` must refresh recency** in the LRU cache. Only refreshing on `put`
  passes the simple tests and fails the real ones. Tested.
- **Updating an existing key must not grow the cache** — and must still
  refresh recency. Tested.
- **Capacity 1** is the edge case that catches most eviction bugs. Tested.
- **In real Java**, `map.get` returns `null` and unboxing that into an
  `int` throws NPE. Use `getOrDefault`.

## Test it

```shell
./gradlew test --tests '*HashTableTest'
./gradlew test --tests '*LRUCacheTest'
```

## Then use it

`dsa.usage.MapUsage` and `dsa.usage.SetUsage` are the JDK idioms —
`getOrDefault`, `merge`, `computeIfAbsent`. Those are what you will
actually write.
