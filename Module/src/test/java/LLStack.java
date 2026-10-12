import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest{
    @Test
    public void testLLPush() {
        LLStack stack = LLStack.empty_stack();
        stack.push("apple");
        assertEquals("apple", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void testLLPop() {
        LLStack stack = LLStack.empty_stack();
        stack.push("apple");
        stack.push("banana");
        assertEquals("banana", stack.pop());
        assertEquals("apple", stack.pop());
    }

    @Test
    public void testLLPeek() {
        LLStack s = LLStack.empty_stack();
        s.push("apple");
        assertEquals("apple", s.peek());
        assertEquals(1, s.size());
    }

    @Test
    public void testLLSize() {
        LLStack s = LLStack.empty_stack();
        assertEquals(0, s.size());
        s.push("apple");
        s.push("banana");
        assertEquals(2, s.size());
    }

    @Test
    public void testLLIsEmpty() {
        LLStack stack = LLStack.empty_stack();

        assertEquals(true, stack.is_empty());
        stack.push("apple");
        assertEquals(false, stack.is_empty());
    }

    // Purpose: Find the largest tested number of elements
    public int measureLLStack(int t) {
        int n = 1;
        int previous = 0;

        while (true) {
            LLStack s = LLStack.empty_stack();

            long startTime = System.nanoTime();

            for (int i = 0; i < n; i+= 1) {
                s.push("apple");
            }

            for (int i = 0; i < n; i+= 1) {
                s.pop();
            }

            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1000000.0;

            if (duration >= t) {
                return previous;
            }

            previous = n;
            n = n * 2;
        }
    }

    @Test
    public void testLLMeasurement() {
        assertEquals(true, measureLLStack(100) >= 0);
        assertEquals(true, measureLLStack(200) >= 0);
        assertEquals(false, measureLLStack(100) < 0);
    }


}
