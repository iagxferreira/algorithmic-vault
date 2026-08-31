# Shortest paths and spanning trees

`dsa.algorithms.graph` (the weighted half) — 5 classes
Read [`graph-traversal.md`](./graph-traversal.md) first.
Structure to build first: `dsa.structures.MinHeap`, `dsa.structures.UnionFind`

## Why this topic

Once edges have weights, "fewest hops" stops meaning "cheapest", and BFS is
no longer enough. Which algorithm you reach for is decided entirely by the
shape of the weights:

| Situation | Use | Cost |
|---|---|---|
| all edges cost the same | BFS | O(V+E) |
| non-negative weights, one source | **Dijkstra** | O(E log V) |
| negative weights allowed, one source | **Bellman-Ford** | O(V·E) |
| a cap on the number of edges used | **Bellman-Ford**, k rounds | O(k·E) |
| every pair, small V | **Floyd-Warshall** | O(V³) |
| connect everything, cheapest total | **Kruskal / Prim** | O(E log E) |

Being able to fill that table from memory is the deliverable of this topic.

## Understand before you write code

1. **Why Dijkstra needs non-negative weights.** Its guarantee is "the first
   time a vertex leaves the heap, its distance is final". A negative edge
   could reduce that distance afterwards, breaking the guarantee. Dijkstra
   on negative edges is not slow — it is *wrong*.
2. **Why V−1 rounds are enough for Bellman-Ford.** A shortest path visits
   each vertex at most once, so it uses at most V−1 edges. After k rounds,
   every path of at most k edges is correct.
3. **Why a V-th improving round means a negative cycle.** Nothing can
   improve after V−1 rounds unless a cycle keeps lowering the total.
4. **Why Floyd-Warshall needs k outermost.** The invariant is "shortest
   paths using only intermediates from 0..k". Any other loop order does not
   maintain it.
5. **Shortest-path tree ≠ minimum spanning tree.** They optimise different
   things — Dijkstra minimises each vertex's distance *from the source*, an
   MST minimises the *total edge weight*. Build a 3-vertex example where
   they differ. (Try 0-1 = 1, 1-2 = 1, 0-2 = 2.)
6. **Prim is Dijkstra with a different priority.** Dijkstra pushes
   `dist[u] + w`; Prim pushes just `w`. Same loop, different meaning. Once
   you see that, both are one algorithm.

## Order to implement

- [ ] `Dijkstra` — `distances`, then `path` with a parent array
- [ ] `BellmanFord` — `distances` and the negative-cycle check, then `distancesWithin`
- [ ] `FloydWarshall` — five lines, one overflow trap
- [ ] `Kruskal` — needs `UnionFind` working first
- [ ] `Prim` — write it next to Dijkstra and compare them line by line

## Traps

- **`Integer.MAX_VALUE` arithmetic.** `INF + weight` overflows to a
  negative and looks like a fantastic path. Guard with
  `if (dist[u] == INF) continue;` before relaxing. Floyd-Warshall has a
  test for exactly this.
- **No decrease-key in Java's `PriorityQueue`.** Push duplicate entries and
  skip stale ones with `if (d > dist[u]) continue;`. Trying to remove and
  re-add is O(n) per operation.
- **Bellman-Ford in-place relaxation.** For the *uncapped* version, relaxing
  in place is fine and converges faster. For `distancesWithin` it is a bug:
  one round could chain several edges. Relax from a snapshot there.
- **1-based vertex labels.** Many problems label vertices 1..n. Pick one
  convention per solution rather than converting halfway through.
- **Kruskal without union by rank** degrades `find` to O(n) on a chain.
- **Disconnected graphs** have no spanning tree at all. Count the edges you
  accepted: fewer than V−1 means failure, and that check is easy to omit.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.graph.Dijkstra*'
./gradlew test --tests '*BellmanFordTest'
```

`Graphs.weighted(n, edges, directed)` in the test sources builds the
`List<List<int[]>>` these consume, where each `int[]` is
`{neighbour, weight}`.

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0743-network-delay-time` — plain Dijkstra, then take the max
- `leetcode/0787-cheapest-flights-within-k-stops` — why Dijkstra is wrong here
- `leetcode/0778-swim-in-rising-water` — Dijkstra with `max` instead of `+`
- `leetcode/1584-min-cost-to-connect-all-points` — MST on a dense graph
- `leetcode/0547-number-of-provinces` and `0684-redundant-connection` — union-find first
