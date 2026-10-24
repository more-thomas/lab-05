import java.util.Arrays;
import java.util.Objects;

public class LLQueue {
    public record Pair(String val, Pair next) {}

    Pair front;
    Pair back;
    int tot;

    //Constructor
    public LLQueue(Pair front, Pair back, int tot) {
        this.front = front;
        this.back = back;
        this.tot = tot;
    }

    //Checks if queue is empty
    public boolean is_empty() {
        return tot == 0;
    }

    // Make an empty queue
    public static LLQueue empty_queue(){
        return new LLQueue(null, null, 0);
    }

    // Add string to the end of the queue
    public void enqueue(String val){
        back = new Pair(val, back);
        tot++;
    }

    //remove string from queue
    public String dequeue(){
        if(is_empty()){
            throw new IndexOutOfBoundsException("The queue is empty.");
        }

        if(front == null){
            while(back != null){
                front = new Pair(back.val(), front);
                back = back.next();
            }
        }

        String val = front.val();
        front = front.next();
        tot--;

        return val;
    }

    // Returns the first string without removing it.
    public String peek(){
        if(is_empty()) {
            throw new IndexOutOfBoundsException("The queue is empty.");
        }

        if(front == null){
            while(back != null) {
                front = new Pair(back.val(), front);
                back = back.next();
            }
        }

        return front.val();
    }

    // Returns the number of items.
    public int size(){
        return tot;
    }

    @Override
    public boolean equals(Object other) {
        switch (other) {
            case null: return false;

            case LLQueue q:
                if (tot != q.tot) {
                    return false;
                }

                Pair first = front;
                Pair firstBack = back;
                Pair second = q.front;
                Pair secondBack = q.back;

                for (int i = 0; i < tot; i++) {
                    if (first == null) {
                        while (firstBack != null) {
                            first = new Pair(firstBack.val(), first);
                            firstBack = firstBack.next();
                        }
                    }

                    if (second == null) {
                        while (secondBack != null) {
                            second = new Pair(secondBack.val(), second);
                            secondBack = secondBack.next();
                        }
                    }

                    if (!Objects.equals(first.val(), second.val())) {
                        return false;
                    }

                    first = first.next();
                    second = second.next();
                }

                return true;

            default:
                return false;
        }
    }
}
