
public class TwoSumBrute {

    public static int twosum(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -1, 1, 3, 4, 2, -2, -3, 3 };
        System.out.println(twosum(arr));

    }
}
