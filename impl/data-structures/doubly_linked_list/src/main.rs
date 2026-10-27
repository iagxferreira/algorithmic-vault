use doubly_linked_list::DoublyLinkedList;

fn main() {
    let mut list: DoublyLinkedList<i32> = [1, 7, 3, 42].into_iter().collect();

    println!("Forward:");
    for value in &list {
        println!("{value}");
    }

    list.reverse();

    println!("After reversing:");
    for value in &list {
        println!("{value}");
    }
}
