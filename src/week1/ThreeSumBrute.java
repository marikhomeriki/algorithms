
public class ThreeSumBrute {

    public static int threesum(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -1, -2, 0, 4, 5 };
        System.out.println(threesum(arr));

    }
}
