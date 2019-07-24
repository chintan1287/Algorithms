package graph.directed;

public class SCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public SCC(DiGraph G) {
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        TopologicalSort topologicalSort = new TopologicalSort(G.reverse());
        for (int v : topologicalSort.reversePost()) {
            if(!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    public void dfs(DiGraph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int count(){
        return count;
    }
}
