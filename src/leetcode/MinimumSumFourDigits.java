import java.util.Arrays;

public class MinimumSumFourDigits {

    public int minSum(int num) {
        int[] numbers = new int[4];

        for (int i = 0; i < 4; i++) {
            numbers[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(numbers);

        int first = numbers[0] * 10 + numbers[3];
        int second = numbers[1] * 10 + numbers[2];

        return first + second;
    }

    public static void main(String[] args) {
        MinimumSumFourDigits msfd = new MinimumSumFourDigits();
        int num = 2932;
        msfd.minSum(num);

    }

}
