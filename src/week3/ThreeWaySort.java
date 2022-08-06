import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class ThreeWaySort {

    private static <Item> void exch(Comparable<Item>[] a, int i, int j) {

        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {

        if (v.compareTo(w) <= 0) {
            return true;
        }
        return false;

    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int i = lo;
        int lt = lo;
        int gt = hi;

        Comparable k = a[lo];

        while (i <= gt) {

            int cmp = a[i].compareTo(k);

            if (cmp < 0) {
                exch(a, lt, i);
                i++;
                lt++;
            } else if (cmp > 0) {
                exch(a, i, gt);
                gt--;

            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 8, 4, 8, 8, 10, 8, 6, 8, 11, 8, 5 };
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
