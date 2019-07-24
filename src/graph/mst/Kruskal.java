package graph.mst;

import stacks.and.queues.MinPQ;
import unionfind.QuickUnion;

import java.util.LinkedList;
import java.util.Queue;

public class Kruskal {

    private Queue<Edge> mst;

    public Kruskal(EdgeWeightedGraph G) {
        this.mst = new LinkedList<Edge>();
        MinPQ<Edge> pq = new MinPQ<>(G.V());
        for (Edge e : G.edges())
            pq.insert(e);

        QuickUnion uf = new QuickUnion(G.V());

        while (!pq.isEmpty() && mst.size() < G.V()-1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(!uf.isConnected(v, w)) {
                uf.union(v, w);
                mst.add(e);
            }
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
