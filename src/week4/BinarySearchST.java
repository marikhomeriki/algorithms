import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int n;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int rank(Key key) {

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Value get(Key key) {

        if (isEmpty()) {
            return null;
        }

        int i = rank(key);

        if (i < n && key.compareTo(keys[i]) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value val) {
        int i = rank(key);

        if (i < n && key.compareTo(keys[i]) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[n - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        if (i == n) {
            throw new NoSuchElementException("argument to ceiling is too large");
        }
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        return keys[i - 1];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("The argument is null");
        }
        return get(key) != null;
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(5);
        // String s = "A";
        String s5 = "E";
        st.put(s5, 4);
        String s4 = "D";
        st.put(s4, 3);
        String s3 = "C";
        st.put(s3, 2);
        String s2 = "B";
        st.put(s2, 1);
        String s1 = "A";
        st.put(s1, 0);

        System.out.println(Arrays.toString(st.keys));
        // System.out.println(Arrays.toString(st.vals));

        // System.out.println(st.rank(s5)); // e
        // System.out.println(st.rank(s4)); // d
        // System.out.println(st.rank(s3)); // c
        // System.out.println(st.rank(s2)); // b
        // System.out.println(st.rank(s1)); // a

        String s6 = "a";
        System.out.println(st.ceiling(s3));
        System.out.println(st.ceiling(s6));

    }

}
