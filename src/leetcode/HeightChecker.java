import java.util.Arrays;

public class HeightChecker {

    private int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }
        Arrays.sort(expected);

        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] heights = new int[] { 1, 1, 4, 2, 1, 3 };
        HeightChecker hc = new HeightChecker();
        hc.heightChecker(heights);

    }

}
