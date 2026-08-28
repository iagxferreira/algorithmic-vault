use std::collections::VecDeque;

pub fn bfs(graph: &[Vec<usize>], start: usize) -> Vec<usize> {
    let mut visited = vec![false; graph.len()];
    let mut order = Vec::new();
    let mut queue = VecDeque::from([start]);

    visited[start] = true;

    while let Some(node) = queue.pop_front() {
        order.push(node);

        for &next in &graph[node] {
            if !visited[next] {
                visited[next] = true;
                queue.push_back(next);
            }
        }
    }

    order
}

pub fn dfs(graph: &[Vec<usize>], start: usize) -> Vec<usize> {
    fn visit(node: usize, graph: &[Vec<usize>], visited: &mut [bool], order: &mut Vec<usize>) {
        visited[node] = true;
        order.push(node);

        for &next in &graph[node] {
            if !visited[next] {
                visit(next, graph, visited, order);
            }
        }
    }

    let mut visited = vec![false; graph.len()];
    let mut order = Vec::new();
    visit(start, graph, &mut visited, &mut order);
    order
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn traverses_breadth_first() {
        let graph = vec![vec![1, 2], vec![3], vec![3], vec![]];
        assert_eq!(bfs(&graph, 0), vec![0, 1, 2, 3]);
    }

    #[test]
    fn traverses_depth_first() {
        let graph = vec![vec![1, 2], vec![3], vec![3], vec![]];
        assert_eq!(dfs(&graph, 0), vec![0, 1, 3, 2]);
    }
}
