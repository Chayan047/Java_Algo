package cs.dsa.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 
 * 
 *  Given a directed graph and two vertices (say source and destination vertex), 
 *  determine if the destination vertex is reachable from the source vertex or not. If a path exists from the source vertex to the destination vertex, print it.
 * 
 * @author csardar
 *
 */


class Edge1
{
 public final int source, dest;

 private Edge1(int source, int dest)
 {
     this.source = source;
     this.dest = dest;
 }

 // Factory method for creating an immutable instance of `Edge`
 public static Edge1 of(int a, int b) {
     return new Edge1(a, b);        // calls private constructor
 }
}

//A class to represent a graph object
class Graph1
{
 // A list of lists to represent an adjacency list
 List<List<Integer>> adjList = null;

 // Constructor
 Graph1(List<Edge1> edges, int n)
 {
     adjList = new ArrayList<>();

     for (int i = 0; i < n; i++) {
         adjList.add(new ArrayList<>());
     }

     // add edges to the directed graph
     for (Edge1 edge: edges) {
         adjList.get(edge.source).add(edge.dest);
     }
 }
 
}


public class FindPathBtwVertices {

	// Function to perform BFS traversal from a given source vertex in a graph to
    // determine if a destination vertex is reachable from the source or not
    public static boolean isReachable(Graph1 graph, int src, int dest)
    {
        // get the total number of nodes in the graph
        int n = graph.adjList.size();
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
 
        // create a queue for doing BFS
        Queue<Integer> q = new ArrayDeque<>();
 
        // mark the source vertex as discovered
        discovered[src] = true;
 
        // enqueue source vertex
        q.add(src);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node and print it
            int v = q.poll();
 
            // if destination vertex is found
            if (v == dest) {
                return true;
            }
 
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
 
        return false;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge1> edges = Arrays.asList(Edge1.of(0, 3), Edge1.of(1, 0),
                                Edge1.of(1, 2), Edge1.of(1, 4), Edge1.of(2, 7),
                                Edge1.of(3, 4), Edge1.of(3, 5), Edge1.of(4, 3),
                                Edge1.of(4, 6), Edge1.of(5, 6), Edge1.of(6, 7));
 
        // total number of nodes in the graph (labeled from 0 to 7)
        int n = 8;
 
        // build a graph from the given edges
        Graph1 graph = new Graph1(edges, n);
 
        // source and destination vertex
        int src = 0, dest = 7;
 
        // perform BFS traversal from the source vertex to check the connectivity
        if (isReachable(graph, src, dest)) {
            System.out.println("Path exists from vertex " + src + " to vertex " + dest);
        }
        else {
            System.out.println("No path exists between vertices " + src +
                    " and " + dest);
        }
    }
}
