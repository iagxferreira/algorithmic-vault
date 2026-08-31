package dsa.exercises.greedy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GreedyExercisesTest {

    @Nested
    class JumpGameTest {

        @Test
        void reachesTheEnd() {
            assertTrue(JumpGame.solve(new int[] {2, 3, 1, 1, 4}));
            assertTrue(JumpGame.solve(new int[] {0}));
        }

        @Test
        void getsStuckOnAZero() {
            assertFalse(JumpGame.solve(new int[] {3, 2, 1, 0, 4}));
            assertFalse(JumpGame.solve(new int[] {0, 1}));
        }
    }

    @Nested
    class JumpGameIITest {

        @Test
        void countsTheFewestJumps() {
            assertEquals(2, JumpGameII.solve(new int[] {2, 3, 1, 1, 4}));
            assertEquals(2, JumpGameII.solve(new int[] {2, 3, 0, 1, 4}));
        }

        @Test
        void needsNoJumpsForASingleIndex() {
            assertEquals(0, JumpGameII.solve(new int[] {0}));
            assertEquals(1, JumpGameII.solve(new int[] {1, 1}));
        }
    }

    @Nested
    class GasStationTest {

        @Test
        void findsTheOnlyViableStart() {
            assertEquals(3, GasStation.solve(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
            assertEquals(0, GasStation.solve(new int[] {5}, new int[] {4}));
        }

        @Test
        void reportsAnImpossibleLoop() {
            assertEquals(-1, GasStation.solve(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
            assertEquals(-1, GasStation.solve(new int[] {1}, new int[] {2}));
        }
    }

    @Nested
    class MergeIntervalsTest {

        @Test
        void mergesOverlappingRanges() {
            assertArrayEquals(
                    new int[][] {{1, 6}, {8, 10}, {15, 18}},
                    MergeIntervals.solve(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        }

        @Test
        void mergesTouchingRanges() {
            assertArrayEquals(new int[][] {{1, 5}}, MergeIntervals.solve(new int[][] {{1, 4}, {4, 5}}));
        }

        @Test
        void sortsUnorderedInputAndAbsorbsNestedRanges() {
            assertArrayEquals(
                    new int[][] {{1, 10}},
                    MergeIntervals.solve(new int[][] {{2, 3}, {1, 10}, {4, 5}}));
            assertArrayEquals(new int[][] {}, MergeIntervals.solve(new int[][] {}));
        }
    }

    @Nested
    class NonOverlappingIntervalsTest {

        @Test
        void removesTheFewestIntervals() {
            assertEquals(1, NonOverlappingIntervals.solve(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
            assertEquals(2, NonOverlappingIntervals.solve(new int[][] {{1, 2}, {1, 2}, {1, 2}}));
        }

        @Test
        void removesNothingWhenNothingOverlaps() {
            assertEquals(0, NonOverlappingIntervals.solve(new int[][] {{1, 2}, {2, 3}}));
            assertEquals(0, NonOverlappingIntervals.solve(new int[][] {}));
        }

        @Test
        void prefersTheIntervalEndingEarliest() {
            assertEquals(2, NonOverlappingIntervals.solve(new int[][] {{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        }
    }

    @Nested
    class MeetingRoomsTest {

        @Test
        void countsConcurrentMeetings() {
            assertEquals(2, MeetingRooms.solve(new int[][] {{0, 30}, {5, 10}, {15, 20}}));
            assertEquals(3, MeetingRooms.solve(new int[][] {{0, 30}, {5, 10}, {6, 20}}));
        }

        @Test
        void reusesARoomFreedAtTheSameMinute() {
            assertEquals(1, MeetingRooms.solve(new int[][] {{7, 10}, {2, 4}}));
            assertEquals(1, MeetingRooms.solve(new int[][] {{1, 5}, {5, 10}}));
        }

        @Test
        void handlesNoMeetings() {
            assertEquals(0, MeetingRooms.solve(new int[][] {}));
        }
    }
}
