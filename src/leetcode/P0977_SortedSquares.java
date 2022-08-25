public class P0977_SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int lo = 0;
        int hi = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                result[i] = nums[hi] * nums[hi];
                hi--;
            } else {
                result[i] = nums[lo] * nums[lo];
                lo++;
            }
        }

        return result;
    }
}
