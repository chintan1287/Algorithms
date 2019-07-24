package graph.directed;

import java.util.LinkedList;

public class DiGraph {

    private int V;
    private LinkedList<Integer>[] adj;

    public DiGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public DiGraph reverse(){
        DiGraph reverse = new DiGraph(this.V());
        for (int v=0; v<this.V(); v++) {
            for (int w: this.adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
}
