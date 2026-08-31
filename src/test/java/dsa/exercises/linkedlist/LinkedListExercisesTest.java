package dsa.exercises.linkedlist;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import dsa.support.ListNode;
import dsa.support.ListNodes;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedListExercisesTest {

    @Nested
    class MergeTwoSortedListsTest {

        @Test
        void interleavesTwoSortedLists() {
            assertArrayEquals(
                    new int[] {1, 1, 2, 3, 4, 4},
                    ListNodes.toArray(MergeTwoSortedLists.solve(ListNodes.of(1, 2, 4), ListNodes.of(1, 3, 4))));
        }

        @Test
        void handlesEmptyInputs() {
            assertNull(MergeTwoSortedLists.solve(null, null));
            assertArrayEquals(new int[] {1}, ListNodes.toArray(MergeTwoSortedLists.solve(null, ListNodes.of(1))));
            assertArrayEquals(new int[] {1}, ListNodes.toArray(MergeTwoSortedLists.solve(ListNodes.of(1), null)));
        }

        @Test
        void handlesDisjointRanges() {
            assertArrayEquals(
                    new int[] {1, 2, 8, 9},
                    ListNodes.toArray(MergeTwoSortedLists.solve(ListNodes.of(8, 9), ListNodes.of(1, 2))));
        }
    }

    @Nested
    class RemoveNthFromEndTest {

        @Test
        void removesFromTheMiddle() {
            assertArrayEquals(
                    new int[] {1, 2, 3, 5},
                    ListNodes.toArray(RemoveNthFromEnd.solve(ListNodes.of(1, 2, 3, 4, 5), 2)));
        }

        @Test
        void removesTheHeadAndTheOnlyNode() {
            assertArrayEquals(new int[] {2, 3}, ListNodes.toArray(RemoveNthFromEnd.solve(ListNodes.of(1, 2, 3), 3)));
            assertNull(RemoveNthFromEnd.solve(ListNodes.of(1), 1));
        }

        @Test
        void removesTheTail() {
            assertArrayEquals(new int[] {1, 2}, ListNodes.toArray(RemoveNthFromEnd.solve(ListNodes.of(1, 2, 3), 1)));
        }
    }

    @Nested
    class ReorderListTest {

        @Test
        void interleavesFromBothEnds() {
            assertArrayEquals(new int[] {1, 4, 2, 3}, ListNodes.toArray(ReorderList.solve(ListNodes.of(1, 2, 3, 4))));
            assertArrayEquals(
                    new int[] {1, 5, 2, 4, 3},
                    ListNodes.toArray(ReorderList.solve(ListNodes.of(1, 2, 3, 4, 5))));
        }

        @Test
        void leavesShortListsAlone() {
            assertArrayEquals(new int[] {1}, ListNodes.toArray(ReorderList.solve(ListNodes.of(1))));
            assertArrayEquals(new int[] {1, 2}, ListNodes.toArray(ReorderList.solve(ListNodes.of(1, 2))));
            assertNull(ReorderList.solve(null));
        }
    }

    @Nested
    class AddTwoNumbersTest {

        @Test
        void addsDigitwise() {
            assertArrayEquals(
                    new int[] {7, 0, 8},
                    ListNodes.toArray(AddTwoNumbers.solve(ListNodes.of(2, 4, 3), ListNodes.of(5, 6, 4))));
        }

        @Test
        void carriesPastTheEnd() {
            assertArrayEquals(
                    new int[] {0, 0, 0, 1},
                    ListNodes.toArray(AddTwoNumbers.solve(ListNodes.of(9, 9, 9), ListNodes.of(1))));
        }

        @Test
        void handlesDifferentLengthsAndZero() {
            assertArrayEquals(
                    new int[] {0},
                    ListNodes.toArray(AddTwoNumbers.solve(ListNodes.of(0), ListNodes.of(0))));
            assertArrayEquals(
                    new int[] {8, 9, 9, 9, 0, 0, 0, 1},
                    ListNodes.toArray(AddTwoNumbers.solve(
                            ListNodes.of(9, 9, 9, 9, 9, 9, 9), ListNodes.of(9, 9, 9, 9))));
        }
    }

    @Nested
    class MergeKSortedListsTest {

        @Test
        void mergesThreeLists() {
            ListNode[] lists = {ListNodes.of(1, 4, 5), ListNodes.of(1, 3, 4), ListNodes.of(2, 6)};
            assertArrayEquals(new int[] {1, 1, 2, 3, 4, 4, 5, 6}, ListNodes.toArray(MergeKSortedLists.solve(lists)));
        }

        @Test
        void handlesEmptyAndNullEntries() {
            assertNull(MergeKSortedLists.solve(new ListNode[] {}));
            assertNull(MergeKSortedLists.solve(new ListNode[] {null, null}));
            assertArrayEquals(
                    new int[] {1, 2},
                    ListNodes.toArray(MergeKSortedLists.solve(new ListNode[] {null, ListNodes.of(1, 2), null})));
        }
    }

    @Nested
    class ReverseNodesInKGroupTest {

        @Test
        void reversesFullBlocksOnly() {
            assertArrayEquals(
                    new int[] {2, 1, 4, 3, 5},
                    ListNodes.toArray(ReverseNodesInKGroup.solve(ListNodes.of(1, 2, 3, 4, 5), 2)));
            assertArrayEquals(
                    new int[] {3, 2, 1, 4, 5},
                    ListNodes.toArray(ReverseNodesInKGroup.solve(ListNodes.of(1, 2, 3, 4, 5), 3)));
        }

        @Test
        void handlesKOfOneAndKLargerThanTheList() {
            assertArrayEquals(
                    new int[] {1, 2, 3},
                    ListNodes.toArray(ReverseNodesInKGroup.solve(ListNodes.of(1, 2, 3), 1)));
            assertArrayEquals(
                    new int[] {1, 2, 3},
                    ListNodes.toArray(ReverseNodesInKGroup.solve(ListNodes.of(1, 2, 3), 5)));
        }

        @Test
        void reversesTheWholeListWhenItDividesEvenly() {
            assertArrayEquals(
                    new int[] {4, 3, 2, 1},
                    ListNodes.toArray(ReverseNodesInKGroup.solve(ListNodes.of(1, 2, 3, 4), 4)));
        }
    }
}
