/**
 * 
 */
package cs.algoexpert.easy;

/**
 * @author csardar
 *
 *Non-Constructible Change
	Given an array of positive integers representing the values of coins in your possession, write a function 
	that returns the minimum amount of change (the minimum sum of money) that you 
	cannot create. The given coins can have any positive integer value and aren't 
	necessarily unique (i.e., you can have multiple coins of the same value).

	For example, if you're given coins = [1, 2, 5], the minimum amount of change that you 
	can't create is 4. If you're given no coins, the minimum amount of change that you can't create is 1.
 *
 *
 */


	
	import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

	class NonConstructibleChange {

	  public int nonConstructibleChange(int[] coins) {
	    // Default Scenarios
	    if(coins==null || coins.length==0){
	      return 1;
	    }
	    //Prepare code
		List<Integer> coinsList = Arrays.stream(coins).sorted().boxed().collect(Collectors.toList());
			
	    int totalSum = 0;
	    for(Integer coin: coinsList){

	      
	    }
	    return -1;
	  }
	}

	
