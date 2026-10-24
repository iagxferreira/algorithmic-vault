//! Depth-first search over a tree of boxes, following "Grokking
//! Algorithms". Each box holds an optional key and nested boxes.
//!
//! The [`Box`] type name mirrors the book's model; it does not relate to
//! `std::boxed::Box`.

pub type BoxItem = String;

/// A node in the box tree. Nested boxes are this node's children.
pub struct Box {
    /// The key stored in this box, if any.
    pub key: Option<BoxItem>,
    /// Boxes directly inside this one.
    pub nested_boxes: Vec<Box>,
}

/// Returns the box containing `target`, or `None` when it is not present.
/// Visits boxes with an explicit stack.
pub fn iterative_depth_first_search<'a>(main_box: &'a Box, target: &str) -> Option<&'a Box> {
    let mut boxes_to_visit = vec![main_box];

    while let Some(current) = boxes_to_visit.pop() {
        if current.key.as_deref() == Some(target) {
            return Some(current);
        }

        for nested_box in &current.nested_boxes {
            boxes_to_visit.push(nested_box);
        }
    }

    None
}

/// Returns the box containing `target`, or `None` when it is not present.
/// Recurses into each nested box.
pub fn recursive_depth_first_search<'a>(main_box: &'a Box, target: &str) -> Option<&'a Box> {
    if main_box.key.as_deref() == Some(target) {
        return Some(main_box);
    }

    for nested_box in &main_box.nested_boxes {
        if let Some(found) = recursive_depth_first_search(nested_box, target) {
            return Some(found);
        }
    }

    None
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
        check(iterative_depth_first_search, &empty_box(), false);
        check(recursive_depth_first_search, &empty_box(), false);
    }

    #[test]
    fn key_in_main_box() {
        let main_box = boxed("key");
        check(iterative_depth_first_search, &main_box, true);
        check(recursive_depth_first_search, &main_box, true);
    }

    #[test]
    fn key_in_nested_box() {
        let main_box = Box {
            key: None,
            nested_boxes: vec![boxed("key")],
        };
        check(iterative_depth_first_search, &main_box, true);
        check(recursive_depth_first_search, &main_box, true);
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
        check(iterative_depth_first_search, &main_box, true);
        check(recursive_depth_first_search, &main_box, true);
    }

    #[test]
    fn key_is_missing() {
        let main_box = Box {
            key: None,
            nested_boxes: vec![empty_box(), empty_box()],
        };
        check(iterative_depth_first_search, &main_box, false);
        check(recursive_depth_first_search, &main_box, false);
    }

    #[test]
    fn different_key() {
        let main_box = boxed("other");
        check(iterative_depth_first_search, &main_box, false);
        check(recursive_depth_first_search, &main_box, false);
    }
}
