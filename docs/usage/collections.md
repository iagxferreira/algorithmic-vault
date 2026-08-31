# Using the standard library

`dsa.usage` — 7 classes

## Why this tier exists

Writing a hash table teaches you what it costs. Knowing that
`merge(key, 1, Integer::sum)` increments a count in one call is what makes
you *fast*. They are different skills and you want both — so these drills
deliberately cover the same ground you just built by hand.

| You built | You will actually use |
|---|---|
| `DynamicArray` | `ArrayList` — `ListUsage` |
| `HashTable` | `HashMap`, `HashSet` — `MapUsage`, `SetUsage` |
| `ArrayStack`, `CircularQueue` | `ArrayDeque` — `DequeUsage` |
| `MinHeap` | `PriorityQueue` — `PriorityQueueUsage` |
| — | `Arrays`, `String`, `StringBuilder` — `ArrayUsage`, `StringUsage` |

## The idioms worth knowing by name

Each of these replaces four lines of null-checking or a manual loop:

```java
map.getOrDefault(key, 0)                        // read a count that may not exist
map.merge(key, 1, Integer::sum)                 // increment in one call
map.computeIfAbsent(key, k -> new ArrayList<>())// build a map of lists
list.removeIf(x -> x % 2 != 0)                  // remove without a ConcurrentModificationException
new PriorityQueue<>(Comparator.reverseOrder())  // a max-heap
Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
Arrays.copyOfRange(a, from, to)                 // slice
new StringBuilder(s).reverse().toString()       // reverse
```

## The traps these drills walk into

Each one is a real test in this package, not a hypothetical.

1. **`List.of(...)` is immutable.** Adding to it throws
   `UnsupportedOperationException`. Wrap in `new ArrayList<>(...)` to
   modify.
2. **`list.remove(int)` removes by index, `list.remove(Object)` by value.**
   On a `List<Integer>` those are different methods and the compiler picks
   silently.
3. **Removing inside a for-each** throws
   `ConcurrentModificationException`. Use `removeIf` or an explicit
   `Iterator`.
4. **`map.get` returns `null`, not 0.** Unboxing that into an `int` throws
   NPE. This is the single most common Java crash in this whole subject.
5. **`PriorityQueue` is a MIN-heap** — the opposite of C++. And iterating or
   printing one gives *heap order*, not sorted order; only `poll` is
   ordered.
6. **`(a, b) -> b - a` as a comparator overflows** on extreme values. Use
   `Comparator.reverseOrder()` or `Integer.compare`. Tested with
   `Integer.MIN_VALUE`.
7. **`String.split` takes a regex.** `split(".")` matches every character
   and returns an empty array; you want `split("\\.")`.
8. **`result += c` in a loop is O(n²)** — strings are immutable, so each
   concatenation copies. Use `StringBuilder`.
9. **`clone()` on a 2D array is shallow** — the rows stay shared. Copy each
   row. Tested.
10. **`Arrays.asList(intArray)`** gives a single-element `List<int[]>`, not
    a list of ints. Use a stream, or box first.
11. **`Arrays.toString` vs `deepToString`** — the first prints one
    dimension only.
12. **There is no comparator overload for `int[]`.** To sort primitives
    descending you must box, sort, and unbox.

## Order to implement

- [ ] `ListUsage` — build, convert, reverse, rotate, filter, sort by comparator
- [ ] `MapUsage` — counting, grouping, inverting; `HashMap` vs `LinkedHashMap` vs `TreeMap`
- [ ] `SetUsage` — dedupe, set algebra, `TreeSet` neighbour queries
- [ ] `DequeUsage` — as a stack, as a queue, from both ends
- [ ] `PriorityQueueUsage` — min vs max, top-k, merging sorted input
- [ ] `ArrayUsage` — `Arrays` methods, deep copy, transpose
- [ ] `StringUsage` — `StringBuilder`, split/join, normalising, counting

## Which implementation, and when

- `HashMap` / `HashSet` — no order, fastest. The default.
- `LinkedHashMap` / `LinkedHashSet` — insertion order. Needed whenever
  "first" means anything (see `firstUniqueCharacter`).
- `TreeMap` / `TreeSet` — sorted keys, O(log n). Also gives you `first`,
  `last`, `floor`, `ceiling` — a small ordered structure for free.
- `ArrayDeque` — for stacks and queues both. Never the legacy `Stack`
  (synchronised) or `LinkedList` (an allocation per element).

## Test it

```shell
./gradlew test --tests 'dsa.usage.*'
./gradlew test --tests '*MapUsageTest'
```
