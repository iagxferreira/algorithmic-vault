# Factorial Variants

This folder implements factorial with direct recursion, iteration, and
recursion using a memoization map. Inputs must be at most 20 so the result fits
in `u64`.

Memoization does not improve the asymptotic work of one factorial calculation,
because its recurrence has no branching or overlapping subproblems. Reusing the
same map can make repeated requests for an already-computed value `O(1)`.

Run the example and the tests with:

```sh
cargo run
cargo test
```
