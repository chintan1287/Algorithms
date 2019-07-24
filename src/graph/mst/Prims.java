package graph.mst;

import stacks.and.queues.MinPQ;
import java.util.LinkedList;
import java.util.Queue;

public class Prims {

    private Queue<Edge> mst;
    private MinPQ<Edge> pq;
    private boolean[] marked;

    public Prims(EdgeWeightedGraph G) {
        this.marked = new boolean[G.V()];
        this.mst = new LinkedList<Edge>();
        pq = new MinPQ<>(G.V());
        visit(G, 0);
        while (!pq.isEmpty() && mst.size() < G.V()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.add(e);
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }

    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if(!marked[e.other(v)])
                pq.insert(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
