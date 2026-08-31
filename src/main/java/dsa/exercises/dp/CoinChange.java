package dsa.exercises.dp;

/**
 * Coin Change.
 *
 * <p>Fewest coins adding up to {@code amount}, with unlimited coins of each
 * denomination, or -1 when it cannot be made.
 *
 * <p>Example: {@code coins = [1, 2, 5], amount = 11} gives 3, for 5 + 5 + 1.
 *
 * <p>The greedy "take the biggest coin first" is wrong here: with
 * {@code [1, 3, 4]} and amount 6 it gives 3 coins where 2 suffice. Build up
 * {@code best[amount]} from smaller amounts instead. O(amount * coins).
 */
public final class CoinChange {

    public static int solve(int[] coins, int amount) {
        throw new UnsupportedOperationException("TODO: CoinChange.solve");
    }
}
