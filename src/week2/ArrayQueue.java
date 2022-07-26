import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<Item> implements Queue<Item> {

    private static final int CONSTANT_SIZE = 4;

    private Item[] a;
    private int n;
    private int first;
    private int last;

    public ArrayQueue() {
        a = (Item[]) new Object[CONSTANT_SIZE];
        n = 0;
        first = 0;
        last = 0;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[(first + i) % a.length];
        }
        first = 0;
        last = n;
        a = copy;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Item peek() {
        if (n == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return a[first];
    }

    @Override
    public void enqueue(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[last] = item;
        last = (last + 1) % a.length;
        n++;
    }

    @Override
    public Item dequeue() {
        if (n == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = a[first];
        a[first] = null;
        first = (first + 1) % a.length;
        n--;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.enqueue(11);
        queue.enqueue(22);
        queue.enqueue(33);
        queue.enqueue(44);
        queue.enqueue(55);
        System.out.println(Arrays.toString(queue.a));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.a));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.a));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.a));
        System.out.println(queue.dequeue());
        // System.out.println(queue.peek());
        System.out.println(queue.size());
        // System.out.println(Arrays.toString(queue.a));
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < n;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Empty Iterator");
                }
                Item cur = a[(first + cursor) % a.length];
                cursor++;
                return cur;
            }

        };
    }
}
