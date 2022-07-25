
import java.util.Arrays;

public class BinarySearchBuggy {

    public static int indexOf(int[] a, int key) {
        int n = a.length;
        Arrays.sort(a);
        int lo = 0;
        int hi = n - 1;
        int mid = (hi - lo) / 2;

        while (key != a[mid]) {
            if (key > a[mid]) {
                lo = mid + 1;
                mid = lo + ((hi - lo) / 2);
                if (mid >= n) {
                    return -1;
                }
            }
            if (key < a[mid]) {
                hi = mid - 1;
                mid = (hi + lo) / 2;
                if (mid < 0) {
                    return -1;
                }
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 35, 40, 50, 55, 60, 65, 75, 80, 100 };
        System.out.println(indexOf(arr, 15));

    }
}
