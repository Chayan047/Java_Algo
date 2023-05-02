package cs.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

	// Perform DFS on the graph and set the departure time of all
    // vertices of the graph
    private static int DFS(Graph8 graph, int v, boolean[] discovered,
                           int[] departure, int time)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // set arrival time – not needed
        // time++;
 
        // do for every edge (v, u)
        for (Edge8 edge: graph.adjList.get(v))
        {
            int u = edge.dest;
 
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
 
    // The function performs the topological sort on a given DAG and then finds
    // the longest distance of all vertices from a given source by running one pass
    // of the Bellman–Ford algorithm on edges or vertices in topological order
    public static void findShortestDistance(Graph8 graph, int source, int n)
    {
        // departure[] stores the vertex number using departure time as an index
        int[] departure = new int[n];
        Arrays.fill(departure, -1);
 
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
 
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
 
        cost[source] = 0;
 
        // Process the vertices in topological order, i.e., in order
        // of their decreasing departure time in DFS
        for (int i = n - 1; i >= 0; i--)
        {
            // for each vertex in topological order,
            // relax the cost of its adjacent vertices
            int v = departure[i];
            for (Edge8 e: graph.adjList.get(v))
            {
                // edge `e` from `v` to `u` having weight `w`
                int u = e.dest;
                int w = e.weight;
 
                // if the distance to destination `u` can be shortened by
                // taking edge (v, u), update cost to the new lower value
                if (cost[v] != Integer.MAX_VALUE && cost[v] + w < cost[u]) {
                    cost[u] = cost[v] + w;
                }
            }
        }
 
        // print shortest paths
        for (int i = 0; i < n; i++) {
            System.out.printf("dist(%d, %d) = %2d\n", source, i, cost[i]);
        }
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge8> edges = Arrays.asList(
                new Edge8(0, 6, 2), new Edge8(1, 2, -4), new Edge8(1, 4, 1),
                new Edge8(1, 6, 8), new Edge8(3, 0, 3), new Edge8(3, 4, 5),
                new Edge8(5, 1, 2), new Edge8(7, 0, 6), new Edge8(7, 1, -1),
                new Edge8(7, 3, 4), new Edge8(7, 5, -4)
        );
 
        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;
 
        // build a graph from the given edges
        Graph8 graph = new Graph8(edges, n);
 
        // source vertex
        int source = 7;
 
        // find the shortest distance of all vertices from the given source
        findShortestDistance(graph, source, n);
    }
}



//A class to store a graph edge
class Edge8
{
 int source, dest, weight;

 public Edge8(int source, int dest, int weight)
 {
     this.source = source;
     this.dest = dest;
     this.weight = weight;
 }
}

//A class to represent a graph object
class Graph8
{
 // A list of lists to represent an adjacency list
 List<List<Edge8>> adjList = null;

 // Constructor
 Graph8(List<Edge8> edges, int n)
 {
     adjList = new ArrayList<>();

     for (int i = 0; i < n; i++) {
         adjList.add(new ArrayList<>());
     }

     // add edges to the directed graph
     for (Edge8 edge: edges) {
         adjList.get(edge.source).add(edge);
     }
 }
}


