use binary_addition::add_binary;

fn main() {
    let left = [1, 0, 1, 1];
    let right = [0, 1, 1, 0];

    println!(
        "Left:  {}",
        left.iter().map(u8::to_string).collect::<Vec<_>>().join(" ")
    );
    println!(
        "Right: {}",
        right
            .iter()
            .map(u8::to_string)
            .collect::<Vec<_>>()
            .join(" ")
    );
    println!(
        "Sum:   {}",
        add_binary(&left, &right)
            .iter()
            .map(u8::to_string)
            .collect::<Vec<_>>()
            .join(" ")
    );
}
