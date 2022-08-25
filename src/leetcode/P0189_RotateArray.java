public class P0189_RotateArray {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int j = (i + k) % nums.length;
            arr[j] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        P0189_RotateArray ra = new P0189_RotateArray();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        ra.rotate(nums, k);
    }
}
