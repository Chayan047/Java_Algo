/**
 * 
 */
package cs.dsa.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Depth–first search (DFS) is an algorithm for traversing or searching tree or 
 * graph data structures. One starts at the root (selecting some arbitrary node as the root for a graph) 
 * and explore as far as possible along each branch before backtracking.
 * 
 * 
 * 
 * 
 * @author csardar
 *
 */
public class DFS {
	
		public static void DFS(Graph4 graph, int v, boolean[] discovered)
	    {
	        // mark the current node as discovered
	        discovered[v] = true;
	 
	        // print the current node
	        System.out.print(v + " ");
	 
	        // do for every edge (v, u)
	        for (int u: graph.adjList.get(v))
	        {
	            // if `u` is not yet discovered
	            if (!discovered[u]) {
	                DFS(graph, u, discovered);
	            }
	        }
	    }
	 
	    public static void main(String[] args)
	    {
	        // List of graph edges as per the above diagram
	        List<Edge4> edges = Arrays.asList(
	                // Notice that node 0 is unconnected
	                new Edge4(1, 2), new Edge4(1, 7), new Edge4(1, 8), new Edge4(2, 3),
	                new Edge4(2, 6), new Edge4(3, 4), new Edge4(3, 5), new Edge4(8, 9),
	                new Edge4(8, 12), new Edge4(9, 10), new Edge4(9, 11)
	            );
	 
	        // total number of nodes in the graph (labelled from 0 to 12)
	        int n = 13;
	 
	        // build a graph from the given edges
	        Graph4 graph = new Graph4(edges, n);
	 
	        // to keep track of whether a vertex is discovered or not
	        boolean[] discovered = new boolean[n];
	 
	        // Perform DFS traversal from all undiscovered nodes to
	        // cover all connected components of a graph
	        for (int i = 0; i < n; i++)
	        {
	            if (!discovered[i]) {
	                DFS(graph, i, discovered);
	            }
	        }
	    }
	}




class Edge4
{
    int source, dest;
 
    public Edge4(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph4
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph4(List<Edge4> edges, int n)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge4 edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
