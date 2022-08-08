import java.util.Arrays;

public class HeapSort<Item> {

    public static void sort(Comparable[] a) {

        int n = a.length;

        // Constructs Heap
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        // sortdown

        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    public static boolean less(Comparable[] a, int i, int j) {
        if (a[i - 1].compareTo(a[j - 1]) < 0) {
            return true;
        }
        return false;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    public static void sink(Comparable[] a, int k, int n) {

        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {

        Integer[] a = new Integer[] { 9, 8, 4, 5, 1, 3, 6, 7, 1, 11 };
        sort(a);
        System.out.println(Arrays.toString(a));

    }

}
