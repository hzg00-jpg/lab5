package sortCompare;

import java.util.ArrayList;

/**
 * An implementation of the Quicksort algorithm following the Hoare Partition scheme
 * 
 * @param <E> the type of elements to be sorted
 */
public class Quicksort<E extends Comparable<E>> implements Sorter<E>{

	/**
	 * Sorts the data using Quicksort
	 * 
	 * @param data Data to be sorted
	 */
	public void sort(ArrayList<E> data) {
		quicksortHelper(data, 0, data.size()-1);
	}
	
	/**
	 * Helper method for Quicksort.  Sorts data so that data[lo .. j-1] <= data[j] <= data[j+1 .. hi]
	 * 
	 * @param data data to be sorted
	 * @param lo start of the data to be sorted (inclusive)
	 * @param hi end of the data to be sorted (exclusive)
	 */
	private void quicksortHelper(ArrayList<E> data, int lo, int hi){
		if( hi <= lo ){
			return;
		}
		int pivot = partition(data, lo, hi);
		quicksortHelper(data, lo, pivot-1);
		quicksortHelper(data, pivot+1, hi);

	}

	/**
	 * partitions the data based on the element at index end.
	 * 
	 * @param data data to be partitioned
	 * @param lo start of the data to be partitioned
	 * @param hi end of the data to be partitioned
	 * @return returned the index of the pivot element (after being copied 
	 * into the correct location)
	 */
	private int partition(ArrayList<E> data, int lo, int hi){
        int i = lo-1;
        E pivot = data.get(hi);
        for(int j = lo; j < hi; j++ ){
			if(data.get(j).compareTo(pivot) <= 0 ) {
				i++;
                E temp = data.get(i);
                data.set(i,data.get(j));
                data.set(j, temp);
            }
		}

        i++;
        E temp = data.get(i);
        data.set(i, data.get(hi));
        data.set(hi, temp);	
        	
        return i;    
	}
}
