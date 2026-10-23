import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LLQueueTest{

    @Test
    public void testEnqueue(){
        LLQueue a = LLQueue.empty_queue();
        a.enqueue("hello");
        a.enqueue("bye");

        assertEquals(2, a.size());
        assertEquals("hello", a.peek());
    }

    @Test
    public void testDequeue(){
        LLQueue b = LLQueue.empty_queue();
        b.enqueue("hello");
        b.enqueue("bye");

        assertEquals("hello", b.dequeue());

        b.enqueue("later");

        assertEquals("bye", b.dequeue());
        assertEquals("later", b.dequeue());
    }

    @Test
    public void testPeek(){
        LLQueue c = LLQueue.empty_queue();
        c.enqueue("hello");
        c.enqueue("bye");

        assertEquals("hello", c.peek());
        assertEquals("hello", c.peek());
        assertEquals(2, c.size());

        c.dequeue();
        c.dequeue();
    }

    @Test
    public void testSize(){
        LLQueue d = LLQueue.empty_queue();

        assertEquals(0, d.size());

        d.enqueue("hello");
        assertEquals(1, d.size());

        d.dequeue();
        assertEquals(0, d.size());
    }

    @Test
    public void testEmpty(){
        LLQueue e = LLQueue.empty_queue();

        assertEquals(true, e.is_empty());

        e.enqueue("hello");
        assertEquals(false, e.is_empty());

        e.dequeue();
        assertEquals(true, e.is_empty());
    }
}
