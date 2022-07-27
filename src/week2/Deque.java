import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }
        if (n == 0) {
            first = new Node();
            last = first;
            first.item = item;
            first.prev = null;
            first.next = null;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            oldFirst.prev = first;
            first.prev = null;
            first.next = oldFirst;
        }
        n++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }
        if (n == 0) {
            last = new Node();
            first = last;
            last.item = item;
            last.prev = null;
            last.next = null;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            oldLast.next = last;
            last.prev = oldLast;
            last.next = null;
        }
        n++;
    }

    public Item removeFirst() {
        if (n == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = first.item;
        if (n == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        n--;
        return item;
    }

    public Item removeLast() {
        if (n == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = last.item;
        if (n == 1) {
            last = null;
            first = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        n--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node curFirst = first;

            @Override
            public boolean hasNext() {
                return curFirst != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Empty Iterator");
                }
                Item item = curFirst.item;
                curFirst = curFirst.next;
                return item;
            }

        };

    }

    public Iterator<Item> reverseIterator() {
        return new Iterator<Item>() {
            private Node curLast = last;

            @Override
            public boolean hasNext() {
                return curLast != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Empty Iterator");
                }
                Item item = curLast.item;
                curLast = curLast.prev;
                return item;
            }

        };

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> d = new Deque<>();
        System.out.println(d.size());
        System.out.println(d.isEmpty());
        d.addFirst(4);
        d.addLast(3);
        d.addFirst(1);
        d.addLast(2);
        System.out.println(d.size());
        System.out.println(d.removeFirst());
        d.removeFirst();
        d.removeLast();
        System.out.println(d.removeLast());
        System.out.println(d.size());

        for (int item : d) {
            System.out.println(item);
        }
    }

}
