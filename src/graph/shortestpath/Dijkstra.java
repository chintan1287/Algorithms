package graph.shortestpath;

import stacks.and.queues.BinaryMinHeap;

public class Dijkstra {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private BinaryMinHeap<Integer, Double> binaryMinHeap;

    public Dijkstra(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        binaryMinHeap = new BinaryMinHeap<>();

        for (int i = 0; i<G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;

        distTo[s] = 0.0;
        binaryMinHeap.insert(s, 0.0);

        while (!binaryMinHeap.isEmpty()) {
            int v = binaryMinHeap.deleteMin();
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }
    }

    private void relax(DirectedEdge edge){
        int v = edge.from();
        int w = edge.to();

        if(distTo[w] > distTo[v]+edge.weight()) {
            distTo[w] = distTo[v]+edge.weight();
            edgeTo[w] = edge;
            if(binaryMinHeap.contains(w)) binaryMinHeap.decrease(w, distTo[w]);
            else binaryMinHeap.insert(w, distTo[w]);
        }
    }
}
