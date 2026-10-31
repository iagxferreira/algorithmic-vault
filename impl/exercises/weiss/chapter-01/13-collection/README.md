# Exercise 1.13: Collection class template

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.13.

## Task

Design a class template `Collection<Object>` that stores a collection of
`Object`s in an array together with the current size. Provide the public
functions `isEmpty`, `makeEmpty`, `insert`, `remove`, and `contains`.
`contains(x)` returns true if and only if an object equal to `x` is present.

## Requirements

- [ ] Choose the underlying storage and the maximum capacity policy.
- [ ] Implement `isEmpty` and `makeEmpty`.
- [ ] Implement `insert`, deciding what happens when the collection is full.
- [ ] Implement `remove`, deciding what happens when the object is absent.
- [ ] Implement `contains` using equality comparison.
- [ ] Test an empty collection, duplicates, and removal.

## Scaffold

- `main.cpp` - stub; add the class and a small usage example here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

A class template is normally defined in a header so every translation unit can
instantiate it. Document the semantics chosen for `insert` and `remove`.
