import java.util.Arrays;

public class WeightedQuickUnion {
    private int id[];
    private int sz[];
    private int count;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        sz = new int[n];

        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;

    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;

    }

    public static void main(String[] args) {
        WeightedQuickUnion uf0 = new WeightedQuickUnion(5);
        uf0.union(0, 3);
        System.out.println(uf0.connected(0, 3));
        System.out.println(uf0.count());
        uf0.union(3, 4);
        System.out.println(uf0.connected(0, 4));
        System.out.println(uf0.count());
        System.out.println(uf0.root(3));
        System.out.println(uf0.root(4));
    }
}
