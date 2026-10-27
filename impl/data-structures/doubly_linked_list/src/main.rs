use doubly_linked_list::DoublyLinkedList;

fn main() {
    let list: DoublyLinkedList<i32> = [1, 7, 3, 42].into_iter().collect();

    println!("Forward from the head:");
    for value in &list {
        println!("{value}");
    }

    let mut list = list;
    println!("Popping from the back (O(1) both ways now):");
    while let Some(value) = list.pop_back() {
        println!("{value}");
    }
}
