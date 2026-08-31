package dsa.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FloydWarshallTest {

    private static final int INF = Integer.MAX_VALUE;

    @Test
    void fillsInTransitiveDistances() {
        int[][] matrix = {
            {0, 3, INF},
            {INF, 0, 1},
            {INF, INF, 0}
        };
        int[][] expected = {
            {0, 3, 4},
            {INF, 0, 1},
            {INF, INF, 0}
        };
        assertArrayEquals(expected, FloydWarshall.distances(matrix));
    }

    @Test
    void prefersTheCheaperTwoHopRoute() {
        int[][] matrix = {
            {0, 1, 10},
            {INF, 0, 1},
            {INF, INF, 0}
        };
        assertEquals(2, FloydWarshall.distances(matrix)[0][2]);
    }

    @Test
    void doesNotMutateTheInput() {
        int[][] matrix = {{0, 3, INF}, {INF, 0, 1}, {INF, INF, 0}};
        FloydWarshall.distances(matrix);
        assertEquals(INF, matrix[0][2], "the input matrix must be left alone");
    }

    @Test
    void doesNotRelaxThroughUnreachableIntermediates() {
        int[][] matrix = {
            {0, INF},
            {INF, 0}
        };
        assertArrayEquals(new int[][] {{0, INF}, {INF, 0}}, FloydWarshall.distances(matrix),
                "adding two MAX_VALUEs overflows to a negative and looks like a cheap path");
    }

    @Test
    void handlesASingleVertex() {
        assertArrayEquals(new int[][] {{0}}, FloydWarshall.distances(new int[][] {{0}}));
    }
}
