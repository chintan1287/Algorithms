package sorting;

import java.util.Arrays;

public class SortingClient {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{7,10,5,3,8,4,2,9,6,1};
        Selection selection = new Selection();
        System.out.println("Selection Sort:");
        selection.sort(a);
        Arrays.stream(a).forEach(i-> System.out.print(i+" "));
        System.out.println();

        a = new Integer[]{7,10,5,3,8,4,2,9,6,1};
        Insertion insertion = new Insertion();
        System.out.println("Insertion Sort:");
        insertion.sort(a);
        Arrays.stream(a).forEach(i-> System.out.print(i+" "));
        System.out.println();

        a = new Integer[]{7,10,5,3,8,4,2,9,6,1};
        Merge merge = new Merge();
        System.out.println("Merge Sort:");
        merge.sort(a);
        Arrays.stream(a).forEach(i-> System.out.print(i+" "));
        System.out.println();

        a = new Integer[]{7,10,5,3,8,4,2,9,6,1};
        Quick quick = new Quick();
        System.out.println("Quick Sort:");
        quick.sort(a);
        Arrays.stream(a).forEach(i-> System.out.print(i+" "));
        System.out.println();

        a = new Integer[]{7,10,5,3,8,4,2,9,6,1};
        Heap heap = new Heap();
        System.out.println("Heap Sort:");
        heap.sort(a);
        Arrays.stream(a).forEach(i-> System.out.print(i+" "));
        System.out.println();
    }
}
