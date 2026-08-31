package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void undirectedEdgesGoBothWays() {
        Graph graph = new Graph(3, false);
        graph.addEdge(0, 1);
        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 0));
        assertEquals(List.of(1), graph.neighbours(0));
        assertEquals(List.of(0), graph.neighbours(1));
        assertEquals(1, graph.edgeCount());
    }

    @Test
    void directedEdgesGoOneWay() {
        Graph graph = new Graph(3, true);
        graph.addEdge(0, 1);
        assertTrue(graph.hasEdge(0, 1));
        assertFalse(graph.hasEdge(1, 0));
        assertEquals(List.of(), graph.neighbours(1));
        assertEquals(1, graph.edgeCount());
    }

    @Test
    void tracksDegreeAndVertexCount() {
        Graph graph = new Graph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        assertEquals(4, graph.vertexCount());
        assertEquals(3, graph.degree(0));
        assertEquals(1, graph.degree(1));
    }

    @Test
    void exposesTheWholeAdjacencyList() {
        Graph graph = new Graph(3, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        assertEquals(List.of(List.of(1, 2), List.of(), List.of(1)), graph.adjacency());
    }

    @Test
    void isolatedVerticesHaveNoNeighbours() {
        Graph graph = new Graph(2, false);
        assertEquals(List.of(), graph.neighbours(0));
        assertEquals(0, graph.degree(1));
        assertEquals(0, graph.edgeCount());
    }
}
