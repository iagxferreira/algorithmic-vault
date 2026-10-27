# Doubly linked list

Every node is its own heap allocation, pointed at from both directions — and
that is what makes the doubly list a different beast in Rust than the singly
one: a node cannot be *owned* by its predecessor like a `Box` chain and
simultaneously be reachable through `prev`. The safe translation of the
textbook two-pointer list is shared ownership with interior mutability:

- `next: Option<Rc<RefCell<Node<T>>>>` — the forward link is strong
  (ref-counted).
- `prev: Option<Weak<RefCell<Node<T>>>>` — the backward link is an uncounted
  `Weak`, which keeps the strong graph a single forward chain that frees
  completely when the list drops. (Make `prev` strong and most of the list
  leaks on drop.)
- The list also holds a strong handle to the current tail, which is why
  `push_back`/`pop_back`/`back` are `O(1)` here and `O(n)` in the singly
  list.

Costs of sharing, visible at the seams:

- neighbor updates go through `borrow()`/`borrow_mut()` guards,
- iteration must clone values (`T: Clone`), because an outstanding `&T`
  through a `RefCell` would block the next step,
- in-place `reverse` is postponed on purpose: swapping `next`/`prev` across
  `RefCell` guards is gnarly to do safely — a good future exercise with
  `unsafe` or an arena revisit.

For contrast: the standard library's own `collections::LinkedList` is a
doubly list built on `unsafe` pointers, precisely to avoid these runtime
costs while keeping the same shape.

Run the example and the tests with:

```sh
cargo run
cargo test
```
