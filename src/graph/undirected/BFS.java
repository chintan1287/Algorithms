package graph.undirected;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

    private int s;
    private boolean[] marked;
    private int[] edgeTo;

    public BFS(Graph G, int s) {
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        bfs(G, s);
    }

    public void bfs(Graph G, int v){
        marked[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int w : G.adj(p)) {
                if(!marked[w]) {
                    marked[w] = true;
                    queue.add(w);
                    edgeTo[w] = p;
                }
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
