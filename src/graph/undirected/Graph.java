package graph.undirected;

import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }
}
