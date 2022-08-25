public class FibonacciNumbers {
    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);

    }

    public static void main(String[] args) {
        FibonacciNumbers fn = new FibonacciNumbers();
        int fib = fn.fib(2);
        System.out.println(fib);

    }

}
