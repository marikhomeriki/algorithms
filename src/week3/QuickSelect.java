import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSelect {

    private static Comparable selection(Comparable[] a, int k) {

        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            int j = QuickSort.partition(a, lo, hi);

            if (k < j) {
                hi = j - 1;
            } else if (k > j) {
                lo = j + 1;
            } else {
                return a[k];
            }
        }

        return a[k];

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 8, 4, 3, 9, 10, 7, 6, 1, 11, 2, 5 };

        System.out.println(selection(a, 10));

    }

}
