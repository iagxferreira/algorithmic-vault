//! Grokking-style recursive list operations.

/// Returns the sum of the values, or `0` for an empty list.
pub fn recursive_sum(values: &[i32]) -> i64 {
    sum_from(values, 0)
}

/// Returns the number of values, or `0` for an empty list.
pub fn recursive_count(values: &[i32]) -> usize {
    count_from(values, 0)
}

/// Returns the maximum value, or `None` for an empty list.
pub fn recursive_maximum(values: &[i32]) -> Option<i32> {
    if values.is_empty() {
        return None;
    }
    Some(maximum_from(values, 0))
}

fn sum_from(values: &[i32], index: usize) -> i64 {
    if index == values.len() {
        return 0;
    }
    values[index] as i64 + sum_from(values, index + 1)
}

fn count_from(values: &[i32], index: usize) -> usize {
    if index == values.len() {
        return 0;
    }
    1 + count_from(values, index + 1)
}

fn maximum_from(values: &[i32], index: usize) -> i32 {
    if index + 1 == values.len() {
        return values[index];
    }
    let maximum_of_rest = maximum_from(values, index + 1);
    values[index].max(maximum_of_rest)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn empty_sum() {
        assert_eq!(recursive_sum(&[]), 0);
    }

    #[test]
    fn single_element_sum() {
        assert_eq!(recursive_sum(&[7]), 7);
    }

    #[test]
    fn multiple_element_sum() {
        assert_eq!(recursive_sum(&[2, 4, 6]), 12);
    }

    #[test]
    fn empty_count() {
        assert_eq!(recursive_count(&[]), 0);
    }

    #[test]
    fn single_element_count() {
        assert_eq!(recursive_count(&[7]), 1);
    }

    #[test]
    fn multiple_element_count() {
        assert_eq!(recursive_count(&[2, 4, 6]), 3);
    }

    #[test]
    fn empty_maximum() {
        assert_eq!(recursive_maximum(&[]), None);
    }

    #[test]
    fn single_element_maximum() {
        assert_eq!(recursive_maximum(&[7]), Some(7));
    }

    #[test]
    fn maximum_of_mixed_values() {
        assert_eq!(recursive_maximum(&[2, 9, 6, 9, -1]), Some(9));
    }

    #[test]
    fn maximum_of_negative_values() {
        assert_eq!(recursive_maximum(&[-8, -3, -5]), Some(-3));
    }
}
