import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int CONSTANT_SIZE = 8;

    private Item[] a;
    private int n;
    private int last = 0;

    // construct an empty randomized queue

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        a = (Item[]) new Object[CONSTANT_SIZE];
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i];
        }
        a = copy;

    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[last] = item;
        last++;
        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (n == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        int ran = StdRandom.uniform(n);
        Item item = a[ran];

        if (ran != last - 1) {
            a[ran] = a[last - 1];
        }
        a[last - 1] = null;
        last--;
        n--;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (n == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int ran = StdRandom.uniform(n);
        return a[ran];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    @SuppressWarnings("unchecked")
    private class RandomizedQueueIterator implements Iterator<Item> {

        private int cursor = 0;
        private Item[] arr = (Item[]) new Object[n];

        private RandomizedQueueIterator() {

            for (int i = 0; i < n; i++) {
                arr[i] = a[i];
            }
            StdRandom.shuffle(arr);
        }

        @Override
        public boolean hasNext() {
            return cursor < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator is empty");
            }
            Item item = arr[cursor];
            cursor++;
            return item;
        }

    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        System.out.println(rq.size());
        System.out.println(rq.isEmpty());
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        System.out.println("size " + rq.size());
        System.out.println("sample " + rq.sample());
        System.out.println(rq.isEmpty());
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        System.out.println("size second " + rq.size());
        for (int item : rq) {
            System.out.println(item);
        }

    }

}