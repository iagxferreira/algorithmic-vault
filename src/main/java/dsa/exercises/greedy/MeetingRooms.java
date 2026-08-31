package dsa.exercises.greedy;

/**
 * Meeting Rooms II.
 *
 * <p>Minimum number of rooms needed to hold every meeting, given as
 * {@code {start, end}}. A meeting ending exactly when another starts can reuse
 * the room.
 *
 * <p>Example: {@code [[0,30],[5,10],[15,20]]} gives 2.
 *
 * <p>Two good solutions. A min-heap of end times, popping rooms that have
 * freed up. Or the sweep line: sort all starts and all ends separately, walk
 * both, and track the running count of concurrent meetings, whose peak is the
 * answer. O(n log n) either way.
 */
public final class MeetingRooms {

    public static int solve(int[][] meetings) {
        throw new UnsupportedOperationException("TODO: MeetingRooms.solve");
    }
}
