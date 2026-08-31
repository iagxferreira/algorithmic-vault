package dsa.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UnionFindTest {

    @Test
    void startsFullyDisconnected() {
        UnionFind uf = new UnionFind(5);
        assertEquals(5, uf.components());
        assertFalse(uf.connected(0, 1));
        assertTrue(uf.connected(3, 3));
    }

    @Test
    void unionMergesAndCountsDown() {
        UnionFind uf = new UnionFind(5);
        assertTrue(uf.union(0, 1));
        assertTrue(uf.union(1, 2));
        assertEquals(3, uf.components());
        assertTrue(uf.connected(0, 2));
    }

    @Test
    void unionOfAlreadyConnectedNodesIsANoop() {
        UnionFind uf = new UnionFind(4);
        uf.union(0, 1);
        assertFalse(uf.union(1, 0));
        assertEquals(3, uf.components());
    }

    @Test
    void findIsStableAcrossASet() {
        UnionFind uf = new UnionFind(6);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(1, 3);
        assertEquals(uf.find(0), uf.find(3));
        assertEquals(uf.find(1), uf.find(2));
    }

    @Test
    void handlesALongChain() {
        UnionFind uf = new UnionFind(1000);
        for (int i = 0; i < 999; i++) {
            uf.union(i, i + 1);
        }
        assertEquals(1, uf.components());
        assertTrue(uf.connected(0, 999));
    }
}
