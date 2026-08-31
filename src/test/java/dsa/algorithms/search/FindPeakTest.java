package dsa.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FindPeakTest {

    @Test
    void findsTheObviousPeak() {
        assertEquals(2, FindPeak.findPeak(new int[] {1, 2, 3, 1}));
        assertEquals(0, FindPeak.findPeak(new int[] {5}));
        assertEquals(1, FindPeak.findPeak(new int[] {1, 2}));
        assertEquals(0, FindPeak.findPeak(new int[] {2, 1}));
    }

    @Test
    void anyPeakIsAcceptable() {
        int peak = FindPeak.findPeak(new int[] {1, 2, 1, 3, 5, 6, 4});
        assertTrue(peak == 1 || peak == 5, "expected index 1 or 5 but was " + peak);
    }

    @Test
    void handlesMonotonicInput() {
        assertEquals(3, FindPeak.findPeak(new int[] {1, 2, 3, 4}), "rising array peaks at the end");
        assertEquals(0, FindPeak.findPeak(new int[] {4, 3, 2, 1}), "falling array peaks at the start");
    }
}
