/**
 * 
 */
package cs.dsa.DP;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * Given a list of jobs where each job has a start and finish time, and has profit associated with it, find a maximum profit subset of non-overlapping jobs.

For example, consider the following jobs with their starting time, finishing time, and associated profit:

Job 1: (0, 6, 60)
Job 2: (1, 4, 30)
Job 3: (3, 5, 10)
Job 4: (5, 7, 30)
Job 5: (5, 9, 50)
Job 6: (7, 8, 10)
 
 
The maximum profit is 80, which is achieved by picking job 2 and Job 5.



 * @author csardar
 *
 */


//A class to store a Job
class Job
{
 int start, finish, profit;

 Job(int start, int finish, int profit)
 {
     this.start = start;
     this.finish = finish;
     this.profit = profit;
 }
}

public class JobSchedulingProblem {
	// Function to find the index of the last job which doesn't conflict with the
    // given job. It performs a linear search on the given list of jobs.
    public static int findLastNonConflictingJob(List<Job> jobs, int n)
    {
        // find the last job index whose finish time is less than or equal to the
        // given job's start time
        for (int i = n - 1; i >= 0; i--)
        {
            if (jobs.get(i).finish <= jobs.get(n).start) {
                return i;
            }
        }
 
        // return the negative index if no non-conflicting job is found
        return -1;
    }
 
    // A recursive function to find the maximum profit subset of non-overlapping
    // jobs, which are sorted according to finish time
    public static int findMaxProfit(List<Job> jobs, int n)
    {
        // base case
        if (n < 0) {
            return 0;
        }
 
        // return if only one item is remaining
        if (n == 0) {
            return jobs.get(0).profit;
        }
 
        // find the index of the last non-conflicting job with the current job
        int index = findLastNonConflictingJob(jobs, n);
 
        // include the current job and recur for non-conflicting jobs `[0, index]`
        int incl = jobs.get(n).profit + findMaxProfit(jobs, index);
 
        // exclude the current job and recur for remaining items `[0, n-1]`
        int excl = findMaxProfit(jobs, n - 1);
 
        // return the maximum profit by including or excluding the current job
        return Math.max(incl, excl);
    }
 
    // Wrapper over `findMaxProfit()` function
    public static int findMaxProfit(List<Job> jobs)
    {
        // sort jobs in increasing order of their finish times
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));
 
        return findMaxProfit(jobs, jobs.size() - 1);
    }
 
    public static void main(String[] args)
    {
        List<Job> jobs = Arrays.asList(
                new Job(0, 6, 60),
                new Job(1, 4, 30),
                new Job(3, 5, 10),
                new Job(5, 7, 30),
                new Job(5, 9, 50),
                new Job(7, 8, 10)
        );
 
        System.out.print("The maximum profit is " + findMaxProfit(jobs));
    }

}
