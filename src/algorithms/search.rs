pub fn binary_search(nums: &[i32], target: i32) -> Option<usize> {
    let mut left = 0;
    let mut right = nums.len();

    while left < right {
        let mid = left + (right - left) / 2;

        match nums[mid].cmp(&target) {
            std::cmp::Ordering::Less => left = mid + 1,
            std::cmp::Ordering::Greater => right = mid,
            std::cmp::Ordering::Equal => return Some(mid),
        }
    }

    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn finds_target() {
        assert_eq!(binary_search(&[1, 3, 5, 7, 9], 7), Some(3));
    }

    #[test]
    fn returns_none_when_absent() {
        assert_eq!(binary_search(&[1, 3, 5, 7, 9], 2), None);
    }
}

