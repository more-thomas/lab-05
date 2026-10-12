public class LLStack {
    public record Stack(String one, Stack rest) {
    }
        Stack top;

        // Purpose: Create a stack with the given top node.
        public LLStack(Stack top) {
            this.top = top;
        }

        // Purpose: Return an empty stack.
        public static LLStack empty_stack() {
            return new LLStack(null);
        }

        // Purpose: Add a String to the top of the stack.
        public void push(String val) {
            top = new Stack(val, top);
        }

        public String pop(){
            switch(top){
                case null: throw new IndexOutOfBoundsException("This is an empty Stack");

                case Stack(String one, Stack rest):
                    top = rest;
                    return one;
            }
        }
        public String peek() {
            switch (top) {
                case null:
                    throw new IndexOutOfBoundsException("The stack is empty");
                case Stack(String one, Stack rest):
                    return one;
            }
        }
        public int size(){
            int tot = 0;
            Stack current = top;

            while(current != null){
                tot += 1;
                current = current.rest();
            }
            return tot;
        }
        public boolean is_empty(){
            if(top == null){
                return true;
            }
            else{
                return false;
            }
        }

}
