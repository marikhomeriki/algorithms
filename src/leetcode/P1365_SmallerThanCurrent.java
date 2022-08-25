import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1365_SmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] results = new int[nums.length];
        int[] arr = nums.clone();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            results[i] = map.get(nums[i]);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 1, 2, 2, 3 };
        P1365_SmallerThanCurrent stc = new P1365_SmallerThanCurrent();
        int[] res = stc.smallerNumbersThanCurrent(arr);
        System.out.println(Arrays.toString(res));
    }

}
