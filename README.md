# algorithm-studies

Data structures and algorithms in Java, at the level of "build it, then use
it". No contest problems here — those live in
[`competitive-programming-notebook`](../competitive-programming-notebook/).

Every class in `src/main` is a **stub**: the signature, a javadoc explaining
the idea, and a body that throws `UnsupportedOperationException`. Every stub
has a JUnit test describing the expected behaviour. The exercise is to make
the tests pass.

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
./gradlew test --tests 'dsa.usage.*'
```

## Layout

Three tiers, meant to be worked through in order.

| Package | What it holds |
| --- | --- |
| `dsa.structures` | **Build it.** The containers themselves, from nothing: dynamic array, linked lists, stack, ring-buffer queue, min-heap, hash table, bst, trie, union-find, LRU cache, graph, Fenwick and segment trees. |
| `dsa.fundamentals` | **Walk it.** The core operations: sorting, binary search in its various shapes, list and tree traversals, dfs/bfs, Dijkstra and friends, minimum spanning trees, sliding windows, prefix sums, number theory, bit tricks. |
| `dsa.usage` | **Use it.** The JDK equivalents of what you just built, driven fluently: `List`, `Map`, `Set`, `Deque`, `PriorityQueue`, arrays and strings. |
| `dsa.support` | `ListNode`, `TreeNode` and their builders. Already implemented; plumbing, not an exercise. |

`ROADMAP.md` is the checklist, ordered so each item only depends on earlier
ones.

## Why the third tier

Writing a hash table teaches you what it costs. Knowing that `merge(key, 1,
Integer::sum)` increments a count in one call is what makes you fast. They are
different skills and you want both, so the `usage` drills deliberately cover
the same ground as the `structures` you built by hand — and each one names the
trap that costs people real time (`PriorityQueue` is a min-heap, `split` takes
a regex, `List.of` is immutable, `clone()` on a 2D array is shallow).

## How to work through one

1. Read the javadoc. It states the goal and names the technique and the target
   complexity, but never the solution.
2. Run that one test class and watch it fail.
3. Implement the stub.
4. Re-run. When it is green, check your complexity against the target: passing
   the tests with the wrong complexity is only half the exercise.

Where a javadoc mentions a second approach ("also write the O(1) space
version", "then rewrite it in O(n log n)"), that second version is the point.
Do it.

## Where the problems went

Anything shaped like a judge submission — LeetCode, Beecrowd, HackerRank,
Codeforces — belongs in `competitive-programming-notebook`, which has the
recall-card format, the platform layout and the run/stress tooling for it.
This repo stays deliberately boring: build the structure, walk it, use it.
