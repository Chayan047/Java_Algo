package cs.dsa.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * 
 *  
 *  Count total possible combinations of n-digit numbers in a mobile keypad
Google Translate Icon
Given a positive number n and a mobile keypad having digits from 0 to 9 associated with each key, 
count the total possible combinations of digits having length n. We can start with any digit and 
press only four adjacent keys of any digit. 
The keypad also contains * and # keys, which we are not allowed to press.
 * 
 * 
 * 
 * 
 * @author csardar
 *
 */

public class CountNumbersInMobileKeypad {

	// The function returns false if `(i, j)` is not a valid position
    public static boolean isValid(int i, int j)
    {
        // for handling `*` or `#` (present in 4th row and 1st
        // & 3rd column)
        if (i == 3 && (j == 0 || j == 2)) {
            return false;
        }
 
        return (i >= 0 && i <= 3 && j >= 0 && j <= 2);
    }
 
    // Function to fill a multimap that stores the mapping of cells
    // reachable from the current cell
    public static Map<Integer, List<Integer>> fillMap(char[][] keypad)
    {
        // use a multimap to store the mapping of cells reachable
        // from the current cell
        Map<Integer, List<Integer>> mapping = new HashMap<>();
 
        // Below arrays detail all four possible movements from the current cell
        int[] row = { 0, -1, 0, 1 };
        int[] col = { -1, 0, 1, 0 };
 
        // do for each row
        for (int i = 0; i < 4; i++)
        {
            // do for each column of row `i`
            for (int j = 0; j < 3; j++)
            {
                // move in all four possible directions of current
                // digit `keypad[i][j]`
                for (int k = 0; k < 4; k++)
                {
                    int r = i + row[k];
                    int c = j + col[k];
 
                    // insert the adjacent cell into the multimap if valid
                    if (isValid(i, j) && isValid(r, c))
                    {
                        mapping.putIfAbsent(keypad[i][j] - '0', new ArrayList<>());
                        mapping.get(keypad[i][j] - '0').add(keypad[r][c] - '0');
                    }
                }
            }
        }
 
        return mapping;
    }
 
    // Function to count all numbers starting from digit `i` and
    // having length `n`
    public static int getCount(Map<Integer, List<Integer>> mapping,
                               int i, int n, int[][] lookup)
    {
        if (n == 1) {    // reached end of the digit
            return 1;
        }
 
        // if the subproblem is seen for the first time, solve it and
        // store its result in an array
        if (lookup[i][n] == 0)
        {
            // recur for digit `i`
            lookup[i][n] = getCount(mapping, i, n - 1, lookup);
 
            // recur for all digits reachable from `i`
            for (Integer e: mapping.get(i)) {
                lookup[i][n] += getCount(mapping, e, n - 1, lookup);
            }
        }
 
        // return the subproblem solution
        return lookup[i][n];
    }
 
    private static int findCount(int n, char[][] keypad)
    {
        // get the mapping of cells reachable from the current cell
        Map<Integer, List<Integer>> mapping = fillMap(keypad);
 
        // create a lookup table to store solutions to subproblems
        // `lookup[i][j]` stores count of all numbers starting from digit `i`
        // having length `n`
        int[][] lookup = new int[10][n+1];
 
        // get the count of each digit
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            count += getCount(mapping, i, n, lookup);
        }
 
        return count;
    }
 
    public static void main(String[] args)
    {
        // n-digit
        int n = 2;
 
        // mobile mapping
        char[][] keypad =
        {
            { '1', '2', '3' },
            { '4', '5', '6' },
            { '7', '8', '9' },
            { '*', '0', '#' }
        };
 
        System.out.print("Total possible combinations are " + findCount(n, keypad));
    }

}
