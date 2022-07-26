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

        printIterable(si);
        printIterable(ss);

        printIterable(qs);
        printIterable(qi);
    }

    public static <Item> void printIterable(Iterable<Item> iterable) {
        for (Item item : iterable) {
            System.out.println(item);
        }
    }
}
