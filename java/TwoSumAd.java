
import java.util.Arrays;

public class TwoSumAd {

    public static int twoSum(int[] a) {
        Arrays.sort(a);
        int count = 0;
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            if (a[lo] + a[hi] == 0) {
                count++;
                lo++;
                hi--;
            } else if (a[lo] + a[hi] > 0) {
                hi--;
            } else if (a[lo] + a[hi] < 0) {
                lo++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -1, 3, 1, 4 };
        int[] arr1 = new int[] { -1, 3, 1, 4, 1 };
        int[] arr2 = new int[] { -1, 3, 1, 4, 1, 2, -2, 3, -3, 11 };
        System.out.println(twoSum(arr));
        System.out.println(twoSum(arr1));
        System.out.println(twoSum(arr2));
    }
}
