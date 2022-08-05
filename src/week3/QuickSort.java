import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        Comparable k = a[lo];

        while (true) {

            while (less(a[++i], k)) {

                if (i >= hi) {
                    break;
                }
            }
            while (less(k, a[--j])) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);

        }
        exch(a, lo, j);
        return j;
    }

    private static <Item> void exch(Comparable<Item>[] a, int i, int j) {

        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    private static boolean less(Comparable v, Comparable w) {
        // System.out.println("this is v " + v);
        // System.out.println("this is w " + w);

        if (v.compareTo(w) <= 0) {
            return true;
        }
        return false;

    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 8, 4, 3, 9, 10, 7, 6, 1, 11, 2, 5 };

        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
