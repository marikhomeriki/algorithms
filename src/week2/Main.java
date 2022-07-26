public class Main {

    public static void main(String[] args) {
        Queue<Integer> qi = new ArrayQueue<>();
        Queue<String> qs = new LinkedListQueue<>();
        Stack<Integer> si = new ArrayStack<>();
        Stack<String> ss = new LinkedListStack<>();

        si.push(1);
        si.push(2);
        si.push(3);
        ss.push("M");
        ss.push("S");
        ss.push("JB");

        qi.enqueue(1);
        qi.enqueue(2);
        qi.enqueue(3);
        qs.enqueue("Mari");
        qs.enqueue("Sandro");
        qs.enqueue("cuguchebi");

        printQueue(qi);
        printQueue(qs);

        printStack(si);
        printStack(ss);
    }

    public static <Item> void printQueue(Queue<Item> queue) {
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            System.out.println(queue.dequeue());
        }
    }

    public static <Item> void printStack(Stack<Item> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
