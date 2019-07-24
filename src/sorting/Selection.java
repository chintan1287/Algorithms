package sorting;

public class Selection {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i<N; i++) {
            int min = i;
            for (int j=i+1; j<N; j++) {
                if(SortingUtil.less(a, j, min))
                    min = j;
            }
            SortingUtil.exhg(a,i, min);
        }
    }
}
