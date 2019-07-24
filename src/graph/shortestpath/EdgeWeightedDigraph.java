package graph.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedDigraph {

    private int V;
    private LinkedList<DirectedEdge>[] adj;
    private List<DirectedEdge> edges;

    public EdgeWeightedDigraph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        edges = new ArrayList<>();
        for (int i=0; i<v; i++)
            adj[i] = new LinkedList<DirectedEdge>();
    }

    public void addEdge(DirectedEdge edge){
        int v = edge.from();
        adj[v].add(edge);
        edges.add(edge);
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        return edges;
    }

    public int V(){
        return V;
    }
}
