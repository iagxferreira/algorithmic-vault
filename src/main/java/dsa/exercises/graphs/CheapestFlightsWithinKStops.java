package dsa.exercises.graphs;

/**
 * Cheapest Flights Within K Stops.
 *
 * <p>{@code flights[i] = {from, to, price}} over cities {@code 0..n-1}. Find
 * the cheapest route from {@code source} to {@code target} using at most
 * {@code maxStops} intermediate stops, or -1 when there is none.
 *
 * <p>Example: {@code n = 4}, {@code [[0,1,100],[1,2,100],[2,0,100],[1,3,600],
 * [2,3,200]]}, {@code source = 0, target = 3, maxStops = 1} gives 700.
 *
 * <p>Plain Dijkstra is wrong here: a route that is cheap now may use up the
 * stop budget, and a pricier one with fewer stops can win later. Bellman-Ford
 * fits perfectly instead, since running exactly {@code maxStops + 1} relaxation
 * rounds bounds the number of edges used. Relax from a snapshot of the previous
 * round, not from the array you are writing into.
 */
public final class CheapestFlightsWithinKStops {

    public static int solve(int n, int[][] flights, int source, int target, int maxStops) {
        throw new UnsupportedOperationException("TODO: CheapestFlightsWithinKStops.solve");
    }
}
