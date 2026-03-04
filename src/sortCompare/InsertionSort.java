package sortCompare;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort<E extends Comparable<E>> implements Sorter<E>{

    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a.get(j).compareTo(a.get(j - 1)) < 0) {
                    E temp = a.get(j);
                    a.set(j, a.get(j-1));
                    a.set(j - 1, temp);
                } else {
                    break;
                }
            }
        }
    }


    public void sort(ArrayList<E> data){
        insertionSort(data);
    }

    public static void main(String[] args) {
        ArrayList<String> array1 = new ArrayList<>(Arrays.asList("S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"));
        System.out.println(array1);
        insertionSort(array1);
        System.out.println(array1);

    }
}