import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AQueueTest {

    @Test
    public void testEnqueue() {
        AQueue queue = AQueue.empty_queue(2);
        queue.enqueue("apple");
        queue.enqueue("banana");

        assertEquals(2, queue.size());
        assertEquals("apple", queue.peek());}

    @Test
    public void testDequeue() {
        AQueue queue = AQueue.empty_queue(2);
        queue.enqueue("apple");
        queue.enqueue("banana");

        assertEquals("apple", queue.dequeue());

        queue.enqueue("cherry");

        assertEquals("banana", queue.dequeue());
        assertEquals("cherry", queue.dequeue());
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void testPeek() {
        AQueue queue = AQueue.empty_queue(2);
        queue.enqueue("apple");
        assertEquals("apple", queue.peek());
        assertEquals("apple", queue.peek());
        assertEquals(1, queue.size());

        queue.dequeue();
    }

    @Test
    public void testSize() {
        AQueue queue = AQueue.empty_queue(2);

        assertEquals(0, queue.size());

        queue.enqueue("apple");
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testEmpty() {
        AQueue queue = AQueue.empty_queue(2);
        assertEquals(true, queue.is_empty());
        queue.enqueue("apple");
        assertEquals(false, queue.is_empty());
        queue.dequeue();
        assertEquals(true, queue.is_empty());
    }
}
