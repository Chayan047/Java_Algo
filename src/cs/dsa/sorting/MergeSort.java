package cs.dsa.sorting;
/**
 * 
 * 
 *  
 * 
 * @author csardar
 *
 */
public class MergeSort {

	public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 
    // Takes two lists sorted in increasing order and merge their nodes
    // to make one big sorted list, which is returned
    public static Node sortedMerge(Node a, Node b)
    {
        // base cases
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }
 
        Node result;
 
        // pick either `a` or `b`, and recur
        if (a.data <= b.data)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
 
        return result;
    }
 
    /*
        Split the given list's nodes into front and back halves,
        If the length is odd, the extra node should go in the front list.
        It uses the fast/slow pointer strategy
    */
    public static Node[] frontBackSplit(Node source)
    {
        // if the length is less than 2, handle it separately
        if (source == null || source.next == null) {
            return new Node[]{ source, null };
        }
 
        Node slow = source;
        Node fast = source.next;
 
        // advance `fast` two nodes, and advance `slow` one node
        while (fast != null)
        {
            fast = fast.next;
            if (fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
 
        // `slow` is before the midpoint in the list, so split it in two
        // at that point.
        Node[] arr = new Node[]{ source, slow.next };
        slow.next = null;
 
        return arr;
    }
 
    // Sort a given linked list using the merge sort algorithm
    public static Node mergesort(Node head)
    {
        // base case — length 0 or 1
        if (head == null || head.next == null) {
            return head;
        }
 
        // split `head` into `a` and `b` sublists
        Node[] arr = frontBackSplit(head);
        Node front = arr[0];
        Node back = arr[1];
 
        // recursively sort the sublists
        front = mergesort(front);
        back = mergesort(back);
 
        // answer = merge the two sorted lists
        return sortedMerge(front, back);
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 8, 6, 4, 9, 3, 1 };
 
        Node head = null;
        for (int key: keys) {
            head = new Node(key, head);
        }
 
        // sort the list
        head = mergesort(head);
 
        // print the sorted list
        printList(head);
    }

}

class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
