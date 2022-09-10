import edu.princeton.cs.algs4.Queue;

public class DepthFirstOrder {

    private boolean[] marked;
    private int[] pre;
    private int[] post;
    private Queue<Integer> preorder;
    private Queue<Integer> postorder;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        preorder = new Queue<Integer>();
        postorder = new Queue<Integer>();
        pre = new int[G.V()];
        post = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }

    }

    private void dfs(Digraph g, int v) {
    }

}
