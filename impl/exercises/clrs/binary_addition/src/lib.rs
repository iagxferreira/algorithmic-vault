//! CLRS exercise 2.1-4: adding two n-bit binary integers.

/// Bits are stored most-significant first. The inputs must have equal length.
/// The result contains `n + 1` bits, also most-significant first.
pub fn add_binary(left: &[u8], right: &[u8]) -> Vec<u8> {
    let mut result = vec![0u8; left.len() + 1];
    let mut carry = 0u8;

    for i in (0..left.len()).rev() {
        let sum = left[i] + right[i] + carry;
        result[i + 1] = sum % 2;
        carry = sum / 2;
    }

    result[0] = carry;
    result
}

#[cfg(test)]
mod tests {
    use super::*;

    fn check(left: &[u8], right: &[u8], expected: &[u8]) {
        assert_eq!(add_binary(left, right), expected);
    }

    #[test]
    fn mixed_bits() {
        check(&[1, 0, 1, 1], &[0, 1, 1, 0], &[1, 0, 0, 0, 1]);
    }

    #[test]
    fn all_zeros() {
        check(&[0, 0, 0], &[0, 0, 0], &[0, 0, 0, 0]);
    }

    #[test]
    fn final_carry() {
        check(&[1, 1, 1, 1], &[0, 0, 0, 1], &[1, 0, 0, 0, 0]);
    }

    #[test]
    fn single_carry() {
        check(&[0, 0, 1], &[0, 0, 1], &[0, 0, 1, 0]);
    }
}
