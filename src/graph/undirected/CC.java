package graph.undirected;

public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        for (int v=0; v<G.V(); v++) {
            if(!marked[v]){
                dfs(G, v);
                count++;
            }
        }
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count(){
        return count;
    }

    public int id(int v){
        return id[v];
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
}
