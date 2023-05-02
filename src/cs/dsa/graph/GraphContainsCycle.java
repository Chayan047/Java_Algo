/**
 * 
 */
package cs.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author csardar
 *
 *	Given a connected undirected graph, check if it contains any cycle or not.
 */

class Edge6
{
    int source, dest;
 
    public Edge6(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph6
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph6(List<Edge6> edges, int n)
    {
        adjList = new ArrayList<>(n);
 
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge6 edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}


public class GraphContainsCycle {

	
	

    // Function to perform DFS traversal on the graph on a graph
    public static boolean DFS(Graph6 graph, int v, boolean[] discovered, int parent)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // do for every edge (v, w)
        for (int w: graph.adjList.get(v))
        {
            // if `w` is not discovered
            if (!discovered[w])
            {
                if (DFS(graph, w, discovered, v)) {
                    return true;
                }
            }
 
            // if `w` is discovered, and `w` is not a parent
            else if (w != parent)
            {
                // we found a back-edge (cycle)
                return true;
            }
        }
 
        // No back-edges were found in the graph
        return false;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges
        List<Edge6> edges = Arrays.asList(
                        new Edge6(0, 1), new Edge6(0, 6), new Edge6(0, 7),
                        new Edge6(1, 2), new Edge6(1, 5), new Edge6(2, 3),
                        new Edge6(2, 4), new Edge6(7, 8), new Edge6(7, 11),
                        new Edge6(8, 9), new Edge6(8, 10), new Edge6(10, 11)
                        // edge (10, 11) introduces a cycle in the graph
                    );
 
        // total number of nodes in the graph (0 to 11)
        int n = 12;
 
        // build a graph from the given edges
        Graph6 graph = new Graph6(edges, n);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
 
        // Perform DFS traversal from the first vertex
        if (DFS(graph, 0, discovered, -1)) {
            System.out.println("The graph contains a cycle");
        }
        else {
            System.out.println("The graph doesn't contain any cycle");
        }
    }
}
