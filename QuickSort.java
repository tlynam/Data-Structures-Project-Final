import java.util.Arrays;

/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Quicksort recursively subdivides the data
//It subdivides the data based on a calculated pivot point
//It swaps data so that all data lower than the pivot is moved to the left of the pivot
//and all data greater than the pivot is moved to the right of the pivot
//This is done recursively until the entire data is sorted
public class QuickSort{

	public void sort(int[] data, int first, int last) {
		//Verify first and last indexes passed are valid
		//During a recursive call, last can be -1
		if(first < 0 || last < -1){
			System.out.println("Passed first must be >= 0 and last values must be >= -1");
			System.exit(-1);
		}
		
		//Base case that first must be less than last
		if(first < last){
			//Partitioning data into two halves while returning the pivotIndex
			int pivotIndex = partition(data, first, last);
			
			//Recursively calling sort method to sort each half on either side of pivotIndex
			sort(data, first, pivotIndex - 1);
			sort(data, pivotIndex + 1, last);
		}
	}

	private int partition(int[] partData, int left, int right){
		//System.out.println("Left: " + left);
		//System.out.println("Right: " + right);
		//Using median of three for pivot
		//http://en.wikipedia.org/wiki/Quicksort#Choice_of_pivot
		int pivotIndex = left + (right - left) / 2;
		//Assigning pivotValue for comparison later
		int pivotValue = partData[pivotIndex];
		//System.out.println(pivotValue);
		//Swap the pivot index temporarily to the furthest right index of the sub array
		swap(partData, pivotIndex, right);
		//Store index is where the lowest values will be swapped starting on the left
		int storeIndex = left;
		for(int i=left; i < right; i++){
			//If value of i is less than pivot value, swap it to the storeIndex
			if(partData[i] <= pivotValue){
				swap(partData, i, storeIndex);
				storeIndex++;
			}
		}
		//Swap and move pivot index to final index
		swap(partData,storeIndex, right);
		//System.out.println(Arrays.toString(partData));
		return storeIndex;
	}
	
	public void swap(int[] dataSwap, int idx1, int idx2) {
		int temp = dataSwap[idx1];
		dataSwap[idx1] = dataSwap[idx2];
		dataSwap[idx2] = temp;
	}

}