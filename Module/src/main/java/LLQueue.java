public class LLQueue {
    public record Node(String val, Node next) {}

    Node front;
    Node back;
    int tot;

    // Constructor
    public LLQueue(Node front, Node back, int tot) {
        this.front = front;
        this.back = back;
        this.tot = tot;
    }

    // Checks whether the queue is empty.
    public boolean is_empty() {
        return tot == 0;
    }

    // Make an empty queue
    public static LLQueue empty_queue() {
        return new LLQueue(null, null, 0);
    }

    // Adds a string to the end of the queue
    public void enqueue(String val) {
        back = new Node(val, back);
        tot++;
    }

    public String dequeue() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("queue is empty");
        }

        if (front == null) {
            while (back != null) {
                front = new Node(back.val(), front);
                back = back.next();
            }
        }

        String val = front.val();
        front = front.next();
        tot--;

        return val;
    }

    // Returns the first string without removing it.
    public String peek() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("queue is empty");
        }

        if (front == null) {
            while (back != null) {
                front = new Node(back.val(), front);
                back = back.next();
            }
        }

        return front.val();
    }

    // Returns the number of items.
    public int size() {
        return tot;
    }
}
