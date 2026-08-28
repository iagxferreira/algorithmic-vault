use std::cmp::Reverse;
use std::collections::BinaryHeap;

pub fn dijkstra(graph: &[Vec<(usize, u32)>], start: usize) -> Vec<u32> {
    let mut dist = vec![u32::MAX; graph.len()];
    let mut heap = BinaryHeap::new();

    dist[start] = 0;
    heap.push((Reverse(0u32), start));

    while let Some((Reverse(cost), node)) = heap.pop() {
        if cost > dist[node] {
            continue;
        }

        for &(next, weight) in &graph[node] {
            let next_cost = cost.saturating_add(weight);
            if next_cost < dist[next] {
                dist[next] = next_cost;
                heap.push((Reverse(next_cost), next));
            }
        }
    }

    dist
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn computes_shortest_paths() {
        let graph = vec![
            vec![(1, 4), (2, 1)],
            vec![(3, 1)],
            vec![(1, 2), (3, 5)],
            vec![],
        ];

        assert_eq!(dijkstra(&graph, 0), vec![0, 3, 1, 4]);
    }
}
