//! Binary search over sorted slices.

/// Searches an ascending-sorted slice. Returns the index of a matching value,
/// or `None` when the target is not present.
pub fn binary_search(values: &[i32], target: i32) -> Option<usize> {
    let mut low = 0;
    let mut high = values.len();

    while low < high {
        let mid = low + (high - low) / 2;

        if values[mid] == target {
            return Some(mid);
        }

        if values[mid] < target {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    None
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check(values: &[i32], target: i32, expected: Option<usize>) {
        assert_eq!(binary_search(values, target), expected);
    }

    #[test]
    fn empty_input() {
        check(&[], 7, None);
    }

    #[test]
    fn single_element_match() {
        check(&[7], 7, Some(0));
    }

    #[test]
    fn single_element_miss() {
        check(&[7], 9, None);
    }

    #[test]
    fn first_element() {
        check(&[1, 3, 4, 6, 8], 1, Some(0));
    }

    #[test]
    fn middle_element() {
        check(&[1, 3, 4, 6, 8], 4, Some(2));
    }

    #[test]
    fn last_element() {
        check(&[1, 3, 4, 6, 8], 8, Some(4));
    }

    #[test]
    fn missing_between_elements() {
        check(&[1, 3, 4, 6, 8], 5, None);
    }

    #[test]
    fn missing_outside_range() {
        check(&[1, 3, 4, 6, 8], 9, None);
    }

    #[test]
    fn duplicate_value() {
        check(&[1, 3, 3, 3, 8], 3, Some(2));
    }
}
