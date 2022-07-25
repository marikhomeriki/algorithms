
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

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;

    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
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
        System.out.println(uf0.find(3));
        System.out.println(uf0.find(4));
    }
}
