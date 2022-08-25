import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {

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
        FibonacciNumbers fn = new FibonacciNumbers();
        int fib = fn.fib(4);
        System.out.println(fib);

    }

}
