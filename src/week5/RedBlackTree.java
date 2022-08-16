
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private enum Color {
        RED,
        BLACK
    }

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        Color color;

        public Node(Key key, Value value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = Color.BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, Color.RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }

    private void flipColors(Node x) {
        x.color = Color.RED;
        x.right.color = Color.BLACK;
        x.left.color = Color.BLACK;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == Color.RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Color.RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Color.RED;
        return x;
    }

    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        int count = 1000 * 1000;

        for (int i = 0; i < count; i++) {
            tree.put(i, i);
        }

        for (int i = 0; i < count; i += count / 10) {
            System.out.println(i + " => " + tree.get(i));
        }
    }
}
