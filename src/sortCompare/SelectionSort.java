package sortCompare;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort<E extends Comparable<E>> implements Sorter<E> {
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a.get(j).compareTo(a.get(min)) < 0) {
                    min = j;
                }
            }
            E temp = a.get(i);
            a.set(i, a.get(min));
            a.set(min, temp);
        }
    }

    public void sort(ArrayList<E> data){
        selectionSort(data);
    }

    public static void main(String[] args) {
        ArrayList<String> array1 = new ArrayList<>(Arrays.asList("S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"));
        System.out.println(array1);
        selectionSort(array1);
        System.out.println(array1);
    }
}