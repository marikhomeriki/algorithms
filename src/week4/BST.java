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
        System.out.println("Node to return " + x.key);
        System.out.println("Size to return " + x.n);
        return x;
    }

    private Key select(Node x, int k) {
        if (x == null) {
            return null;
        }

        int t = size(x.left);
        System.out.println("Left size " + t);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            System.out.println("To return " + x.key);

            return x.key;
        }

    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }

        return select(root, k);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    public Key min() {
        Node minNode = min(root);
        Key min = minNode.key;
        return min;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        return x.key;

    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }

        return ceiling(x.right, key);
    }

    public Key floor(Key key) {

        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            return floor(x.left, key);
        } else {
            Node t = floor(x.right, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }

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

        String s8 = "R";
        st.put(s8, 3);

        String s14 = "H";
        st.put(s14, 3);

        String s6 = "M";
        st.put(s6, 9);

        System.out.println();

        String s9 = "E";
        st.put(s9, 19);

        System.out.println();

        System.out.println("This is min " + st.min());
        st.min();
        st.floor(s3);
        System.out.println("This is floor of X " + st.floor(s3));
        System.out.println("This is floor of X " + st.floor(s9));

        System.out.println();

        // System.out.println(st.select(3));

        System.out.println(st.rank("S"));
        System.out.println(st.rank("E"));
        System.out.println(st.rank("X"));
        System.out.println(st.rank("A"));
        System.out.println(st.rank("R"));
        System.out.println(st.rank("H"));
        System.out.println(st.rank("M"));

    }

}
