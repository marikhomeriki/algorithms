public class P0167_TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        int[] results = new int[] { -1, -1 };

        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];

            if (sum > target) {
                hi--;
            } else if (sum < target) {
                lo++;
            } else {
                break;
            }
        }

        results[0] = lo + 1;
        results[1] = hi + 1;

        return results;

    }
}
