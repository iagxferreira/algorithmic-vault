# Queues In Rust

Notes and goals for queue and deque study.

## Core Concepts

- `VecDeque` is the standard library queue/deque building block.
- A queue is FIFO: push at the back, pop from the front.
- A deque supports both ends and is useful for sliding window problems.
- A custom queue is useful for learning invariants even if `VecDeque` exists.

## Implementation Goals

1. Implement a basic queue API.
2. Implement queue using two stacks.
3. Implement a monotonic queue.
4. Use queues for BFS.
5. Use deques for sliding window maximum.

## Exercise Goals

1. Implement Queue using Stacks.
2. Rotting Oranges.
3. Number of Islands.
4. Binary Tree Level Order Traversal.
5. Sliding Window Maximum.
