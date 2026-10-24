//! Quicksort with a three-way partition around the middle element.

/// Returns a new vector containing the values in ascending order. Values
/// equal to the pivot are grouped together to handle duplicates without
/// unproductive recursive calls. Average `O(n log n)`, worst case `O(n^2)`.
pub fn quick_sort(values: &[i32]) -> Vec<i32> {
    if values.len() <= 1 {
        return values.to_vec();
    }

    let pivot = values[values.len() / 2];

    let mut lesser = Vec::new();
    let mut equal = Vec::new();
    let mut greater = Vec::new();

    for &value in values {
        if value < pivot {
            lesser.push(value);
        } else if value > pivot {
            greater.push(value);
        } else {
            equal.push(value);
        }
    }

    let mut sorted = quick_sort(&lesser);
    sorted.extend(equal);
    sorted.extend(quick_sort(&greater));
    sorted
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check(values: &[i32], expected: &[i32]) {
        assert_eq!(quick_sort(values), expected);
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

    #[test]
    fn all_equal_values() {
        check(&[4, 4, 4, 4], &[4, 4, 4, 4]);
    }
}
