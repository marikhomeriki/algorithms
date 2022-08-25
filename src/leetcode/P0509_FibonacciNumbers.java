import java.util.HashMap;
import java.util.Map;

public class P0509_FibonacciNumbers {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int value = fib(n - 1) + fib(n - 2);
        memo.put(n, value);

        return value;
    }

    public static void main(String[] args) {
        P0509_FibonacciNumbers fn = new P0509_FibonacciNumbers();
        int fib = fn.fib(4);
        System.out.println(fib);

    }

}
