
public class UF {

    private static int id[];
    private static int count;

    public UF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public static int count() {
        return count;
    }

    public static int find(int i) {
        int iID;
        iID = id[i];
        return iID;
    }

    public static boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        if (pID == qID)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] != pID)
                id[i] = qID;
            count--;
        }

    }

}
