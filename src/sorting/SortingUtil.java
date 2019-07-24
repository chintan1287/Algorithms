package sorting;

public class SortingUtil {

    public static boolean less(Comparable[] a, int p, int q){
        return a[p].compareTo(a[q])<0;
    }

    public static void exhg(Comparable[] a, int p, int q){
        Comparable temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }
}
