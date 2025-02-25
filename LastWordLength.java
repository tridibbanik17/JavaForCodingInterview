import java.util.Scanner;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        // Trim whitespace from both ends of the string
        String trimmedString = s.trim();
        
        int count = 0;
        
        // Loop from the end of the string until a space is found
        for (int i = trimmedString.length() - 1; i >= 0; i--) {
            if (trimmedString.charAt(i) == ' ') {
                break; // Stop when the first space from the right is found
            }
            count++; // Increment count for each character in the last word
        }
        
        return count; // Return the length of the last word
    }

    public static void main(String[] args) {
        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine(); // Read the entire line of input
        
        // Create an instance of LastWordLength
        LastWordLength solution = new LastWordLength();
        
        // Get and print the length of the last word
        int length = solution.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + length);
        
        // Close the scanner
        scanner.close();
    }
}
