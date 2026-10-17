# Chapter 1: The Role of Algorithms

## Exercises

### Exercise 1.1-1: Real-world example requiring a convex hull

A marketing team could plot the locations of people who engaged with a social
media campaign and compute their convex hull. The resulting boundary gives the
team a rough geographic zone around those users to target with a follow-up
campaign. It is an approximation: the hull may include places where there are
no engaged users.

### Exercise 1.1-2: Other measures of efficiency

Besides running time, an algorithm can be judged by how much memory and storage
it uses, how much hardware it requires, and how much energy or network bandwidth
it consumes. These resources have real costs: an algorithm that needs more RAM
may require more expensive machines, while one that takes longer to run uses
more computing time and can increase operating costs. The most important measure
depends on the setting and its constraints.

### Exercise 1.1-3: Strengths and limitations of a data structure

I like trees and graphs because they provide useful abstractions for modeling
relationships and can make solutions easier to adapt to different problems. A
binary search tree, for example, keeps values ordered and can support efficient
searching, insertion, and deletion. Its limitation is that it can become
unbalanced: operations may then take linear time. Keeping it balanced avoids
that degradation, but adds implementation complexity and the cost of
rebalancing after updates.

### Exercise 1.1-4: Shortest path and traveling salesman

Both problems can be represented as weighted graphs and seek a route with a
small total edge weight. In a shortest-path problem, the route connects a
specified start vertex to a specified destination; it does not have to visit
every vertex or return to the start. In the traveling-salesman problem, the
route must visit every vertex (city) and return to its starting point. Finding
shortest paths between individual pairs of cities does not generally solve the
traveling-salesman problem, because the tour must satisfy the visit-every-city
constraint while minimizing its total length.

Their computational difficulty also differs. Shortest-path problems have
polynomial-time algorithms, while the traveling-salesman optimization problem
is NP-hard; its decision version (whether a tour of at most a given length
exists) is NP-complete. Brute force can solve either problem on small inputs,
but checking every possible tour takes factorial time, which quickly becomes
impractical. NP-completeness does not mean brute force is impossible; it means
no polynomial-time algorithm is known for the decision problem.

### Exercise 1.1-5: Exact and approximate solutions

**Exact solution:** A mail carrier needs to deliver letters to every block in a
small condominium and return to the mailroom before a strict cutoff. Model the
blocks and walkways as a weighted graph, then find the shortest tour that visits
every block and returns to the start. With only a few blocks, finding the exact
best route can be practical and shows whether the deadline can be met.

**Approximate solution:** In a very large condominium, there may be too many
possible visiting orders to search for the exact shortest tour quickly. The
carrier could instead follow a simple block-by-block order or repeatedly visit
the nearest unvisited block. The route may involve some extra walking, but it is
quick to plan and still gets every letter delivered. This is a useful trade-off
when a near-best route is sufficient and timely planning matters more than
proving the route is optimal.
