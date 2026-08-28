pub fn fibonacci(n: usize) -> usize {
    match n {
        0 => 0,
        1 => 1,
        _ => {
            let mut prev = 0usize;
            let mut curr = 1usize;

            for _ in 2..=n {
                let next = prev + curr;
                prev = curr;
                curr = next;
            }

            curr
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn computes_sequence() {
        assert_eq!(fibonacci(0), 0);
        assert_eq!(fibonacci(1), 1);
        assert_eq!(fibonacci(10), 55);
    }
}
