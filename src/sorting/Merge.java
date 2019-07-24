package sorting;

public class Merge {

    public static void sort(Comparable[] a){
        int N = a.length;
        sort(new Comparable[N], a, 0, N-1);
    }

    private static void sort(Comparable[] aux, Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int mid = lo +(hi-lo)/2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid+1, hi);
        merge(aux, a, lo, mid, hi);
    }

    private static void merge(Comparable[] aux, Comparable[] a, int lo, int mid, int hi){
        for(int k = lo; k<=hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid+1;

        for (int k=lo; k<=hi; k++) {
            if(i>mid) a[k] = aux[j++];
            else if(j>hi) a[k] = aux[i++];
            else if(SortingUtil.less(aux, i, j)) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
