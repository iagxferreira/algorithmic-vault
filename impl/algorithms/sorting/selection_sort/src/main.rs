use selection_sort::selection_sort;

fn main() {
    let mut values = [5, 2, 4, 6, 1, 3];
    println!(
        "Before: {}",
        values
            .iter()
            .map(i32::to_string)
            .collect::<Vec<_>>()
            .join(" ")
    );

    selection_sort(&mut values);
    println!(
        "After:  {}",
        values
            .iter()
            .map(i32::to_string)
            .collect::<Vec<_>>()
            .join(" ")
    );
}
