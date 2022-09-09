public class DirectedDFS {

    private boolean[] marked;
    private int count;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(Digraph G, int s) {
        count++;
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }

    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }

}
