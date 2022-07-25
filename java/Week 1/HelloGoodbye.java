
public class HelloGoodbye {
    public static void main(String[] args) {
        String x = args[0];
        String y = args[1];
        // System.out.println("Hello " + x + " and " + y);
        System.out.printf("Hello %s and %s\n", x, y);
        System.out.printf("Goodbye %s and %s\n", y, x);
        // System.out.println("Goodbye " + y + " and " + x);
    }
}