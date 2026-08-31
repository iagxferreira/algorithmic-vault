# algorithm-studies

Data structures and algorithms practised from scratch in Java.

Every class in `src/main` is a **stub**: the signature, the javadoc explaining
the problem and the idea, and a body that throws
`UnsupportedOperationException`. Every stub has a JUnit test that already
describes the expected behaviour. The exercise is to make the tests pass.

There are no reference solutions in this repo, on purpose.

## Running

The toolchain is pinned in `mise.toml` (Temurin 21 and Gradle 9.7):

```shell
mise install          # once
./gradlew test        # everything
```

If `mise` is not activated in your shell, prefix commands with `mise x --`.

The whole suite is red on a fresh clone. That is the starting line, not a
problem. Run only what you are working on:

```shell
./gradlew test --tests 'dsa.structures.MinHeapTest'
./gradlew test --tests 'dsa.fundamentals.*'
./gradlew test --tests 'dsa.exercises.graphs.*'
```

## Layout

Three tiers, meant to be worked through in order.

| Package | What it holds |
| --- | --- |
| `dsa.structures` | The containers themselves, built from nothing: dynamic array, linked lists, stack, ring-buffer queue, min-heap, hash table, bst, trie, union-find, LRU cache, graph, Fenwick and segment trees. |
| `dsa.fundamentals` | The techniques: sorting, binary search in all its disguises, list and tree traversals, dfs/bfs, Dijkstra and friends, minimum spanning trees, sliding windows, prefix sums, number theory, bit tricks. |
| `dsa.exercises` | 68 interview and contest problems, grouped by the pattern they train. |
| `dsa.support` | `ListNode`, `TreeNode` and their builders. Already implemented; it is plumbing, not an exercise. |

`ROADMAP.md` is the checklist, ordered so each item only depends on earlier ones.

## How to work through one

1. Read the javadoc. It states the problem, gives an example, and names the
   technique and the target complexity, but never the solution.
2. Run that one test class and watch it fail.
3. Implement the stub.
4. Re-run. When it is green, check your complexity against the target in the
   javadoc: passing the tests with the wrong complexity is only half the
   exercise.

Where a javadoc mentions a second approach ("also write the O(1) space
version", "then rewrite it in O(n log n)"), that second version is the point of
the problem. Do it.
