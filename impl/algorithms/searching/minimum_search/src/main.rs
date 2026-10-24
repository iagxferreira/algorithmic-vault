use minimum_search::minimum_search;

fn main() {
    let values = [5, 2, 4, 1, 3];

    match minimum_search(&values) {
        Some(index) => println!("Minimum value: {} at index {index}.", values[index]),
        None => println!("The input is empty."),
    }
}
