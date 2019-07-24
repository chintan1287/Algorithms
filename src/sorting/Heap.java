package sorting;

public class Heap {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int k = N/2; k>=1; k--)
            sink(a, k, N);
        while (N>1) {
            exhg(a, 1, N);
            N--;
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N){
        while (2*k<=N) {
            int j = 2*k;
            if(j<N && less(a, j, j+1)) j++;
            if(less(a, j, k)) break;
            exhg(a, j, k);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int p, int q){
        return a[p-1].compareTo(a[q-1])<0;
    }

    private static void exhg(Comparable[] a, int p, int q){
        Comparable temp = a[p-1];
        a[p-1] = a[q-1];
        a[q-1] = temp;
    }
}
