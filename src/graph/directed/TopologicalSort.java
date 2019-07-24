package graph.directed;

import java.util.Stack;

public class TopologicalSort {

    private boolean[] marked;
    private Stack<Integer> reversePost;

    public TopologicalSort(DiGraph G) {
        this.marked = new boolean[G.V()];
        this.reversePost = new Stack<>();

    }

    private void dfs(DiGraph G, int v){
        marked[v] = true;
        for (int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
        reversePost.push(v);
    }

    public Iterable<Integer> reversePost(){
        return this.reversePost;
    }
}
