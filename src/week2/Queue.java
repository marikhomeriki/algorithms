public interface Queue<Item> extends Iterable<Item> {

    public int size();

    public boolean isEmpty();

    public Item peek();

    public void enqueue(Item item);

    public Item dequeue();

}
