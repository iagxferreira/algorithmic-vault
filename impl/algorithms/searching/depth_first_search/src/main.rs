use depth_first_search::{Box, iterative_depth_first_search};

fn main() {
    let main_box = Box {
        key: None,
        nested_boxes: vec![
            Box {
                key: None,
                nested_boxes: vec![],
            },
            Box {
                key: Some("golden key".to_string()),
                nested_boxes: vec![],
            },
        ],
    };

    match iterative_depth_first_search(&main_box, "golden key") {
        Some(_) => println!("Found the key in its box!"),
        None => println!("Key not found."),
    }
}
