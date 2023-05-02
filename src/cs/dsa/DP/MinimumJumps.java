/**
 * 
 */
package cs.dsa.DP;

import java.util.Arrays;

/**
 * 
 * Given an array of non-negative integers, where each array element represents the maximum number of positions one can move forward from that element. Find the minimum number of jumps required to reach a given destination from a given source within the array.

If any element has value zero in the array, the destination cannot be reached through that element. If the source itself has value zero, return infinity as the destination cannot be reached at all. To make the problem simpler, let’s assume the source and destination to be the start and end of the array.

 
For example,

Input:  nums[] = { 4, 2, 0, 3, 2, 0, 1, 8 }
 
Output: Minimum jumps required to reach the destination are 3.
 
3 jumps: (4 —> 3 —> 1 —> 8) or (4 —> 2 —> 1 —> 8)
4 jumps: (4 —> 2 —> 3 —> 1 —> 8) or (4 —> 3 —> 2 —> 1 —> 8)
5 jumps: (4 —> 2 —> 3 —> 2 —> 1 —> 8)
 
 
Input:  nums[] = { 4, 2, 2, 1, 0, 8, 1 }
 
Output: Minimum jumps required to reach the destination are infinity. This is because no matter what path we choose, we will always end up in a dead cell.
 
4 —> 2 —> 2 —> 1 —> 0
4 —> 2 —> 1 —> 0
4 —> 1 —> 0
4 —> 0
 * 
 * 
 * 
 * 
 * 
 * @author csardar
 *
 */
public class MinimumJumps {

	// Find minimum jumps required to reach the destination
    public static int findMinJumps(int[] nums)
    {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
 
        // get the length of the array
        int n = nums.length;
 
        // base case: the destination is unreachable from the source
        if (n > 1 && nums[0] == 0) {
            return Integer.MAX_VALUE;
        }
 
        // lookup[i] stores minimum jumps required to reach nums[i] from source nums[0]
        int[] lookup = new int[n];
        Arrays.fill(lookup, Integer.MAX_VALUE);
 
        // destination is the same as the source
        lookup[0] = 0;
 
        // do for every position
        for (int i = 0; i < n; i++)
        {
            // find the minimum jumps required to reach the destination by
            // considering the minimum from each position reachable from nums[i]
            for (int j = 1; (i + j < n) && j <= Math.min(n - 1, nums[i]) &&
                lookup[i] != Integer.MAX_VALUE; j++)
            {
                lookup[i + j] = (lookup[i + j] != Integer.MAX_VALUE) ?
                            Math.min(lookup[i + j], lookup[i] + 1): (lookup[i] + 1);
            }
        }
 
        // lookup[n-1] would have the result since nums[n-1] is the destination
        return lookup[n - 1];
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 4, 2, 0, 3, 2, 0, 1, 8 };
 
        System.out.println("The minimum jumps required to reach the destination are " +
                                    findMinJumps(nums));
    }

}
