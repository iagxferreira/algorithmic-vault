# Factorial Variants

This folder implements factorial with direct recursion, iteration, and
recursion using a memoization map. Inputs must be at most 20 so the result fits
in `std::uint64_t`.

Memoization does not improve the asymptotic work of one factorial calculation,
because its recurrence has no branching or overlapping subproblems. Reusing the
same map can make repeated requests for an already-computed value `O(1)`.

Build the example with:

```sh
make build
```
