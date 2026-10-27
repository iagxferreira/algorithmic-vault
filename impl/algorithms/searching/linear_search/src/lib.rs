//! Straightforward linear scans over a slice.

/// Returns the index of the first value equal to `target`, or `None`.
pub fn linear_search(values: &[i32], target: i32) -> Option<usize> {
    values.iter().position(|&value| value == target)
}

/// Returns the index of the last value equal to `target`, or `None`.
pub fn linear_search_from_end(values: &[i32], target: i32) -> Option<usize> {
    values.iter().rposition(|&value| value == target)
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check(left_to_right: bool, values: &[i32], target: i32, expected: Option<usize>) {
        let index = if left_to_right {
            linear_search(values, target)
        } else {
            linear_search_from_end(values, target)
        };
        assert_eq!(index, expected);
    }

    #[test]
    fn empty_input() {
        check(true, &[], 7, None);
    }

    #[test]
    fn first_element() {
        check(true, &[7, 2, 4], 7, Some(0));
    }

    #[test]
    fn middle_element() {
        check(true, &[7, 2, 4], 2, Some(1));
    }

    #[test]
    fn last_element() {
        check(true, &[7, 2, 4], 4, Some(2));
    }

    #[test]
    fn missing_value() {
        check(true, &[7, 2, 4], 9, None);
    }

    #[test]
    fn right_to_left_empty_input() {
        check(false, &[], 7, None);
    }

    #[test]
    fn right_to_left_last_element_wins() {
        check(false, &[4, 2, 4], 4, Some(2));
    }

    #[test]
    fn right_to_left_missing_value() {
        check(false, &[7, 2, 4], 9, None);
    }
}
