public class MaxPQ<Item extends Comparable<Item>> {

    private Item[] pq;
    private int n;

    public MaxPQ(int capacity) {
        pq = (Item[]) new Comparable[capacity + 1];
        n = capacity;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean less(int i, int j) {
        if (pq[i].compareTo(pq[j]) < 0) {
            return true;
        }
        return false;
    }

    public void exch(int i, int j) {
        Item t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public void swim(int k) {

        while (k < 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }

    }

    public void sink(int k) {

        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public void insert(Item v) {
        pq[n++] = v;
        swim(n);
    }

    public Item delMax() {

        Item max = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        return max;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq2 = new MaxPQ<>(3);
        System.out.println(pq2.size());
        System.out.println(pq2.isEmpty());
        pq2.insert(7);
        System.out.println(pq2.size());
    }

}
