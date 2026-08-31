package dsa.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SearchAnswerTest {

    @Test
    void firstTrueFindsTheBoundary() {
        assertEquals(5, SearchAnswer.firstTrue(0, 10, x -> x >= 5));
        assertEquals(0, SearchAnswer.firstTrue(0, 10, x -> true));
        assertEquals(11, SearchAnswer.firstTrue(0, 10, x -> false), "never true gives high + 1");
    }

    @Test
    void lastTrueIsTheMirrorImage() {
        assertEquals(5, SearchAnswer.lastTrue(0, 10, x -> x <= 5));
        assertEquals(10, SearchAnswer.lastTrue(0, 10, x -> true));
        assertEquals(-1, SearchAnswer.lastTrue(0, 10, x -> false), "never true gives low - 1");
    }

    @Test
    void searchesANonZeroBasedRange() {
        assertEquals(7, SearchAnswer.firstTrue(3, 20, x -> x * x >= 49));
    }

    @Test
    void integerSquareRootFloorsTheResult() {
        assertEquals(0, SearchAnswer.integerSquareRoot(0));
        assertEquals(1, SearchAnswer.integerSquareRoot(1));
        assertEquals(1, SearchAnswer.integerSquareRoot(3));
        assertEquals(4, SearchAnswer.integerSquareRoot(16));
        assertEquals(4, SearchAnswer.integerSquareRoot(24));
    }

    @Test
    void integerSquareRootSurvivesTheOverflowCase() {
        assertEquals(46340, SearchAnswer.integerSquareRoot(Integer.MAX_VALUE),
                "mid * mid overflows int here; widen or divide instead");
    }
}
