public class LinearProbingHT<Key, Value> {

    private int n;
    private int m = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHT(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    public void put(Key key, Value value) {

        if (n >= m) {
            resize(m * 2);
        }

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
            keys[i] = key;
            values[i] = value;
        }
        n++;
    }

    private void resize(int cap) {
        LinearProbingHT<Key, Value> t = new LinearProbingHT<Key, Value>(cap);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        m = t.m;
    }

}
