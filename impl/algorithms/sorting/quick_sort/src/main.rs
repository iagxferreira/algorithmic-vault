use quick_sort::quick_sort;

fn main() {
    let values = [5, 2, 4, 6, 1, 3];
    let sorted = quick_sort(&values);

    println!(
        "Sorted values: {}",
        sorted
            .iter()
            .map(i32::to_string)
            .collect::<Vec<_>>()
            .join(" ")
    );
}
