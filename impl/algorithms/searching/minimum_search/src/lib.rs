//! Finds the first smallest value in a slice.

/// Returns the index of the first smallest value, or `None` for an empty
/// slice. The search takes `O(n)` time and `O(1)` extra space.
pub fn minimum_search(values: &[i32]) -> Option<usize> {
    if values.is_empty() {
        return None;
    }

    let mut min_index = 0;
    for i in 0..values.len() {
        if values[i] < values[min_index] {
            min_index = i;
        }
    }
    Some(min_index)
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check(values: &[i32], expected: Option<usize>) {
        assert_eq!(minimum_search(values), expected);
    }

    #[test]
    fn empty_input() {
        check(&[], None);
    }

    #[test]
    fn single_element() {
        check(&[7], Some(0));
    }

    #[test]
    fn minimum_at_beginning() {
        check(&[1, 3, 4], Some(0));
    }

    #[test]
    fn minimum_in_middle() {
        check(&[5, 1, 4], Some(1));
    }

    #[test]
    fn minimum_at_end() {
        check(&[5, 3, 1], Some(2));
    }

    #[test]
    fn negative_values() {
        check(&[-2, -5, 0], Some(1));
    }

    #[test]
    fn duplicate_minimum_returns_first_index() {
        check(&[1, 0, 0, 2], Some(1));
    }
}
