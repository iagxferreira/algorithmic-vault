pub fn selection_sort(nums: &mut [i32]) {
    for i in 0..nums.len() {
        let mut min_index = i;

        for j in (i + 1)..nums.len() {
            if nums[j] < nums[min_index] {
                min_index = j;
            }
        }

        nums.swap(i, min_index);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn sorts_values() {
        let mut nums = [5, 1, 4, 2, 8];
        selection_sort(&mut nums);
        assert_eq!(nums, [1, 2, 4, 5, 8]);
    }
}

