/**
 * 
 */
package cs.dsa.sorting;

/**
 * Given a string, find all lexicographically next permutations of it.

The words are arranged in the same order in the lexicographic order as they are presumed to appear in a dictionary. For example, the lexicographically next permutation
 of string ABCD is ABDC, for string ABDC is ACBD, and for string ACBD is ACDB
 * @author csardar
 *
 */
public class FindNextLexString {

	private static void swap(char[] chars, int i, int j)
    {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
 
    private static void reverse(char[] chars, int start)
    {
        for (int i = start, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }
 
    // Function to find lexicographically next permutations of a string.
    // It returns true if the string could be rearranged as a lexicographically
    // greater permutation; otherwise, it returns false.
    public static boolean next_permutation(char[] chars)
    {
        // find the largest index `i` such that `chars[i-1]` is less than `chars[i]`
        int i = chars.length - 1;
        while (chars[i - 1] >= chars[i])
        {
            // if `i` is the first index of the string, that means we are already
            // at the highest possible permutation, i.e., the string is sorted in
            // descending order
            if (--i == 0) {
                return false;
            }
        }
 
        /*
            if we reach here, the substring `chars[i…n)` is sorted in descending order
            i.e., chars[i-1] < chars[i] >= chars[i+1] >= chars[i+2] >= … >= chars[n-1]
        */
 
        // find the highest index `j` to the right of index `i` such that
        // chars[j] > chars[i-1]
        int j = chars.length - 1;
        while (j > i && chars[j] <= chars[i - 1]) {
            j--;
        }
 
        // swap character at index `i-1` with index `j`
        swap(chars, i - 1, j);
 
        // reverse substring `chars[i…n)` and return true
        reverse(chars, i);
 
        return true;
    }
 
    // Function to find all lexicographically next permutations of a string
    public static void permutations(String str)
    {
        // base case
        if (str == null || str.length() == 0) {
            return;
        }
 
        // base case
        if (str.length() == 1) {
            System.out.print(str);
            return;
        }
 
        // convert the string to a char array
        char[] chars = str.toCharArray();
 
        while (true)
        {
            // print the current permutation
            System.out.print(new String(chars) + " ");
 
            // find the next lexicographically ordered permutation
            if (!next_permutation(chars)) {
                break;
            }
        }
    }
 
    public static void main(String[] args)
    {
        String str = "BADC";
        permutations(str);
    }

}
