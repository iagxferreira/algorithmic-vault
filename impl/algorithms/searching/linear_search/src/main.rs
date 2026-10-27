use linear_search::{linear_search, linear_search_from_end};

fn main() {
    let values = [5, 2, 4, 6, 1, 3, 4];
    let target = 4;

    let (first_index, last_index) = match (
        linear_search(&values, target),
        linear_search_from_end(&values, target),
    ) {
        (Some(first), Some(last)) => (first, last),
        _ => {
            println!("{target} was not found.");
            return;
        }
    };
    println!("{target} first found at index {first_index}.");
    println!("{target} last found at index {last_index}.");
}
