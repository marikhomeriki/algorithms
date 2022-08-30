public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        validVertex(s);
        dfs(G, s);
    }

    private void dfs(Graph G, int s) {
        count++;
        validVertex(s);
        marked[s] = true;
        for (int w : G.adj(s)) {
            while (!marked(w)) {
                dfs(G, w);
            }

        }

    }

    public boolean marked(int v) {
        validVertex(v);
        return marked[v];
    }

    public int count() {
        return count;
    }

    private void validVertex(int v) {
        int V = marked.length;
        if (v < 0 || v > V) {
            throw new IllegalArgumentException("Vertex " + v + "is not valid");
        }

    }
}
