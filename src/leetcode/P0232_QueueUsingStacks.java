import java.util.NoSuchElementException;
import java.util.Stack;

public class P0232_QueueUsingStacks {
    class MyQueue {
        private Stack<Integer> back;
        private Stack<Integer> front;

        public MyQueue() {
            back = new Stack<>();
            front = new Stack<>();
        }

        public void push(int x) {
            back.push(x);
        }

        public int pop() {

            if (this.empty()) {
                throw new NoSuchElementException("The queue is empty");
            }

            if (front.isEmpty()) {
                while (!back.isEmpty()) {
                    int val = back.pop();
                    front.push(val);
                }
            }

            return front.pop();

        }

        public int peek() {
            if (this.empty()) {
                throw new NoSuchElementException("The queue is empty");
            }

            if (front.isEmpty()) {
                while (!back.isEmpty()) {
                    int val = back.pop();
                    front.push(val);
                }
            }

            return front.peek();

        }

        public boolean empty() {
            return back.isEmpty() && front.isEmpty();
        }
    }

}
