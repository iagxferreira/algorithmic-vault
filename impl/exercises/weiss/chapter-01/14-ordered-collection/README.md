# Exercise 1.14: OrderedCollection class template

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.14.

## Task

Design a class template `OrderedCollection<Comparable>` that stores a collection
of `Comparable`s in an array together with the current size. Provide `isEmpty`,
`makeEmpty`, `insert`, `remove`, `findMin`, and `findMax`, where the last two
return references to the smallest and largest elements. Explain what can be done
when these operations are performed on an empty collection.

## Requirements

- [ ] Keep the elements ordered so the minimum and maximum are easy to find.
- [ ] Implement all six public functions.
- [ ] Return references from `findMin` and `findMax` as specified.
- [ ] Decide how empty-collection calls behave and document the choice.
- [ ] Test duplicates, single-element, and empty collections.

## Scaffold

- `main.cpp` - stub; add the class and a small usage example here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

Think about the cost of each operation and whether keeping the array sorted is
worth it for the expected use. For empty collections, common options are throwing
an exception, asserting, or returning a sentinel; state the trade-offs.
