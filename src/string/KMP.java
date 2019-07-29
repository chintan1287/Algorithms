package string;

import java.util.Arrays;

public class KMP {

    public static boolean kmp(String text, String pattern){

        int[] patternArray = kmpPatternArray(pattern);
        int i=0;
        int j=0;

        while (i<text.length() && j<pattern.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j!=0) {
                    j = patternArray[j-1];
                } else {
                    i++;
                }
            }
        }

        if(j==pattern.length())
            return true;
        return false;
    }
    private static int[] kmpPatternArray(String pattern){
        int[] patternArray = new int[pattern.length()];
        int i = 0;
        patternArray[0] = 0;
        for (int j = 1; j<pattern.length();) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                patternArray[j] = i+1;
                i++;
                j++;
            } else {
                if(i!=0) {
                    i = patternArray[i-1];
                } else {
                    patternArray[j] = 0;
                    j++;
                }
            }
        }
        return patternArray;
    }

    public static void main(String[] args) {
        String text = "jhkjhkjhskdhckjshdabcdabcjjhjjhabcdabca";
        String pattern = "abcdabca";
        Arrays.stream(KMP.kmpPatternArray(pattern)).forEach(x-> System.out.print(x+" "));
        System.out.println();
        System.out.println("Pattern found: "+KMP.kmp(text, pattern));
    }
}
