package unionfind;

public class QuickFind {

    private int[] id;

    public QuickFind(int capacity) {
        id = new int[capacity];
        for (int i=0; i<capacity; i++)
            id[i] = i;
    }

    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pId = id[p];
        int qId = id[q];
        for (int i=0; i<id.length; i++) {
            if(id[i]==pId) id[i] = qId;
        }
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(0,5);
        quickFind.union(5,6);
        quickFind.union(6,1);
        quickFind.union(1,2);
        quickFind.union(2,7);
        quickFind.union(3,4);
        quickFind.union(3,8);
        quickFind.union(4,9);
        System.out.println("0-8 :"+quickFind.isConnected(0,8));
        System.out.println("0-7 :"+quickFind.isConnected(0,7));
        System.out.println("8-9 :"+quickFind.isConnected(8,9));
        System.out.println("3-5 :"+quickFind.isConnected(3,5));
    }
}
