//! Factorial in three variants: direct recursion, iteration, and recursion
//! with a memoization map.

use std::collections::HashMap;

/// Precondition: `n <= 20`, so `n!` fits in `u64`.
pub fn factorial_recursive(n: u32) -> u64 {
    if n <= 1 {
        return 1;
    }
    n as u64 * factorial_recursive(n - 1)
}

/// Precondition: `n <= 20`, so `n!` fits in `u64`.
pub fn factorial_iterative(n: u32) -> u64 {
    let mut product = 1u64;
    for factor in 2..=n {
        product *= factor as u64;
    }
    product
}

/// Precondition: `n <= 20`, so `n!` fits in `u64`.
pub fn factorial_memoized(n: u32, memo: &mut HashMap<u32, u64>) -> u64 {
    if n <= 1 {
        memo.insert(n, 1);
        return 1;
    }

    if let Some(&cached) = memo.get(&n) {
        return cached;
    }

    let result = n as u64 * factorial_memoized(n - 1, memo);
    memo.insert(n, result);
    result
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check_variants(n: u32, expected: u64) {
        assert_eq!(factorial_recursive(n), expected);
        assert_eq!(factorial_iterative(n), expected);
    }

    #[test]
    fn zero_factorial() {
        check_variants(0, 1);
    }

    #[test]
    fn one_factorial() {
        check_variants(1, 1);
    }

    #[test]
    fn small_factorial() {
        check_variants(5, 120);
    }

    #[test]
    fn largest_u64_factorial() {
        check_variants(20, 2_432_902_008_176_640_000);
    }

    #[test]
    fn memoized_factorial() {
        let mut memo = HashMap::new();
        assert_eq!(factorial_memoized(0, &mut memo), 1);
        assert_eq!(factorial_memoized(5, &mut memo), 120);
        assert_eq!(factorial_memoized(3, &mut memo), 6);
        assert_eq!(factorial_memoized(20, &mut memo), 2_432_902_008_176_640_000);
    }
}
