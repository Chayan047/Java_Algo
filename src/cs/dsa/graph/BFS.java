/**
 * 
 */
package cs.dsa.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author csardar
 *
 */


//A class to store a graph edge
class Edge5
{
 int source, dest;

 public Edge5(int source, int dest)
 {
     this.source = source;
     this.dest = dest;
 }
}

//A class to represent a graph object
class Graph5
{
 // A list of lists to represent an adjacency list
 List<List<Integer>> adjList = null;

 // Constructor
 Graph5(List<Edge5> edges, int n)
 {
     adjList = new ArrayList<>();

     for (int i = 0; i < n; i++) {
         adjList.add(new ArrayList<>());
     }

     // add edges to the undirected graph
     for (Edge5 edge: edges)
     {
         int src = edge.source;
         int dest = edge.dest;

         adjList.get(src).add(dest);
         adjList.get(dest).add(src);
     }
 }
}











public class BFS {

	/**
	 * 
	 */
	 public static void BFS(Graph5 graph, int v, boolean[] discovered)
	    {
	        // create a queue for doing BFS
	        Queue<Integer> q = new ArrayDeque<>();
	 
	        // mark the source vertex as discovered
	        discovered[v] = true;
	 
	        // enqueue source vertex
	        q.add(v);
	 
	        // loop till queue is empty
	        while (!q.isEmpty())
	        {
	            // dequeue front node and print it
	            v = q.poll();
	            System.out.print(v + " ");
	 
	            // do for every edge (v, u)
	            for (int u: graph.adjList.get(v))
	            {
	                if (!discovered[u])
	                {
	                    // mark it as discovered and enqueue it
	                    discovered[u] = true;
	                    q.add(u);
	                }
	            }
	        }
	    }
	 
	    public static void main(String[] args)
	    {
	        // List of graph edges as per the above diagram
	        List<Edge5> edges = Arrays.asList(
	                new Edge5(1, 2), new Edge5(1, 3), new Edge5(1, 4), new Edge5(2, 5),
	                new Edge5(2, 6), new Edge5(5, 9), new Edge5(5, 10), new Edge5(4, 7),
	                new Edge5(4, 8), new Edge5(7, 11), new Edge5(7, 12)
	                // vertex 0, 13, and 14 are single nodes
	        );
	 
	        // total number of nodes in the graph (labelled from 0 to 14)
	        int n = 15;
	 
	        // build a graph from the given edges
	        Graph5 graph = new Graph5(edges, n);
	 
	        // to keep track of whether a vertex is discovered or not
	        boolean[] discovered = new boolean[n];
	 
	        // Perform BFS traversal from all undiscovered nodes to
	        // cover all connected components of a graph
	        for (int i = 0; i < n; i++)
	        {
	            if (discovered[i] == false)
	            {
	                // start BFS traversal from vertex `i`
	                BFS(graph, i, discovered);
	            }
	        }
	    }

}
