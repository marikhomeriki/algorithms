import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {
    public static <Item> void sort(Comparable<Item>[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static <Item> void exch(Comparable<Item>[] a, int i, int j) {
        Comparable<Item> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static <Item> boolean less(Comparable<Item> v, Comparable<Item> w) {
        return v.compareTo((Item) w) < 0;
    }

    public static <Item> boolean isSorted(Comparable<Item>[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static <Item> void show(Comparable<Item>[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 4, 3, 2, 1 };
        Selection.show(a);
        Selection.sort(a);
        // boolean x = Selection.isSorted(a);
        // System.out.println(x);
        System.out.println(Arrays.toString(a));
        // Selection.show(a);
    }

}
