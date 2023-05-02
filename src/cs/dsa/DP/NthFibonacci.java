/**
 * 
 */
package cs.dsa.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author csardar
 *
 */
public class NthFibonacci {

	// Function to find the nth Fibonacci number
    public static int fib(int n, Map<Integer, Integer> lookup)
    {
        if (n <= 1) {
            return n;
        }
 
        // if the subproblem is seen for the first time
        lookup.putIfAbsent(n, fib(n - 1, lookup) + fib(n - 2, lookup));
 
        return lookup.get(n);
    }
 
    public static void main(String[] args)
    {
        int n = 8;
        Map<Integer, Integer> lookup = new HashMap<>();
 
        System.out.println("F(n) = " + fib(n, lookup));
    }

}
