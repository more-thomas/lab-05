import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AQueueTest {

    @Test
    public void testEnqueue(){
        AQueue a = AQueue.empty_queue(2);
        a.enqueue("hey");
        a.enqueue("bye");

        assertEquals(2, a.size());
        assertEquals("hey", a.peek());}

    @Test
    public void testDequeue(){
        AQueue b = AQueue.empty_queue(2);
        b.enqueue("hey");
        b.enqueue("bye");
        assertEquals("hey", b.dequeue());

        b.enqueue("later");
        assertEquals("bye", b.dequeue());
        assertEquals("later", b.dequeue());
    }

    @Test
    public void testPeek(){
        AQueue c = AQueue.empty_queue(2);
        c.enqueue("hey");

        assertEquals("hey", c.peek());
        assertEquals(1, c.size());
        c.dequeue();
    }

    @Test
    public void testSize(){
        AQueue d = AQueue.empty_queue(2);
        assertEquals(0, d.size());
        d.enqueue("hey");
        assertEquals(1, d.size());
        d.dequeue();
        assertEquals(0, d.size());
    }

    @Test
    public void testEmpty(){
        AQueue e = AQueue.empty_queue(2);
        assertEquals(true, e.is_empty());
        e.enqueue("hey");
        assertEquals(false, e.is_empty());
        e.dequeue();
        assertEquals(true, e.is_empty());
    }

    @Test
    public void testEquals() {
        AQueue first = AQueue.empty_queue(3);
        AQueue second = AQueue.empty_queue(3);

        first.enqueue("hey");
        second.enqueue("hey");

        assertEquals(true, first.equals(second));

        second.enqueue("bye");

        assertEquals(false, first.equals(second));
    }
}
