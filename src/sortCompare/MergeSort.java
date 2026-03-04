package sortCompare;

import java.util.ArrayList;

/**
 * Implementation of the MergeSort algorithm
 * 
 *
 * @param <E> type of data to be sorted
 */
public class MergeSort<E extends Comparable<E>> implements Sorter<E>{
	
	/**
	 * Sort the ArrayList of data using MergeSort
	 * 
	 * @param list data to be sorted
	 */
	public void sort(ArrayList<E> data){
		sortHelper(data, 0, data.size());
	}

	/**
	 * MergeSort helper method.  Sorts data >= start and < end
	 * 
	 * @param list data to be sorted
	 * @param low start of the data to be sorted
	 * @param high end of the data to be sorted (exclusive)
	 */
	private void sortHelper(ArrayList<E> data, int low, int high){
		if( high-low > 1 ){
			int mid = low + (high-low)/2;
			
			sortHelper(data, low, mid);
			sortHelper(data, mid, high);
			merge(data, low, mid, high);
		}
	}

	/**
	 * Merge data >= low and < high into sorted data.  Data >= low and < mid are in sorted order.
	 * Data >= mid and < high are also in sorted order
	 * 
	 * @param data the partially sorted data
	 * @param low bottom index of the data to be merged
	 * @param mid midpoint of the data to be merged
	 * @param high end of the data to be merged (exclusive)
	 *
	 * Note: the merged data must be in the same data array that
	 *       was passed as a parameter.
	 */
	public void merge(ArrayList<E> data, int low, int mid, int high){

		//TODO: make a temporary arraylist of Es that has capacity high-low.
		ArrayList<E> temp = new ArrayList<>(high - low);

		// Keep an index i that starts at low and index j that starts at mid
		int i = low;
		int j = mid;

		// As long as i has not crossed mid and j has not crossed high
			// If the data at i-th position are <= than the data at j-th position
			// then add to the temporary arraylist the data from the i-th position and advance i

			//Otherwise, take them from the j-th position and advance j
		while (i < mid && j < high) {
            // Compare elements at i and j
            if (data.get(i).compareTo(data.get(j)) <= 0) {
                temp.add(data.get(i));
                i++;
            } else {
                temp.add(data.get(j));
                j++;
            }
        }
		
		// copy over the remaining data on the i to mid side if there
		// is some remaining.  
		while (i < mid) {
            temp.add(data.get(i));
            i++;
        }

		// copy over the remaining data on the j to high side if there
		// is some remaining.  Only one of these two while loops should
		// actually execute
		while (j < high) {
            temp.add(data.get(j));
            j++;
        }

		// copy the data back from the temporary auxiliary arraylist to the original data arraylist
		for (int k = 0; k < temp.size(); k++) {
            data.set(low + k, temp.get(k));
        }
	}
}
