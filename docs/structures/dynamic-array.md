# Dynamic array

`dsa.structures.DynamicArray` — your own `ArrayList`

## Why build it

Because "append is O(1)" is a lie that is true on average, and the reason
why is the first piece of amortised analysis most people meet. Every other
structure in this repo is built on top of an array, so start here.

## Understand before you write code

1. **Why doubling, and not growing by a constant.** Growing by +1 each time
   makes n appends cost 1+2+...+n = O(n²). Doubling makes the copies cost
   1+2+4+...+n < 2n, so n appends cost O(n) total — O(1) *amortised* each.
   Work that sum out; it is the whole lesson.
2. **What "amortised" actually claims.** Not that every append is fast —
   one in every n is genuinely O(n). It claims the *average over a sequence*
   is O(1). A real-time system cares about the difference.
3. **Why `size` and `capacity` are different numbers.** The backing array is
   usually bigger than the contents. Confusing the two is the main bug here.
4. **Why insert and remove are O(n).** Everything after the index shifts.
   That is the fundamental trade against a linked list: arrays win on random
   access, lose on middle insertion.
5. **Why the backing array is `Object[]`.** Java cannot instantiate `T[]` —
   generics are erased at runtime. You store `Object[]` and cast on read.
   This is a language wart, not a design choice.

## Implement

- [ ] `size`, `isEmpty` — trivial, but get `size` vs `capacity` straight
- [ ] `add` — with the doubling grow
- [ ] `get`, `set` — with bounds checks that throw `IndexOutOfBoundsException`
- [ ] `insert`, `removeAt` — the shifting
- [ ] `indexOf`

## Traps

- **Bounds checks.** `get(size)` must throw, even when `size < capacity` and
  the slot physically exists. Tested.
- **Shifting direction.** Insert shifts right, and must copy from the *end*
  backwards or it smears one value over the tail. Remove shifts left, and
  must copy from the front forwards.
- **Leaving a stale reference** in the vacated slot after remove keeps the
  object alive. Null it out.
- **`indexOf` with null elements** or with `equals` vs `==` — decide and be
  consistent.

## Test it

```shell
./gradlew test --tests '*DynamicArrayTest'
```

## Then use it

`dsa.usage.ListUsage` is the same ground via the JDK. Build the structure
first, then learn the idioms — see [`docs/usage/collections.md`](../usage/collections.md).
