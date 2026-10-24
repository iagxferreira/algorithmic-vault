//! Insertion sort in three variants (ascending, descending, and a
//! right-to-left pass). These are shifts, not swaps: the prefix through
//! `low` stays sorted while the key is shifted into place.

/// Sorts the slice in ascending order.
pub fn insertion_sort(values: &mut [i32]) {
    for low in 0..values.len() {
        let key = values[low];
        let mut i = low;

        while i > 0 && values[i - 1] > key {
            values[i] = values[i - 1];
            i -= 1;
        }
        values[i] = key;
    }
}

/// Sorts the slice in non-increasing order with a left-to-right pass.
pub fn insertion_sort_nonincreasing(values: &mut [i32]) {
    for low in 0..values.len() {
        let key = values[low];
        let mut i = low;

        while i > 0 && values[i - 1] < key {
            values[i] = values[i - 1];
            i -= 1;
        }
        values[i] = key;
    }
}

/// Sorts the slice in non-increasing order by working from the end.
pub fn insertion_sort_nonincreasing_from_end(values: &mut [i32]) {
    let mut high = values.len();

    while high > 1 {
        let key = values[high - 2];
        let mut i = high - 1;

        while i < values.len() && values[i] > key {
            values[i - 1] = values[i];
            i += 1;
        }
        values[i - 1] = key;
        high -= 1;
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check_ascending(values: &[i32], expected: &[i32]) {
        let mut sorted = values.to_vec();
        insertion_sort(&mut sorted);
        assert_eq!(sorted, expected);
    }

    fn check_nonincreasing(values: &[i32], expected: &[i32]) {
        let mut sorted = values.to_vec();
        insertion_sort_nonincreasing(&mut sorted);
        assert_eq!(sorted, expected);
    }

    fn check_nonincreasing_from_end(values: &[i32], expected: &[i32]) {
        let mut sorted = values.to_vec();
        insertion_sort_nonincreasing_from_end(&mut sorted);
        assert_eq!(sorted, expected);
    }

    #[test]
    fn empty_input() {
        check_ascending(&[], &[]);
    }

    #[test]
    fn single_element() {
        check_ascending(&[7], &[7]);
    }

    #[test]
    fn already_sorted() {
        check_ascending(&[1, 2, 3, 4], &[1, 2, 3, 4]);
    }

    #[test]
    fn reverse_order() {
        check_ascending(&[4, 3, 2, 1], &[1, 2, 3, 4]);
    }

    #[test]
    fn duplicate_values() {
        check_ascending(&[3, 1, 2, 1], &[1, 1, 2, 3]);
    }

    #[test]
    fn negative_values() {
        check_ascending(&[0, -3, 8, -1], &[-3, -1, 0, 8]);
    }

    #[test]
    fn nonincreasing_order() {
        check_nonincreasing(&[1, 4, 2, 3], &[4, 3, 2, 1]);
    }

    #[test]
    fn nonincreasing_duplicates() {
        check_nonincreasing(&[3, 1, 2, 1], &[3, 2, 1, 1]);
    }

    #[test]
    fn nonincreasing_negative_values() {
        check_nonincreasing(&[0, -3, 8, -1], &[8, 0, -1, -3]);
    }

    #[test]
    fn right_to_left_empty_input() {
        check_nonincreasing_from_end(&[], &[]);
    }

    #[test]
    fn right_to_left_single_element() {
        check_nonincreasing_from_end(&[7], &[7]);
    }

    #[test]
    fn right_to_left_order() {
        check_nonincreasing_from_end(&[1, 4, 2, 3], &[4, 3, 2, 1]);
    }

    #[test]
    fn right_to_left_duplicates() {
        check_nonincreasing_from_end(&[3, 1, 2, 1], &[3, 2, 1, 1]);
    }
}
