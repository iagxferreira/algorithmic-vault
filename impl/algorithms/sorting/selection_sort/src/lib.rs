//! Selection sort: repeatedly move the smallest remaining value to the front
//! of the unsorted suffix.

/// Sorts the slice in ascending order in place.
pub fn selection_sort(values: &mut [i32]) {
    for low in 0..values.len().saturating_sub(1) {
        let mut min_index = low;

        for high in (low + 1)..values.len() {
            if values[high] < values[min_index] {
                min_index = high;
            }
        }

        values.swap(low, min_index);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check(values: &[i32], expected: &[i32]) {
        let mut sorted = values.to_vec();
        selection_sort(&mut sorted);
        assert_eq!(sorted, expected);
    }

    #[test]
    fn empty_input() {
        check(&[], &[]);
    }

    #[test]
    fn single_element() {
        check(&[7], &[7]);
    }

    #[test]
    fn already_sorted() {
        check(&[1, 2, 3, 4], &[1, 2, 3, 4]);
    }

    #[test]
    fn reverse_order() {
        check(&[4, 3, 2, 1], &[1, 2, 3, 4]);
    }

    #[test]
    fn duplicate_values() {
        check(&[3, 1, 2, 1], &[1, 1, 2, 3]);
    }

    #[test]
    fn negative_values() {
        check(&[0, -3, 8, -1], &[-3, -1, 0, 8]);
    }
}
