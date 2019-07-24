package stacks.and.queues;

public class MinPQ<Item extends Comparable<Item>> {

    private Item[] pq;
    private int N;

    public MinPQ(int n) {
        pq = (Item[]) new Comparable[n+1];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public void insert(Item data){
        pq[++N] = data;
        swim(N);
    }

    public Item delMin(){
        Item min = pq[1];
        exhg(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return min;
    }

    private void swim(int k){
        while (k>1 && less(k,k/2)) {
            exhg(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k<=N) {
            int j = 2*k;
            if(j<N && less(j+1, j)) j++;
            if(less(k,j)) break;
            exhg(j,k);
            k = j;
        }
    }

    private boolean less(int p, int q){
        return pq[p].compareTo(pq[q])<0;
    }

    private void exhg(int p, int q){
        Item temp = pq[p];
        pq[p] = pq[q];
        pq[q] = temp;
    }

    public static void main(String[] args) {
        MinPQ<Integer> minPQ = new MinPQ<>(5);
        minPQ.insert(10);
        minPQ.insert(20);
        minPQ.insert(5);
        minPQ.insert(25);
        minPQ.insert(7);

        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());

    }
}
