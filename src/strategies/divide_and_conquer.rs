pub fn merge_sort(nums: &[i32]) -> Vec<i32> {
    if nums.len() <= 1 {
        return nums.to_vec();
    }

    let mid = nums.len() / 2;
    let left = merge_sort(&nums[..mid]);
    let right = merge_sort(&nums[mid..]);

    merge(&left, &right)
}

fn merge(left: &[i32], right: &[i32]) -> Vec<i32> {
    let mut merged = Vec::with_capacity(left.len() + right.len());
    let mut i = 0;
    let mut j = 0;

    while i < left.len() && j < right.len() {
        if left[i] <= right[j] {
            merged.push(left[i]);
            i += 1;
        } else {
            merged.push(right[j]);
            j += 1;
        }
    }

    merged.extend_from_slice(&left[i..]);
    merged.extend_from_slice(&right[j..]);
    merged
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn sorts_values() {
        assert_eq!(merge_sort(&[5, 2, 4, 1, 3]), vec![1, 2, 3, 4, 5]);
    }
}
