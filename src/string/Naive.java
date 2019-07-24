package string;

public class Naive {

    public int search(String txt, String pattern) {
        if(txt == null || pattern == null || pattern.length()==0 || txt.length() == 0)
            return -1;

        int i=0, n = txt.length();
        int j=0, m = pattern.length();

        for (i=0; i<n && j<m; i++) {
            if(txt.charAt(i) == pattern.charAt(j)) j++;
            else {
                i -=j;
                j=0;
            }
        }

        if(j==m) return i-m;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Naive naive = new Naive();
        String txt = "ABACADABRAC";
        String pattern = "ADA";
        System.out.println(naive.search(txt, pattern));
    }
}
