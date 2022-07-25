import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<Item> {

    private static final int INIT_CAPACITY = 8;

    private Item[] arr; // Array to resize
    private int n; // logical size of an array

    public ArrayStack() {
        arr = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int newLength) {
        Item[] newArray = (Item[]) new Object[newLength];
        for (int i = 0; i < n; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    public void push(Item item) {
        if (n == arr.length) {
            resize(n * 2);
        }
        arr[n] = item;
        n++;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return arr[n - 1];
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item numToPop = arr[n - 1];
        arr[n - 1] = null;
        n--;

        if (n > 0 && n == arr.length / 4) {
            resize(n / 2);
        }

        return numToPop;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println(stack.size());
        System.out.println(stack.arr.length);
        System.out.println(stack.pop());
        System.out.println(stack.arr.length);
        System.out.println(stack.size());
        System.out.println(Arrays.toString(stack.arr));
    }
}
