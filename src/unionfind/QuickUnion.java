package unionfind;

public class QuickUnion {

    private int[] id;

    public QuickUnion(int capacity) {
        id = new int[capacity];
        for (int i=0; i<capacity; i++)
            id[i] = i;
    }

    private int root(int p){
        while (id[p]!=p) p = id[p];
        return p;
    }

    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p,int q){
        int rootpId = root(p);
        int rootqId = root(q);
        id[rootpId] = rootqId;
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(0,5);
        quickUnion.union(5,6);
        quickUnion.union(6,1);
        quickUnion.union(1,2);
        quickUnion.union(2,7);
        quickUnion.union(3,4);
        quickUnion.union(3,8);
        quickUnion.union(4,9);
        System.out.println("0-8 :"+quickUnion.isConnected(0,8));
        System.out.println("0-7 :"+quickUnion.isConnected(0,7));
        System.out.println("8-9 :"+quickUnion.isConnected(8,9));
        System.out.println("3-5 :"+quickUnion.isConnected(3,5));
    }
}
