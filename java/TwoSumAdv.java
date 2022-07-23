
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class TwoSumAdv {

    public static int twoSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int key = -a[i];
            int j = BinarySearch.indexOf(a, key);
            if (i < j) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -1, 3, 1, 4 };
        System.out.println(twoSum(arr));

    }
}
