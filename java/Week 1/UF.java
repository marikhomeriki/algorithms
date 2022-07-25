import java.util.Arrays;

public class UF {
    private int id[];
    private int count;

    public UF(int n) {
        count = n;
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

        count--;
    }

    public static void main(String[] args) {
        UF uf0 = new UF(5);
        uf0.union(0, 3);
        System.out.println(uf0.connected(0, 3));
        System.out.println(uf0.count());
        uf0.union(3, 4);
        System.out.println(uf0.connected(0, 4));
        System.out.println(uf0.count());
        System.out.println(Arrays.toString(uf0.id));
        UF uf1 = new UF(3);

        System.out.println(Arrays.toString(uf0.id));
        System.out.println(Arrays.toString(uf1.id));
    }
}
