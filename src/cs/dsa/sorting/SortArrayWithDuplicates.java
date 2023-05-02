/**
 * 
 */
package cs.dsa.sorting;

import java.util.Arrays;

/**
 * 
 * Given an integer array with many duplicated elements, 
 * write an algorithm to efficiently sort it in linear time,
 *  where the order of equal elements doesn’t matter.
 *  
 * @author csardar
 *
 */
public class SortArrayWithDuplicates {

	public static final int RANGE = 100;
	 
    // Function to efficiently sort an array with many duplicated values
    // using the counting sort algorithm
    public static void customSort(int[] arr)
    {
        // create a new array to store counts of elements in the input array
        int[] freq = new int[RANGE];
 
        // using the value of elements in the input array as an index,
        // update their frequencies in the new array
        for (int i: arr) {
            freq[i]++;
        }
 
        // overwrite the input array with sorted order
        int k = 0;
        for (int i = 0; i < RANGE; i++)
        {
            while (freq[i]-- > 0) {
                arr[k++] = i;
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 40 };
 
        customSort(arr);
 
        System.out.println(Arrays.toString(arr));
    }

}
