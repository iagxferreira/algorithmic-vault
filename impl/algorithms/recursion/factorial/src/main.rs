use std::collections::HashMap;

use factorial::{factorial_iterative, factorial_memoized, factorial_recursive};

fn main() {
    let n = 5;
    let mut memo = HashMap::new();

    println!("Recursive: {}", factorial_recursive(n));
    println!("Iterative: {}", factorial_iterative(n));
    println!("Memoized:  {}", factorial_memoized(n, &mut memo));
}
