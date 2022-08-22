import java.util.Arrays;

public class MergeSortedArrays {

    public void MergeLeet(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }
        int p1 = 0;
        int p2 = 0;

        for (int p = 0; p < m + n; p++) {
            if (p2 >= n || (p1 < m && arr[p1] <= nums2[p2])) {
                nums1[p] = arr[p1];
                p1++;
            } else {
                nums1[p] = nums2[p2];
                p2++;
            }

        }
    }

    public static void main(String[] args) {
        int m = 1;
        int n = 0;

        int[] nums1 = new int[] { 1 };
        int[] nums2 = new int[] {};

        MergeSortedArrays ml = new MergeSortedArrays();
        ml.MergeLeet(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
