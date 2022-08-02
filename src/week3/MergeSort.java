import java.util.Arrays;

public class MergeSort<Item> {

    private static <Item> void merge(Comparable<Item>[] a, Comparable<Item>[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static <Item> void sort(Comparable<Item>[] a, Comparable<Item>[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static <Item> void sort(Comparable<Item>[] a) {
        Comparable<Item>[] aux = (Comparable<Item>[]) new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static <Item> boolean less(Comparable<Item> v, Comparable<Item> w) {
        if (v.compareTo((Item) w) < 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 4, 3, 6, 9, 1 };
        System.out.println(Arrays.toString(a));
        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}