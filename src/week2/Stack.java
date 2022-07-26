public interface Stack<Item> extends Iterable<Item> {
    public int size();

    public boolean isEmpty();

    public Item peek();

    public void push(Item item);

    public Item pop();

}
