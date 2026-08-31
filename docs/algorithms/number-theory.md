# Number theory

`dsa.algorithms.numbers` (the arithmetic half) — 5 classes

## Why this topic

These are not problems in themselves — they are *sub-steps*. A contest
problem says "count the arrangements, modulo 10⁹+7" and assumes you can
already produce a binomial coefficient under a modulus without thinking.
If you cannot, you lose the problem to plumbing rather than to the idea.

This is also the thinnest area in most self-taught DSA backgrounds,
including the one this repo was built from.

## Understand before you write code

1. **Why `gcd(a, b) == gcd(b, a % b)`.** Any common divisor of a and b also
   divides `a % b`, and vice versa, so the set of common divisors is
   unchanged. That is the entire proof.
2. **Why lcm divides first.** `a * b` overflows long far earlier than
   `a / gcd * b` does, and the division is exact because gcd divides a.
3. **Why exponentiation by squaring is O(log n).** Each step halves the
   exponent, so you do at most log₂(n) squarings. The same halving underlies
   binary search and fast matrix powers.
4. **Why you cannot divide under a modulus.** `(a / b) mod m` is not
   `(a mod m) / (b mod m)`. Division has to become multiplication by a
   *modular inverse*.
5. **Why Fermat's little theorem gives that inverse.** For prime p and
   a not divisible by p, `a^(p-1) ≡ 1 (mod p)`, so `a^(p-2)` is a's inverse.
   **This only works because the modulus is prime** — 10⁹+7 is chosen for
   exactly that reason.
6. **Why the sieve starts crossing out at p².** Every multiple of p below p²
   has a smaller prime factor and was already crossed out by it.
7. **Why trial division stops at √n.** If `n = a * b` with both above √n,
   then `a * b > n`. So one factor is always at or below √n.

## Order to implement

- [ ] `Gcd` — Euclid, then lcm with the safe multiplication order
- [ ] `FastPower` — `power`, then `modPow`, then `modInverse` on top
- [ ] `Primes` — trial division, then the sieve
- [ ] `Factorisation` — the √n loop, and the leftover-is-prime step
- [ ] `Binomial` — needs `FastPower.modInverse` working first

## Traps

- **`p * p` overflows `int`** in the sieve well before the limit does. Use
  `long`, or loop while `p <= limit / p`.
- **The leftover after the √n loop.** After dividing out every factor up to
  √n, whatever is left (if > 1) is itself prime and must be recorded.
  Forgetting it loses the largest factor. There is a test for this.
- **Perfect squares in `divisors`.** When `i * i == n`, add the root once,
  not twice.
- **`%` on negatives is negative in Java** — same as C++ and Go, unlike
  Python. `Math.floorMod` if you need the non-negative one.
- **Multiplying two values near the modulus** overflows `int` immediately
  and `long` if the modulus is above ~3·10⁹. Keep everything `long` and
  reduce after every multiply.
- **`isPrime(1)` is false** and `isPrime(2)` is true. Both are special-cased
  and both are tested.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.numbers.*'
./gradlew test --tests '*FastPowerTest'
```

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0204-count-primes` — the sieve, with the overflow
- `leetcode/0050-powx-n` — fast exponentiation, and `Integer.MIN_VALUE`
- `leetcode/0509-fibonacci-number` — then look up matrix exponentiation
- `leetcode/2807-insert-greatest-common-divisors-in-linked-list`
- `codeforces/0001a-theatre-square` — integer ceiling and long overflow
