/**
 * 
 */
package cs.dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 
 * 
 *Given four integer arrays, count the number of quadruplets with a zero sum, 
 *including exactly one element from each array.

For example,

Input:
 
A = [0, -1, 1]
B = [-1]
C = [2, 4]
D = [-4, 0]
 
Output: 2
 
Explanation: There are two quadruplets with a zero sum, as follows:
 
A[1] + B[0] + C[0] + D[1] = [-1 + -1 + 2 + 0]
A[2] + B[0] + C[1] + D[0] = [ 1 + -1 + 4 + -4]
 * 
 * 
 * 
 * 
 * @author csardar
 *
 */
public class CountQuadraple {

	/**
	 * 
	 */
	 public static int find4Tuples(int[] A, int[] B, int[] C, int[] D)
	    {
	        // create a map to store pair sum-frequency mappings
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
	        // consider each pair of the first two arrays
	        for (int i : A)
	        {
	            for (int j : B)
	            {
	                // calculate the sum of each pair and update its count in the map
	                int sum = i + j;
	                map.put(sum, map.getOrDefault(sum, 0) + 1);
	            }
	        }
	 
	        // store the count of quadruplets with a zero sum
	        int count = 0;
	 
	        // consider each pair of the remaining two arrays
	        for (int i : C)
	        {
	            for (int j : D)
	            {
	                // calculate the sum of each pair
	                int sum = i + j;
	 
	                // increment the quadruplet count, if the opposite sum exists in the map
	                count += map.getOrDefault(-sum, 0);
	            }
	        }
	 
	        return count;
	    }
	 
	    public static void main(String[] args)
	    {
	        int[] A = { 0, -1, 1 } ;
	        int[] B = { -1 };
	        int[] C = { 2, 4 };
	        int[] D = { -4, 0 };
	 
	        System.out.println(find4Tuples(A, B, C, D));
	    }

}
