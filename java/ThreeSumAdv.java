
import java.util.Arrays;
import edu.princeton.cs.algs4.BinarySearch;

public class ThreeSumAdv {

    public static int threesum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = -(a[i] + a[j]);
                int k = BinarySearch.indexOf(a, key);
                if (i < k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -1, 3, 1, 4, 0 };
        System.out.println(threesum(arr));

    }
}
