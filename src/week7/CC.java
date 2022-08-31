public class CC {

    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            while (!marked[w]) {
                dfs(G, w);
            }
        }

    }

}
