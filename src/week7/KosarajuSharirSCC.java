import edu.princeton.cs.algs4.DepthFirstOrder;
import edu.princeton.cs.algs4.Digraph;

public class KosarajuSharirSCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSharirSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];

        DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());

        for (int w : dfs.reversePost()) {
            if (!marked[w]) {
                dfs(G, w);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return marked[v] == marked[w];
    }

    public int count() {
        return count;
    }

}
