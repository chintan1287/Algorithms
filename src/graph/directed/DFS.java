package graph.directed;

import java.util.Stack;

public class DFS {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DFS(DiGraph G, int s) {
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        dfs(G, s);
    }

    public void dfs(DiGraph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> path(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int w = v; w!=this.s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
}
