package graph.shortestpath;

public class DirectedEdge implements Comparable<DirectedEdge>{

    private int v;
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return this.v;
    }

    public int to(){
        return this.w;
    }

    public double weight(){
        return this.weight;
    }

    @Override
    public int compareTo(DirectedEdge that) {
        if(this.weight<that.weight) return -1;
        else if(this.weight>that.weight) return 1;
        else return 0;
    }
}
