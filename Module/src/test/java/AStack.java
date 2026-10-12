import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AStackTest{
    @Test
    public void testArrayPush() {
        AStack stack = AStack.empty_stack();
        stack.push("apple");
        assertEquals("apple", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void testArrayPop() {
        AStack stack = AStack.empty_stack();
        stack.push("apple");
        stack.push("banana");
        assertEquals("banana", stack.pop());
        assertEquals("apple", stack.pop());
    }

    @Test
    public void testArrayPeek() {
        AStack stack = AStack.empty_stack();
        stack.push("apple");
        assertEquals("apple", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void testArraySize() {
        AStack stack = AStack.empty_stack();
        assertEquals(0, stack.size());
        stack.push("apple");
        stack.push("banana");
        assertEquals(2, stack.size());
    }

    @Test
    public void testArrayIsEmpty() {
        AStack stack = AStack.empty_stack();
        assertEquals(true, stack.is_empty());
        stack.push("apple");
        assertEquals(false, stack.is_empty());
    }

    public int measureAStack(int t) {
        int n = 1;
        int previous = 0;

        while (true) {
            AStack s = AStack.empty_stack();

            long startTime = System.nanoTime();

            for (int i = 0; i < n; i++) {
                s.push("apple");
            }

            for (int i = 0; i < n; i++) {
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
    public void testArrayMeasurement() {
        assertEquals(true, measureAStack(100) >= 0);
        assertEquals(true, measureAStack(200) >= 0);
        assertEquals(false, measureAStack(100) < 0);
    }
}
