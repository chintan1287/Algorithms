package sorting;

public class Insertion {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i<N; i++) {
            for (int j = i; j>0; j--) {
                if(SortingUtil.less(a, j, j-1))
                    SortingUtil.exhg(a, j, j-1);
                else break;
            }
        }
    }
}
