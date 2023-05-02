/**
 * 
 */
package cs.dsa.DP;

/**
 * 
 * 
 * 
 * 
 * 
Given a list containing future price predictions of two different stocks for the next n–days, find the maximum profit earned by selling the stocks with a constraint that the second stock can be sold, only if no transaction happened on the previous day for any of the stock.

Assume that the given prices are relative to the buying price. Each day, we can either sell a single share of the first stock or a single share of the second stock or sell nothing.

For example,

Input:
 
Day    Price(x)  Price(y)
1        5        8
2        3        4
3        4        3
4        6        5
5        3        10
 
Output: Maximum profit earned is 25
 
Explanation:
 
Day 1: Sell stock y at a price of 8
Day 2: Sell stock x at a price of 3
Day 3: Sell stock x at a price of 4
Day 4: Don’t sell anything
Day 5: Sell stock y at a price of 10




@author csardar
 *
 */
public class MaxProfitStocks {

	// Function to find the maximum profit that can be earned by selling the stocks.
    // Here, arrays `x[0…n-1]` and `y[0…n-1]` contains the two different stocks'
    // future price predictions for the next n–days.
    public static int findMaxProfit(int[] x, int[] y)
    {
        // base case
        if (x.length == 0) {
            return 0;
        }
 
        int prev_of_prev = 0;
        int prev = Integer.max(x[0], y[0]);
 
        // Find the maximum profit in a bottom-up manner
        for (int i = 1; i < x.length; i++)
        {
            int curr = Integer.max(x[i] + prev, y[i] + prev_of_prev);
            prev_of_prev = prev;
            prev = curr;
        }
 
        // `prev` stores the maximum profit gained till day `n`
        return prev;
    }
 
    public static void main(String[] args)
    {
        int[] x = { 5, 3, 4, 6, 3 };
        int[] y = { 8, 4, 3, 5, 10 };
 
        System.out.println("The maximum profit earned is " + findMaxProfit(x, y));
    }

}
