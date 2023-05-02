/**
 * 
 */
package cs.dsa.sorting;

import java.util.Arrays;

/**
 * @author csardar
 *
 */
public class HeapSort {

	 // return left child of `A[i]`
    private static int LEFT(int i) {
        return (2*i + 1);
    }
 
    // return right child of `A[i]`
    private static int RIGHT(int i) {
        return (2*i + 2);
    }
 
    // Utility function to swap two indices in the array
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
    // Recursive heapify-down algorithm. The node at index `i` and
    // its two direct children violates the heap property
    private static void heapify(int[] A, int i, int size)
    {
        // get left and right child of node at index `i`
        int left = LEFT(i);
        int right = RIGHT(i);
 
        int largest = i;
 
        // compare `A[i]` with its left and right child
        // and find the largest value
        if (left < size && A[left] > A[i]) {
            largest = left;
        }
 
        if (right < size && A[right] > A[largest]) {
            largest = right;
        }
 
        // swap with a child having greater value and
        // call heapify-down on the child
        if (largest != i)
        {
            swap(A, i, largest);
            heapify(A, largest, size);
        }
    }
 
    // Function to remove an element with the highest priority (present at the root)
    public static int pop(int[] A, int size)
    {
        // if the heap has no elements
        if (size <= 0) {
            return -1;
        }
 
        int top = A[0];
 
        // replace the root of the heap with the last element
        // of the array
        A[0] = A[size-1];
 
        // call heapify-down on the root node
        heapify(A, 0, size - 1);
 
        return top;
    }
 
    // Function to perform heapsort on array `A` of size `n`
    public static void heapsort(int[] A)
    {
        // build a priority queue and initialize it by the given array
        int n = A.length;
 
        // Build-heap: Call heapify starting from the last internal
        // node all the way up to the root node
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(A, i--, n);
        }
 
        // repeatedly pop from the heap till it becomes empty
        while (n > 0)
        {
            A[n - 1] = pop(A, n);
            n--;
        }
    }
 
    // Heapsort algorithm implementation in Java
    public static void main(String[] args)
    {
        int[] A = { 6, 4, 7, 1, 9, -2 };
 
        // perform heapsort on the array
        heapsort(A);
 
        // print the sorted array
        System.out.println(Arrays.toString(A));
    }
}
