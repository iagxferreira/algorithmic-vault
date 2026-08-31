# Bit manipulation

`dsa.algorithms.numbers` (the bits half) — 3 classes

## Why this topic

An `int` is 32 booleans. That is the whole idea, and it buys two things:

1. **Constant-space set operations** — union is `|`, intersection is `&`,
   membership is `&` with a shifted 1, and all of it is one instruction.
2. **Subset enumeration as a counting loop** — every subset of an n-element
   set is a number from 0 to 2ⁿ−1. This is the basis of bitmask dynamic
   programming, where "which cities have I visited" is one int rather than a
   `Set`.

Plus a handful of tricks that turn O(n) space into O(1), of which xor
cancellation is the one that actually shows up.

## Understand before you write code

1. **The three identities.** `x & (x - 1)` clears the lowest set bit;
   `x & -x` isolates it; `x ^ x == 0`. Work out *why* on paper for a value
   like `0b1100` — subtracting 1 flips the lowest set bit and everything
   below it.
2. **Java has no unsigned int.** `>>` is arithmetic (sign-extending) and
   `>>>` is logical (zero-filling). Using `>>` on a negative in a
   bit-counting loop is an infinite loop.
3. **`1 << 31` is negative.** And `1 << 32` is `1`, not 0 — the shift count
   is taken mod 32. For anything past bit 30, use `1L << k`.
4. **Why xor finds the unpaired element.** Xor is associative and
   commutative, so you can reorder the array freely; every pair becomes 0
   and 0 is the identity. Only the odd one survives.
5. **Operator precedence.** `&` binds *looser* than `==` in Java, so
   `x & 1 == 0` parses as `x & (1 == 0)` and does not compile. Parenthesise.

## Order to implement

- [ ] `BitBasics` — set, clear, test, toggle, count; then `countOnesUpTo`
- [ ] `XorTricks` — singleNumber, missingNumber, the swap
- [ ] `Bitmasks` — subset enumeration, which is what the rest was for

## Traps

- **`isPowerOfTwo` on negatives and zero.** `x & (x - 1) == 0` is true for
  both, so guard `x > 0`. Tested.
- **`swapInPlace(a, i, i)`** with the xor trick zeroes the slot. Guard
  `i == j`. Tested. (This is also why nobody uses the xor swap in real
  code.)
- **`countOnes(-1)` is 32.** If your loop is `while (value != 0) value >>= 1`
  it never terminates on a negative. Use `>>>`, or `value &= value - 1`.
- **`subsets` order.** Ordering by mask value gives empty set first and full
  set last, which is *not* the same order backtracking produces. Both are
  valid; the tests expect mask order here.
- **2ⁿ overflows** past n = 31. Bitmask enumeration is only viable for
  n ≲ 20 anyway, since 2²⁰ is already a million.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.numbers.Bit*'
./gradlew test --tests '*XorTricksTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0191-number-of-1-bits` and `0338-counting-bits`
- `leetcode/0136-single-number` — xor cancellation
- `leetcode/0268-missing-number` — the same trick, used differently
- `leetcode/0190-reverse-bits` — where `>>>` matters
- `leetcode/0201-bitwise-and-of-numbers-range` — the common-prefix argument
- `leetcode/1863-sum-of-all-subset-xor-totals` — subset enumeration, then the counting shortcut
- `leetcode/0371-sum-of-two-integers` — addition with no `+`
