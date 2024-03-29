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
 */
public class TopologicalSort {

	// Perform DFS on the graph and set the departure time of all
    // vertices of the graph
    static int DFS(Graph9 graph, int v, boolean[] discovered,
                   int[] departure, int time)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // set the arrival time of vertex `v`
        time++;
 
        // do for every edge (v, u)
        for (int u: graph.adjList.get(v))
        {
            // if `u` is not yet discovered
            if (!discovered[u]) {
                time = DFS(graph, u, discovered, departure, time);
            }
        }
 
        // ready to backtrack
        // set departure time of vertex `v`
        departure[time] = v;
        time++;
 
        return time;
    }
 
    // Function to perform a topological sort on a given DAG
    public static void doTopologicalSort(Graph9 graph, int n)
    {
        // departure[] stores the vertex number using departure time as an index
        int[] departure = new int[2*n];
        Arrays.fill(departure, -1);
 
        /* If we had done it the other way around, i.e., fill the array
           with departure time using vertex number as an index, we would
           need to sort it later */
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
        int time = 0;
 
        // perform DFS on all undiscovered vertices
        for (int i = 0; i < n; i++)
        {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, departure, time);
            }
        }
 
        // Print the vertices in order of their decreasing
        // departure time in DFS, i.e., in topological order
        for (int i = 2*n - 1; i >= 0; i--)
        {
            if (departure[i] != -1) {
                System.out.print(departure[i] + " ");
            }
        }
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge9> edges = Arrays.asList(
                new Edge9(0, 6), new Edge9(1, 2), new Edge9(1, 4),
                new Edge9(1, 6), new Edge9(3, 0), new Edge9(3, 4),
                new Edge9(5, 1), new Edge9(7, 0), new Edge9(7, 1)
        );
 
        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;
 
        // build a graph from the given edges
        Graph9 graph = new Graph9(edges, n);
 
        // perform topological sort
        doTopologicalSort(graph, n);
    }

}




//A class to store a graph edge
class Edge9
{
 int source, dest;

 public Edge9(int source, int dest)
 {
     this.source = source;
     this.dest = dest;
 }
}

//A class to represent a graph object
class Graph9
{
 // A list of lists to represent an adjacency list
 List<List<Integer>> adjList = null;

 // Constructor
 Graph9(List<Edge9> edges, int n)
 {
     // allocate memory
     adjList = new ArrayList<>();
     for (int i = 0; i < n; i++) {
         adjList.add(new ArrayList<>());
     }

     // add edges to the directed graph
     for (Edge9 edge: edges)
     {
         int src = edge.source;
         int dest = edge.dest;

         // add an edge from source to destination
         adjList.get(src).add(dest);
     }
 }
}

