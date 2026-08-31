# Graph traversal

`dsa.algorithms.graph` (the unweighted half) — 6 classes
Structure to build first: `dsa.structures.Graph`

## Why this topic

Almost everything is a graph once you squint. A grid is a graph where each
cell has four neighbours. A dependency list is a graph. A word ladder is a
graph where edges join words one letter apart. **Modelling the problem as a
graph is the hard part; the traversal afterwards is boilerplate.**

DFS and BFS are the *same* algorithm with a different container:

```
put start in the container
while container not empty:
    take a vertex out          <- stack: DFS.  queue: BFS.
    if already visited: skip
    mark visited, process it
    put every unvisited neighbour in
```

That is the entire subject. Everything below is that loop plus bookkeeping.

## Understand before you write code

1. **Adjacency list vs adjacency matrix.** A list is O(V+E) memory and lets
   you walk a vertex's neighbours directly — what traversal needs. A matrix
   is O(V²) but answers "is there an edge?" in O(1). Know which you have.
2. **Why BFS gives shortest paths and DFS does not.** BFS finishes distance
   k entirely before starting k+1, so the first time it reaches a vertex is
   by the fewest hops. DFS reaches it by whatever route it wandered down.
3. **Why this only holds for unweighted graphs.** With weights, "fewest
   edges" ≠ "cheapest". That is where Dijkstra starts.
4. **Where to mark visited.** Mark when you *enqueue*, not when you dequeue.
   Marking on dequeue lets the same vertex enter the queue many times and
   turns O(V+E) into something much worse.
5. **Why undirected and directed cycle detection differ.** In an undirected
   graph every edge looks like a back edge from the far end — hence the
   parent check. In a directed graph you need three colours, because a
   revisited *finished* vertex is fine and a revisited *in-progress* one is
   a cycle. These are not the same algorithm.
6. **The outer loop.** One traversal explores one component. To answer
   anything about the whole graph — component count, bipartiteness, "does a
   cycle exist anywhere" — you must loop over all vertices and start a new
   search from each unvisited one.

## Order to implement

- [ ] `DepthFirstSearch` — recursive, then the explicit-stack version
- [ ] `BreadthFirstSearch` — traverse, distances, path reconstruction, multi-source
- [ ] `ConnectedComponents` — the outer loop, made explicit
- [ ] `CycleDetection` — undirected first, then the three-colour directed one
- [ ] `TopologicalSort` — Kahn, and do not skip the cycle check
- [ ] `Bipartite` — colouring during a traversal

Then continue to [`shortest-paths.md`](./shortest-paths.md) for the
weighted half.

## Traps

- **Iterative DFS push order.** A stack reverses you, so push neighbours in
  reverse to pop the smallest first.
- **Not marking visited on enqueue** — see point 4 above.
- **Forgetting the parent in undirected cycle detection** reports a cycle
  for a two-node graph.
- **Skipping only the parent *vertex*** breaks on parallel edges. Ours has
  none, but know the limitation.
- **Topological sort without the count check** returns a truncated order
  for a cyclic graph rather than reporting failure.
- **Bipartite on a disconnected graph** — colour every component.
- **Recursion depth.** A path graph with 10⁵ vertices overflows the default
  JVM stack. That is why the iterative versions exist.

## Test it

```shell
./gradlew test --tests 'dsa.algorithms.graph.*'
./gradlew test --tests '*CycleDetectionTest'
```

`Graphs` in the test sources builds adjacency lists from edge arrays, and
`Graphs.sample()` is the small graph most tests share. Ties always resolve
to the smallest vertex index so the expected orders are deterministic.

## Then challenge yourself

In [`competitive-programming-notebook`](../../../competitive-programming-notebook/):

- `leetcode/0733-flood-fill` then `0200-number-of-islands` — a grid is a graph
- `leetcode/0994-rotting-oranges` and `0542-01-matrix` — multi-source BFS
- `leetcode/0127-word-ladder` — the modelling is the whole problem
- `leetcode/0207-course-schedule` then `0210-course-schedule-ii`
- `leetcode/0547-number-of-provinces` — components, and compare against union-find
- `leetcode/0684-redundant-connection` — cycle detection, done incrementally
- `leetcode/0133-clone-graph` — traversal while building
