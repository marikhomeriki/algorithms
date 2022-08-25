import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P0217_ContainsDuplicates {
    private boolean containcDuplicates(int[] nums) {

        Set mp = new HashSet<>();

        for (int i : nums) {
            if (mp.contains(i)) {
                return true;
            }
            mp.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        P0217_ContainsDuplicates cd = new P0217_ContainsDuplicates();
        Boolean b = cd.containcDuplicates(arr);
        System.out.println(b);
    }

}
