package stacks.and.queues;

public class MaxPQ<Item extends Comparable<Item>> {

    private Item[] pq;
    private int N;

    public MaxPQ(int n) {
        pq = (Item[]) new Comparable[n+1];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public void insert(Item data){
        pq[++N] = data;
        swim(N);
    }

    public Item delMax(){
        Item data = pq[1];
        exhg(1,N);
        pq[N] = null;
        N--;
        sink(1);
        return data;
    }

    private void swim(int k){
        while (k>1 && less(k/2, k)) {
            exhg(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            if(j<N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exhg(k,j);
            k=j;
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
        MaxPQ<Integer> maxPQ = new MaxPQ<>(5);
        maxPQ.insert(10);
        maxPQ.insert(50);
        maxPQ.insert(20);
        maxPQ.insert(40);
        maxPQ.insert(5);
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());

    }
}
