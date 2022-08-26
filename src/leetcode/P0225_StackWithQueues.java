import java.util.LinkedList;
import java.util.Queue;

public class P0225_StackWithQueues {
    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        private int top;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
            top = x;
        }

        public int pop() {
            while (q1.size() > 1) {
                top = q1.remove();
                q2.add(top);
            }

            int res = q1.remove();
            swap();
            return res;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return q1.isEmpty();
        }

        private void swap() {
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        P0225_StackWithQueues swq = new P0225_StackWithQueues();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }

}
