import java.util.Arrays;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        x.n = 1 + size(x.left) + size(x.right);
        return x;
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();
        String s5 = "S";
        st.put(s5, 8);

        String s3 = "X";
        st.put(s3, 12);

        String s2 = "E";
        st.put(s2, 5);

        System.out.println(st.size());

        String s1 = "A";
        st.put(s1, 11);

        System.out.println();

        String s8 = "R";
        st.put(s8, 3);

        System.out.println();

        String s14 = "H";
        st.put(s14, 3);

        System.out.println();

        String s6 = "M";
        st.put(s6, 9);

    }

}
