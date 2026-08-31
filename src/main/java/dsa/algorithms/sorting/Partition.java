package dsa.algorithms.sorting;

/**
 * Partitioning - the primitive underneath quicksort and quickselect.
 *
 * <p>Rearrange {@code values[low..high]} around a pivot so everything smaller
 * sits left of it and everything larger sits right, then report where the
 * pivot ended up. Lomuto is the easier one to write; Hoare does fewer swaps.
 *
 * <p>Target: O(high - low) time, O(1) space.
 *
 * <p>See {@code docs/algorithms/sorting.md} for what to understand first.
 */
public final class Partition {

    private Partition() {
    }

    /**
     * Partitions the inclusive range around {@code values[high]}.
     *
     * @return the pivot's final index.
     */
    public static int partition(int[] values, int low, int high) {
        throw new UnsupportedOperationException("TODO: Partition.partition");
    }
}
