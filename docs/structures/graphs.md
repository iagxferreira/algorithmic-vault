# Graph representation

`dsa.structures.Graph`

Algorithms are in
[`docs/algorithms/graph-traversal.md`](../algorithms/graph-traversal.md)
and [`shortest-paths.md`](../algorithms/shortest-paths.md).

## Why build it

Because *how you store the graph decides what is cheap*, and choosing
wrongly costs you an order of magnitude before you write a single line of
algorithm.

## Understand before you write code

1. **Adjacency list vs adjacency matrix.**

   | | list | matrix |
   |---|---|---|
   | memory | O(V + E) | O(V²) |
   | walk a vertex's neighbours | O(deg v) | O(V) |
   | "is there an edge u→v?" | O(deg u) | **O(1)** |

   Traversal walks neighbours constantly, so the list wins almost always.
   The matrix wins for dense graphs and for Floyd-Warshall.
2. **Directed vs undirected is one line.** An undirected edge is two
   directed edges. Deciding this at construction, once, keeps every caller
   simple.
3. **Edge count in an undirected graph.** Each edge appears twice in the
   adjacency list, so counting entries and halving is the trap — track it
   instead.
4. **Weighted graphs need a different element type.** `List<List<Integer>>`
   becomes `List<List<int[]>>` holding `{neighbour, weight}`. Ours exposes
   the unweighted form; the weighted algorithms take theirs directly.
5. **Grids are graphs.** An `m × n` grid is a graph with `m·n` vertices and
   four edges each. You almost never build a `Graph` object for one — you
   just use the four direction offsets — but recognising the equivalence is
   what makes island and maze problems easy.

## Implement

- [ ] `addEdge` — respecting `directed`
- [ ] `neighbours`, `degree`, `hasEdge`
- [ ] `vertexCount`, `edgeCount` — an undirected pair counts once
- [ ] `adjacency` — the whole list, which the algorithms consume

## Traps

- **`edgeCount` on an undirected graph** — see point 3. Tested.
- **`neighbours` order** should be insertion order, so traversals are
  deterministic and testable.
- **Isolated vertices** still exist and must return an empty neighbour list,
  not null. Tested.
- **Self-loops and parallel edges** — decide whether you allow them. Ours
  does not forbid them; know that your algorithms must cope.

## Test it

```shell
./gradlew test --tests '*GraphTest'
```
