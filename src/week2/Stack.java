public interface Stack<Item> {
    public int size();

    public boolean isEmpty();

    public Item peek();

    public void push(Item item);

    public Item pop();

}
