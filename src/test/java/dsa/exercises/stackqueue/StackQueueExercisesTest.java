package dsa.exercises.stackqueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StackQueueExercisesTest {

    @Nested
    class ValidParenthesesTest {

        @Test
        void acceptsBalancedInput() {
            assertTrue(ValidParentheses.solve("()"));
            assertTrue(ValidParentheses.solve("()[]{}"));
            assertTrue(ValidParentheses.solve("{[()]}"));
            assertTrue(ValidParentheses.solve(""));
        }

        @Test
        void rejectsMismatchedOrUnclosedInput() {
            assertFalse(ValidParentheses.solve("(]"));
            assertFalse(ValidParentheses.solve("([)]"));
            assertFalse(ValidParentheses.solve("("));
            assertFalse(ValidParentheses.solve(")"));
        }
    }

    @Nested
    class MinStackTest {

        @Test
        void reportsTheRunningMinimum() {
            MinStack stack = new MinStack();
            stack.push(-2);
            stack.push(0);
            stack.push(-3);
            assertEquals(-3, stack.getMin());
            stack.pop();
            assertEquals(0, stack.top());
            assertEquals(-2, stack.getMin());
        }

        @Test
        void handlesRepeatedMinima() {
            MinStack stack = new MinStack();
            stack.push(1);
            stack.push(1);
            stack.push(2);
            assertEquals(1, stack.getMin());
            stack.pop();
            stack.pop();
            assertEquals(1, stack.getMin());
        }
    }

    @Nested
    class EvaluateReversePolishNotationTest {

        @Test
        void evaluatesSimpleExpressions() {
            assertEquals(9, EvaluateReversePolishNotation.solve(new String[] {"2", "1", "+", "3", "*"}));
            assertEquals(6, EvaluateReversePolishNotation.solve(new String[] {"4", "13", "5", "/", "+"}));
        }

        @Test
        void respectsOperandOrderAndTruncation() {
            assertEquals(-1, EvaluateReversePolishNotation.solve(new String[] {"1", "2", "-"}));
            assertEquals(0, EvaluateReversePolishNotation.solve(new String[] {"1", "2", "/"}));
            assertEquals(0, EvaluateReversePolishNotation.solve(new String[] {"-1", "2", "/"}));
        }

        @Test
        void handlesASingleNumber() {
            assertEquals(42, EvaluateReversePolishNotation.solve(new String[] {"42"}));
        }
    }

    @Nested
    class DailyTemperaturesTest {

        @Test
        void countsDaysUntilWarmer() {
            assertArrayEquals(
                    new int[] {1, 1, 4, 2, 1, 1, 0, 0},
                    DailyTemperatures.solve(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
        }

        @Test
        void handlesMonotonicInput() {
            assertArrayEquals(new int[] {1, 1, 1, 0}, DailyTemperatures.solve(new int[] {30, 40, 50, 60}));
            assertArrayEquals(new int[] {0, 0, 0}, DailyTemperatures.solve(new int[] {60, 50, 40}));
        }

        @Test
        void treatsEqualTemperaturesAsNotWarmer() {
            assertArrayEquals(new int[] {0, 0}, DailyTemperatures.solve(new int[] {50, 50}));
        }
    }

    @Nested
    class LargestRectangleInHistogramTest {

        @Test
        void findsTheLargestRectangle() {
            assertEquals(10, LargestRectangleInHistogram.solve(new int[] {2, 1, 5, 6, 2, 3}));
            assertEquals(4, LargestRectangleInHistogram.solve(new int[] {2, 4}));
        }

        @Test
        void handlesFlatAndMonotonicInput() {
            assertEquals(9, LargestRectangleInHistogram.solve(new int[] {3, 3, 3}));
            assertEquals(6, LargestRectangleInHistogram.solve(new int[] {1, 2, 3}));
            assertEquals(0, LargestRectangleInHistogram.solve(new int[] {}));
        }
    }
}
