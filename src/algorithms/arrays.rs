pub fn two_sum(nums: &[i32], target: i32) -> Option<(usize, usize)> {
    use std::collections::HashMap;

    let mut seen = HashMap::new();

    for (i, &num) in nums.iter().enumerate() {
        let need = target - num;
        if let Some(&j) = seen.get(&need) {
            return Some((j, i));
        }
        seen.insert(num, i);
    }

    None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn finds_two_sum_pair() {
        assert_eq!(two_sum(&[2, 7, 11, 15], 9), Some((0, 1)));
    }

    #[test]
    fn returns_none_when_missing() {
        assert_eq!(two_sum(&[1, 2, 3], 100), None);
    }
}

