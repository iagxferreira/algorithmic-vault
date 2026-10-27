use binary_search::binary_search;

fn main() {
    let values = [1, 3, 4, 6, 8, 9];
    let target = 6;

    match binary_search(&values, target) {
        Some(index) => println!("{target} found at index {index}."),
        None => println!("{target} was not found."),
    }
}
