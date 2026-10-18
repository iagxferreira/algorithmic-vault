# Implementations

Use this folder for hands-on C++ implementations. Organize by topic, then keep
each algorithm or data structure's related files together. For example:

```text
impl/
  algorithms/
    sorting/
      insertion_sort/
        insertion_sort.h
        insertion_sort.cpp
        example.cpp
        insertion_sort_test.cpp
        Makefile
    graph/
  data-structures/
    .gitkeep
  utils/
    print_vector.h
```

The `insertion_sort/` folder is a starting example. Add a header, implementation,
example, tests, or a Makefile when useful for the topic; this structure can stay
small and grow as you need it. Keep book-specific explanations and exercise
answers under [`notes/books/`](../notes/books/README.md).

Put small helpers shared by examples or implementations in `utils/` rather than
duplicating them in each algorithm folder.
