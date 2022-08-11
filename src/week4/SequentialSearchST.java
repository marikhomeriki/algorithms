import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST<Key, Value> {

    private Node first;
    private int n;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public Value get(Key key) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public int size() {
        return n;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();

        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    public void remove(Key key) {
        Node prev = null;
        for (Node cur = first; cur != null; cur = cur.next) {

            if (key.equals(cur.key)) {
                if (prev == null) {
                    first = first.next;
                } else {
                    prev.next = cur.next;
                }
                n--;
                return;
            }
            prev = cur;

        }

    }

    public static void main(String[] args) {
        SequentialSearchST<Integer, Integer> xs = new SequentialSearchST<Integer, Integer>();

        xs.put(1, 1);
        xs.put(2, 2);
        xs.put(3, 3);

        xs.remove(3);
        System.out.println(xs.keys());
        xs.remove(2);
        System.out.println(xs.keys());
        xs.remove(1);
        System.out.println(xs.keys());

    }

}
