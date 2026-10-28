//! Breadth-first search over a tree of boxes, following "Grokking
//! Algorithms". Each box holds an optional key and nested boxes.
//!
//! The [`Box`] type name mirrors the book's model; it does not relate to
//! `std::boxed::Box`.

use std::collections::VecDeque;

pub type BoxItem = String;

/// A node in the box tree. Nested boxes are this node's children.
pub struct Box {
    /// The key stored in this box, if any.
    pub key: Option<BoxItem>,
    /// Boxes directly inside this one.
    pub nested_boxes: Vec<Box>,
}

/// Returns the box containing `target`, or `None` when it is not present.
/// Visits boxes level by level with an explicit queue, so the shallowest
/// matching box is found first.
pub fn iterative_breadth_first_search<'a>(main_box: &'a Box, target: &str) -> Option<&'a Box> {
    let mut boxes_to_visit = VecDeque::from([main_box]);

    while let Some(current) = boxes_to_visit.pop_front() {
        if current.key.as_deref() == Some(target) {
            return Some(current);
        }

        for nested_box in &current.nested_boxes {
            boxes_to_visit.push_back(nested_box);
        }
    }

    None
}

fn search_frontier<'a>(mut frontier: VecDeque<&'a Box>, target: &str) -> Option<&'a Box> {
    let current = frontier.pop_front()?;

    if current.key.as_deref() == Some(target) {
        return Some(current);
    }

    for nested_box in &current.nested_boxes {
        frontier.push_back(nested_box);
    }

    search_frontier(frontier, target)
}

/// Returns the box containing `target`, or `None` when it is not present.
/// Recurses over the queue of boxes still to visit.
pub fn recursive_breadth_first_search<'a>(main_box: &'a Box, target: &str) -> Option<&'a Box> {
    search_frontier(VecDeque::from([main_box]), target)
}

#[cfg(test)]
mod tests {
    use super::*;

    fn empty_box() -> Box {
        Box {
            key: None,
            nested_boxes: Vec::new(),
        }
    }

    fn boxed(key: &str) -> Box {
        Box {
            key: Some(key.to_string()),
            nested_boxes: Vec::new(),
        }
    }

    fn check(search: for<'a> fn(&'a Box, &str) -> Option<&'a Box>, main_box: &Box, expected: bool) {
        let result = search(main_box, "key");
        assert_eq!(result.is_some(), expected);
        if let Some(box_with_key) = result {
            assert_eq!(box_with_key.key.as_deref(), Some("key"));
        }
    }

    #[test]
    fn empty_main_box() {
        check(iterative_breadth_first_search, &empty_box(), false);
        check(recursive_breadth_first_search, &empty_box(), false);
    }

    #[test]
    fn key_in_main_box() {
        let main_box = boxed("key");
        check(iterative_breadth_first_search, &main_box, true);
        check(recursive_breadth_first_search, &main_box, true);
    }

    #[test]
    fn key_in_nested_box() {
        let main_box = Box {
            key: None,
            nested_boxes: vec![boxed("key")],
        };
        check(iterative_breadth_first_search, &main_box, true);
        check(recursive_breadth_first_search, &main_box, true);
    }

    #[test]
    fn key_several_levels_deep() {
        let main_box = Box {
            key: None,
            nested_boxes: vec![Box {
                key: None,
                nested_boxes: vec![boxed("key")],
            }],
        };
        check(iterative_breadth_first_search, &main_box, true);
        check(recursive_breadth_first_search, &main_box, true);
    }

    #[test]
    fn finds_the_shallowest_box_with_the_key() {
        // Two boxes hold the key: the shallow one directly inside the main
        // box, and a deep one two levels further down. Breadth-first search
        // must return the shallow one, still holding a nested box; the deep
        // match adds no nested boxes.
        let shallow_match = Box {
            key: Some("key".to_string()),
            nested_boxes: vec![empty_box()],
        };
        let deep_match = Box {
            key: None,
            nested_boxes: vec![boxed("key")],
        };
        let main_box = Box {
            key: None,
            nested_boxes: vec![
                shallow_match,
                empty_box(),
                Box {
                    key: None,
                    nested_boxes: vec![deep_match],
                },
            ],
        };

        for found in [
            iterative_breadth_first_search(&main_box, "key"),
            recursive_breadth_first_search(&main_box, "key"),
        ] {
            let box_with_key = found.expect("the key is in the tree");
            assert!(
                !box_with_key.nested_boxes.is_empty(),
                "returned the shallow match, not the deep one"
            );
        }
    }

    #[test]
    fn key_is_missing() {
        let main_box = Box {
            key: None,
            nested_boxes: vec![empty_box(), empty_box()],
        };
        check(iterative_breadth_first_search, &main_box, false);
        check(recursive_breadth_first_search, &main_box, false);
    }

    #[test]
    fn different_key() {
        let main_box = boxed("other");
        check(iterative_breadth_first_search, &main_box, false);
        check(recursive_breadth_first_search, &main_box, false);
    }
}
