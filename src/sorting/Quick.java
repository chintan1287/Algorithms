package sorting;

public class Quick {

    public static void sort(Comparable[] a){
        int N = a.length;
        sort(a, 0, N-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p-1);
        sort(a, p+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;

        while (true) {
            while (SortingUtil.less(a, ++i, lo)){
                if(i>=hi) break;
            }

            while (SortingUtil.less(a, lo, --j)){
                if(j<=lo) break;
            }

            if(i>=j) break;
            SortingUtil.exhg(a, i, j);
        }

        SortingUtil.exhg(a, lo, j);
        return j;
    }
}
