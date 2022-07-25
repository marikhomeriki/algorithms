import java.util.NoSuchElementException;

public class LinkedListStack<Item> {

    public Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        stack.push(5);
        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
