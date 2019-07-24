package graph.mst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {

    private int V;
    private LinkedList<Edge>[] adj;
    private List<Edge> edges;

    public EdgeWeightedGraph(int v) {
        V = v;
        this.edges = new ArrayList<>();
        this.adj = new LinkedList[v];
        for (int i=0; i<v; i++)
            adj[i] = new LinkedList<Edge>();
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        edges.add(e);
    }

    public int V(){
        return V;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        return this.edges;
    }
}
