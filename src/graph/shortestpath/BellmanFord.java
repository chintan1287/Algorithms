package graph.shortestpath;

public class BellmanFord {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public BellmanFord(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v=0; v<G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        distTo[s] = 0.0;

        for (int i=0; i<G.V()-1; i++) {
            for (DirectedEdge edge : G.edges())
                relax(edge);
        }


        for (DirectedEdge edge : G.edges()) {
            int u = edge.from();
            int v = edge.to();
            double weight = edge.weight();

            if(distTo[v] > distTo[u]+weight) {
               // throw exception
               // negative cycle detected
            }
        }
    }

    private void relax(DirectedEdge edge){
        int u = edge.from();
        int v = edge.to();
        double weight = edge.weight();

        if(distTo[v] > distTo[u]+weight) {
            distTo[v] = distTo[u]+weight;
            edgeTo[v] = edge;
        }
    }
}
