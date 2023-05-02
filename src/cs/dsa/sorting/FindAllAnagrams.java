/**
 * 
 */
package cs.dsa.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Given a set of strings, print all pairs of anagrams together. Two strings, X and Y, 
 * are called anagrams if we can get a string Y by rearranging the letters of the string X 
 * and using all the characters of the string X exactly once.

For example, the following word pairs are anagrams since we can rearrange the first 
string to get the second string and vice-versa. The problem requires the anagrams to be grouped.

 (actors, costar)
 (altered, related)
 (auctioned, education)
 (aspired, despair)
 (mastering, streaming)
 
 
 * @author csardar
 *
 */

class TrieNode
{
    // each node stores a map to its child nodes
    Map<Character, TrieNode> child = new HashMap<>();
 
    // stores anagrams in the leaf node
    String words = "";
}

public class FindAllAnagrams {

	// Function to insert a string into a Trie
    public static void insert(TrieNode root, String word, String originalWord)
    {
        // start from the root node
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            // create a new node if the path doesn't exist
            curr.child.putIfAbsent(c, new TrieNode());
 
            // go to the next node
            curr = curr.child.get(c);
        }
 
        // anagrams will end up at the same leaf node
        curr.words += originalWord + " ";
    }
 
    // A recursive function that traverses a Trie in preorder fashion and
    // prints all anagrams together
    public static void printAnagrams(TrieNode root)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // print the current word
        if (root.words.length() > 1) {
            System.out.println(root.words);
        }
 
        // recur for all child nodes
        for (TrieNode child: root.child.values()) {
            printAnagrams(child);
        }
    }
 
    // Function to group anagrams from a given list of words
    public static void groupAnagrams(String[] words)
    {
        // construct an empty trie
        TrieNode root = new TrieNode();
 
        // do for each word
        for (String word: words)
        {
            // Sort the characters of the current word and insert it into the Trie.
            // The original word gets stored in the leaf node
 
            String sorted = Stream.of(word.toCharArray())
                    .map(chars -> { Arrays.sort(chars); return new String(chars); })
                    .collect(Collectors.joining());
 
            insert(root, sorted, word);
        }
 
        // print all anagrams together
        printAnagrams(root);
    }
 
    public static void main(String[] args)
    {
        String[] words = {
                "auctioned", "actors", "altered", "streaming", "related",
                "education", "aspired", "costar", "despair", "mastering"
        };
 
        groupAnagrams(words);
    }

}
