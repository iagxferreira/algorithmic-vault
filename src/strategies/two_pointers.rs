pub fn pair_sum_sorted(nums: &[i32], target: i32) -> Option<(usize, usize)> {
    if nums.len() < 2 {
        return None;
    }

    let mut left = 0usize;
    let mut right = nums.len() - 1;

    while left < right {
        let sum = nums[left] + nums[right];

        if sum == target {
            return Some((left, right));
        }

        if sum < target {
            left += 1;
        } else {
            right -= 1;
        }
    }

    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn finds_pair() {
        assert_eq!(pair_sum_sorted(&[1, 2, 4, 6, 10], 8), Some((1, 3)));
    }

    #[test]
    fn handles_missing_pair() {
        assert_eq!(pair_sum_sorted(&[1, 2, 3], 100), None);
    }
}
