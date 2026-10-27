use list_recursion::{recursive_count, recursive_maximum, recursive_sum};

fn main() {
    let values = [2, 4, 6, 8];

    println!("Sum: {}", recursive_sum(&values));
    println!("Count: {}", recursive_count(&values));

    match recursive_maximum(&values) {
        Some(maximum) => println!("Maximum: {maximum}"),
        None => println!("Maximum: no value (empty list)"),
    }
}
