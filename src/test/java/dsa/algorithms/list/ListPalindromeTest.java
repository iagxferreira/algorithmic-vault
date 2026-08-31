package dsa.algorithms.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dsa.support.ListNodes;
import org.junit.jupiter.api.Test;

class ListPalindromeTest {

    @Test
    void acceptsPalindromes() {
        assertTrue(ListPalindrome.isPalindrome(null));
        assertTrue(ListPalindrome.isPalindrome(ListNodes.of(1)));
        assertTrue(ListPalindrome.isPalindrome(ListNodes.of(1, 1)));
        assertTrue(ListPalindrome.isPalindrome(ListNodes.of(1, 2, 1)));
        assertTrue(ListPalindrome.isPalindrome(ListNodes.of(1, 2, 2, 1)));
    }

    @Test
    void rejectsNonPalindromes() {
        assertFalse(ListPalindrome.isPalindrome(ListNodes.of(1, 2)));
        assertFalse(ListPalindrome.isPalindrome(ListNodes.of(1, 2, 3, 1)));
        assertFalse(ListPalindrome.isPalindrome(ListNodes.of(1, 2, 3, 2, 2)));
    }
}
