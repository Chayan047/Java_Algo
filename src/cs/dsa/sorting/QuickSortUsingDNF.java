package cs.dsa.sorting;

import java.util.Arrays;

/**
 * 
 * 
 * 
 *  Implement Quicksort efficiently for inputs containing many repeated elements.
 * @author csardar
 *
 */
public class QuickSortUsingDNF {

	public static void swap (int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
 
    // Partition routine using the Dutch national flag algorithm
    public static Pair partition(int[] nums, int start, int end)
    {
        int mid = start;
        int pivot = nums[end];
 
        while (mid <= end)
        {
            if (nums[mid] < pivot)
            {
                swap(nums, start, mid);
                ++start;
                ++mid;
            }
            else if (nums[mid] > pivot)
            {
                swap(nums, mid, end);
                --end;
            }
            else {
                ++mid;
            }
        }
 
        // nums[start … mid-1] contains all occurrences of a pivot
        return new Pair(start - 1, mid);
    }
 
    // 3–way Quicksort routine
    public static void quicksort(int[] nums, int start, int end)
    {
        // base condition for 0 or 1 elements
        if (start >= end) {
            return;
        }
 
        // rearrange elements across pivot using the Dutch national flag algorithm
        Pair pivot = partition(nums, start, end);
 
        // recur on the subarray containing elements that are less than the pivot
        quicksort(nums, start, pivot.getX());
 
        // recur on the subarray containing elements that are more than the pivot
        quicksort(nums, pivot.getY(), end);
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, 6, 5, 2, 6, 8, 6, 1, 2, 6 };
 
        // sort list
        quicksort(nums, 0, nums.length - 1);
 
        // print the sorted array
        System.out.println(Arrays.toString(nums));
    }
}

class Pair
{
    private int x;
    private int y;
 
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
 
    public int getX() { return x; }
    public int getY() { return y; }
}