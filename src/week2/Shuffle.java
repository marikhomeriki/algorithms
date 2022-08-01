import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {

    public static <Item> void shuffle(Item[] a) {

        int n = a.length;
        int r;

        for (int i = 0; i < n; i++) {
            r = StdRandom.uniform(i + 1);
            exch(a, i, r);
        }
    }

    public static <Item> void exch(Item[] a, int i, int j) {
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        shuffle(a);
        System.out.println(Arrays.toString(a));
        int rr = StdRandom.uniform(1);
        System.out.println(rr);
    }
}
