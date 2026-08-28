pub fn solve(nums: &[i32], target: i32) -> Option<(usize, usize)> {
    crate::algorithms::arrays::two_sum(nums, target)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn solves_two_sum() {
        assert_eq!(solve(&[2, 7, 11, 15], 9), Some((0, 1)));
    }
}

