import java.util.Arrays;
import java.util.Objects;

public class AQueue{
    String[] dat;
    int front;
    int tot;

    // Constructor
    public AQueue(String[] dat, int front, int tot){
        this.dat = dat;
        this.front = front;
        this.tot = tot;
    }

    // Checks whether the queue is empty.
    public boolean is_empty(){
        return tot == 0;
    }

    //checks that the capacity is not 0
    public static AQueue empty_queue(int cap){
        if(cap <= 0){
            throw new IllegalArgumentException("capacity must be positive and can't be 0.");
        }
        return new AQueue(new String[cap], 0, 0);
    }

    //adds a string to the end
    public void enqueue(String val) {
        if(tot == dat.length){
            throw new IllegalStateException("queue is full");
        }

        int end = front + tot;

        if (end >= dat.length) {
            end = end - dat.length;
        }

        dat[end] = val;
        tot++;
    }

    //Removes and returns the first string
    public String dequeue() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("queue is empty");
        }

        String val = dat[front];
        dat[front] = null;

        front++;

        if (front == dat.length) {
            front = 0;
        }

        tot--;

        return val;
    }

    //returns the first string without removing it
    public String peek() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("queue is empty");
        }

        return dat[front];
    }
    //returns the number of items in the queue
    public int size() {
        return tot;
    }
}
