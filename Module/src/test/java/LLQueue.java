import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LLQueueTest {

    @Test
    public void testEnqueue() {
        LLQueue queue = LLQueue.empty_queue();
        queue.enqueue("apple");
        queue.enqueue("banana");

        assertEquals(2, queue.size());
        assertEquals("apple", queue.peek());
    }

    @Test
    public void testDequeue() {
        LLQueue queue = LLQueue.empty_queue();
        queue.enqueue("apple");
        queue.enqueue("banana");

        assertEquals("apple", queue.dequeue());

        queue.enqueue("cherry");

        assertEquals("banana", queue.dequeue());
        assertEquals("cherry", queue.dequeue());
    }

    @Test
    public void testPeek() {
        LLQueue queue = LLQueue.empty_queue();
        queue.enqueue("apple");
        queue.enqueue("banana");

        assertEquals("apple", queue.peek());
        assertEquals("apple", queue.peek());
        assertEquals(2, queue.size());

        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testSize() {
        LLQueue queue = LLQueue.empty_queue();

        assertEquals(0, queue.size());

        queue.enqueue("apple");
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testEmpty() {
        LLQueue queue = LLQueue.empty_queue();

        assertEquals(true, queue.is_empty());

        queue.enqueue("apple");
        assertEquals(false, queue.is_empty());

        queue.dequeue();
        assertEquals(true, queue.is_empty());
    }
}
