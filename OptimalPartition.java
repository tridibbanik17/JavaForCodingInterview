/**
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
 * Return the minimum number of substrings in such a partition.
 * Note that each character should belong to exactly one substring in a partition.
 *
 * Sample input and output:
 *
 * Example 1:
 * Input: s = "abacaba"
 * Output: 4
 * Explanation:
 * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
 * It can be shown that 4 is the minimum number of substrings needed.
 * 
 * Example 2:
 * Input: s = "ssssss"
 * Output: 6
 * Explanation:
 * The only valid partition is ("s","s","s","s","s","s").
 */

import java.util.Scanner;
class OptimalPartition {
    public static int partitionString(String s) {
        // Raise Exception if a string is empty.
        if (s.length() == 0) {
            throw new IllegalArgumentException("Empty string is not accepted.");
        }
        // count is initialized at 1 because there must be at least 1 partition for a non-empty string.
        int count = 1;
        // Point to the first character of the current substring.
        int current = 0;
        // Iterate through each character in the string starting from the second character.
        for (int i = 1; i < s.length(); i++) {
            // Iterate through each character of the current substring
            for (int j = current; j < i; j++) {
                // If a duplicate character is found in the same substring, it indicates the end of the current substring.
                if (s.charAt(i) == s.charAt(j)) {
                    current = i;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string needed to be partitioned: ");
        String input = scanner.nextLine();
        System.out.println("The minimum number of substrings in the partition is " + partitionString(input) + ".");
    }
}