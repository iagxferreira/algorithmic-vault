# Roadmap

Ordered so that nothing depends on something further down. Tick items off as
their tests go green.

## Phase 1 - build the containers

`dsa.structures`

- [ ] `DynamicArray` - amortised growth
- [ ] `SinglyLinkedList` - pointer rewiring, in-place reversal
- [ ] `DoublyLinkedList` - O(1) removal from both ends
- [ ] `ArrayStack` - LIFO over an array
- [ ] `CircularQueue` - FIFO over a ring buffer
- [ ] `HashTable` - separate chaining, load factor, resizing
- [ ] `MinHeap` - sift up, sift down, O(n) heapify
- [ ] `BinarySearchTree` - insert, search, delete (all three cases)
- [ ] `Trie` - prefix walking
- [ ] `UnionFind` - path compression and union by rank
- [ ] `LRUCache` - hash map plus doubly linked list
- [ ] `Graph` - adjacency list, directed and undirected
- [ ] `FenwickTree` - point update, prefix sum, `i & -i`
- [ ] `SegmentTree` - range sum and range min, point assignment

## Phase 2 - learn the techniques

`dsa.fundamentals`

- [ ] `Sorting` - bubble, selection, insertion, merge, quick, heap, counting
- [ ] `Sorting` - partition, quickselect, inversion counting
- [ ] `BinarySearch` - sorted array, bounds, first/last occurrence
- [ ] `BinarySearch` - rotated array, matrix, bst
- [ ] `BinarySearch` - over the answer space (`firstTrue`, integer sqrt, peak)
- [ ] `ListTraversal` - length, middle, kth from end
- [ ] `ListTraversal` - reversal, iterative and recursive
- [ ] `ListTraversal` - Floyd cycle detection, palindrome check
- [ ] `TreeTraversal` - pre, in and post order, recursively
- [ ] `TreeTraversal` - the same three iteratively, with an explicit stack
- [ ] `TreeTraversal` - level order, zigzag, right side view, paths
- [ ] `GraphTraversal` - dfs recursive and iterative, bfs
- [ ] `GraphTraversal` - distances, path reconstruction, components
- [ ] `GraphTraversal` - cycle detection, topological sort, bipartite check
- [ ] `ShortestPaths` - Dijkstra, with and without the path
- [ ] `ShortestPaths` - Bellman-Ford and negative cycles
- [ ] `ShortestPaths` - Floyd-Warshall
- [ ] `MinimumSpanningTree` - Kruskal and Prim
- [ ] `SlidingWindow` - fixed, variable, monotonic deque
- [ ] `PrefixSums` - 1d, 2d, difference array, subarray counting
- [ ] `NumberTheory` - gcd/lcm, fast power, modPow, sieve, factorisation
- [ ] `Bits` - masks, subset enumeration, xor tricks

## Phase 3 - patterns on real problems

`dsa.exercises`

### Arrays and hashing
- [ ] Two Sum
- [ ] Contains Duplicate
- [ ] Valid Anagram
- [ ] Group Anagrams
- [ ] Product of Array Except Self
- [ ] Top K Frequent Elements
- [ ] Longest Consecutive Sequence

### Two pointers
- [ ] Valid Palindrome
- [ ] Two Sum II (sorted)
- [ ] 3Sum
- [ ] Container With Most Water
- [ ] Trapping Rain Water
- [ ] Sort Colors (Dutch flag)

### Sliding window
- [ ] Best Time to Buy and Sell Stock
- [ ] Longest Repeating Character Replacement
- [ ] Permutation in String
- [ ] Max Consecutive Ones III
- [ ] Minimum Window Substring

### Linked lists
- [ ] Merge Two Sorted Lists
- [ ] Remove Nth Node From End
- [ ] Reorder List
- [ ] Add Two Numbers
- [ ] Merge k Sorted Lists
- [ ] Reverse Nodes in k-Group

### Stacks
- [ ] Valid Parentheses
- [ ] Min Stack
- [ ] Evaluate Reverse Polish Notation
- [ ] Daily Temperatures (monotonic stack)
- [ ] Largest Rectangle in Histogram

### Trees
- [ ] Invert Binary Tree
- [ ] Same Tree
- [ ] Validate Binary Search Tree
- [ ] Lowest Common Ancestor of a BST
- [ ] Kth Smallest Element in a BST
- [ ] Diameter of Binary Tree
- [ ] Construct Tree from Preorder and Inorder

### Heaps
- [ ] Kth Largest Element
- [ ] K Closest Points to Origin
- [ ] Last Stone Weight
- [ ] Task Scheduler
- [ ] Find Median from Data Stream

### Graphs
- [ ] Number of Islands
- [ ] Rotting Oranges (multi-source bfs)
- [ ] Course Schedule
- [ ] Pacific Atlantic Water Flow
- [ ] Network Delay Time (Dijkstra)
- [ ] Cheapest Flights Within K Stops (Bellman-Ford)

### Backtracking
- [ ] Subsets
- [ ] Permutations
- [ ] Combination Sum
- [ ] Word Search
- [ ] Generate Parentheses
- [ ] N-Queens

### Dynamic programming
- [ ] Maximum Subarray (Kadane)
- [ ] Climbing Stairs
- [ ] House Robber
- [ ] Coin Change
- [ ] Longest Increasing Subsequence
- [ ] Longest Common Subsequence
- [ ] Word Break
- [ ] Edit Distance
- [ ] Unique Paths

### Greedy and intervals
- [ ] Jump Game
- [ ] Jump Game II
- [ ] Gas Station
- [ ] Merge Intervals
- [ ] Non-overlapping Intervals
- [ ] Meeting Rooms II

## Later

Things deliberately left out, worth adding once the above is green:

- Segment tree with lazy propagation, and range assignment
- Strongly connected components (Tarjan or Kosaraju), bridges and articulation points
- Max flow (Dinic), bipartite matching
- String algorithms: KMP, Z-function, rolling hash, suffix array
- Bitmask and digit dynamic programming, convex hull trick
- Balanced trees: AVL or red-black rotations
