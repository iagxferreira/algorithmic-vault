package dsa.exercises.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GraphExercisesTest {

    private static List<String> asPairs(List<int[]> cells) {
        return cells.stream().map(Arrays::toString).collect(Collectors.toList());
    }

    @Nested
    class NumberOfIslandsTest {

        @Test
        void countsOneSolidBlock() {
            char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
            };
            assertEquals(1, NumberOfIslands.solve(grid));
        }

        @Test
        void countsSeparateIslands() {
            char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            };
            assertEquals(3, NumberOfIslands.solve(grid));
        }

        @Test
        void handlesWaterOnlyAndEmptyGrids() {
            assertEquals(0, NumberOfIslands.solve(new char[][] {{'0', '0'}, {'0', '0'}}));
            assertEquals(0, NumberOfIslands.solve(new char[][] {}));
        }

        @Test
        void doesNotConnectDiagonally() {
            assertEquals(2, NumberOfIslands.solve(new char[][] {{'1', '0'}, {'0', '1'}}));
        }
    }

    @Nested
    class RottingOrangesTest {

        @Test
        void spreadsFromEveryRottenCellAtOnce() {
            assertEquals(4, RottingOranges.solve(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
            assertEquals(1, RottingOranges.solve(new int[][] {{2, 2}, {1, 1}}));
        }

        @Test
        void reportsUnreachableFreshOranges() {
            assertEquals(-1, RottingOranges.solve(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        }

        @Test
        void needsNoTimeWithoutFreshOranges() {
            assertEquals(0, RottingOranges.solve(new int[][] {{0, 2}}));
            assertEquals(0, RottingOranges.solve(new int[][] {{0, 0}}));
        }
    }

    @Nested
    class CourseScheduleTest {

        @Test
        void acceptsADag() {
            assertTrue(CourseSchedule.solve(2, new int[][] {{1, 0}}));
            assertTrue(CourseSchedule.solve(3, new int[][] {}));
            assertTrue(CourseSchedule.solve(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        }

        @Test
        void rejectsACycle() {
            assertFalse(CourseSchedule.solve(2, new int[][] {{1, 0}, {0, 1}}));
            assertFalse(CourseSchedule.solve(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}));
        }
    }

    @Nested
    class PacificAtlanticWaterFlowTest {

        @Test
        void findsCellsDrainingBothWays() {
            int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
            };
            assertEquals(
                    List.of("[0, 4]", "[1, 3]", "[1, 4]", "[2, 2]", "[3, 0]", "[3, 1]", "[4, 0]"),
                    asPairs(PacificAtlanticWaterFlow.solve(heights)));
        }

        @Test
        void aSingleCellTouchesBothOceans() {
            assertEquals(List.of("[0, 0]"), asPairs(PacificAtlanticWaterFlow.solve(new int[][] {{1}})));
        }

        @Test
        void aFlatGridDrainsEverywhere() {
            assertEquals(4, PacificAtlanticWaterFlow.solve(new int[][] {{1, 1}, {1, 1}}).size());
        }
    }

    @Nested
    class NetworkDelayTimeTest {

        @Test
        void reportsTheSlowestArrival() {
            assertEquals(2, NetworkDelayTime.solve(new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        }

        @Test
        void prefersTheCheaperMultiHopRoute() {
            assertEquals(3, NetworkDelayTime.solve(new int[][] {{1, 2, 1}, {2, 3, 2}, {1, 3, 9}}, 3, 1));
        }

        @Test
        void reportsUnreachableNodes() {
            assertEquals(-1, NetworkDelayTime.solve(new int[][] {{1, 2, 1}}, 3, 1));
            assertEquals(0, NetworkDelayTime.solve(new int[][] {}, 1, 1));
        }
    }

    @Nested
    class CheapestFlightsWithinKStopsTest {

        private final int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        @Test
        void respectsTheStopBudget() {
            assertEquals(700, CheapestFlightsWithinKStops.solve(4, flights, 0, 3, 1));
            assertEquals(400, CheapestFlightsWithinKStops.solve(4, flights, 0, 3, 2));
        }

        @Test
        void reportsWhenNoRouteFits() {
            assertEquals(-1, CheapestFlightsWithinKStops.solve(4, flights, 0, 3, 0));
            assertEquals(-1, CheapestFlightsWithinKStops.solve(3, new int[][] {{0, 1, 5}}, 0, 2, 5));
        }

        @Test
        void reachingTheSourceCostsNothing() {
            assertEquals(0, CheapestFlightsWithinKStops.solve(4, flights, 0, 0, 0));
        }
    }
}
