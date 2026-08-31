package dsa.algorithms.scanning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VariableWindowTest {

    @Test
    void findsTheShortestSubarrayReachingTheTarget() {
        assertEquals(2, VariableWindow.minLengthWithSumAtLeast(new int[] {2, 3, 1, 2, 4, 3}, 7));
        assertEquals(1, VariableWindow.minLengthWithSumAtLeast(new int[] {1, 4, 4}, 4));
        assertEquals(5, VariableWindow.minLengthWithSumAtLeast(new int[] {1, 1, 1, 1, 1}, 5));
    }

    @Test
    void reportsZeroWhenTheTargetIsUnreachable() {
        assertEquals(0, VariableWindow.minLengthWithSumAtLeast(new int[] {1, 1, 1}, 11));
        assertEquals(0, VariableWindow.minLengthWithSumAtLeast(new int[] {}, 1));
    }

    @Test
    void findsTheLongestSubstringWithoutRepeats() {
        assertEquals(3, VariableWindow.longestUniqueSubstring("abcabcbb"));
        assertEquals(1, VariableWindow.longestUniqueSubstring("bbbbb"));
        assertEquals(3, VariableWindow.longestUniqueSubstring("pwwkew"));
        assertEquals(0, VariableWindow.longestUniqueSubstring(""));
    }

    @Test
    void limitsTheNumberOfDistinctCharacters() {
        assertEquals(3, VariableWindow.longestWithAtMostKDistinct("eceba", 2));
        assertEquals(2, VariableWindow.longestWithAtMostKDistinct("aa", 1));
        assertEquals(5, VariableWindow.longestWithAtMostKDistinct("abcde", 5));
        assertEquals(0, VariableWindow.longestWithAtMostKDistinct("abc", 0));
    }

    @Test
    void countsTheLongestRunAfterFlips() {
        assertEquals(6, VariableWindow.longestOnesWithKFlips(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        assertEquals(3, VariableWindow.longestOnesWithKFlips(new int[] {1, 1, 1, 0, 1, 1}, 0));
        assertEquals(4, VariableWindow.longestOnesWithKFlips(new int[] {1, 1, 1, 1}, 2));
        assertEquals(0, VariableWindow.longestOnesWithKFlips(new int[] {}, 1));
    }

    @Test
    void flippingEveryZeroCoversTheWholeArray() {
        assertEquals(4, VariableWindow.longestOnesWithKFlips(new int[] {0, 0, 0, 0}, 4));
    }
}
