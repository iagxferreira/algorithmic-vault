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
