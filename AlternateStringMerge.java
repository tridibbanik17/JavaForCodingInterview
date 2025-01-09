/*
 * Given two strings word1 and word2. 
 * Merge the strings by adding letters in alternating order, starting with word1. 
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 * Sample inputs and outputs:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 */
import java.util.Scanner;
class AlternateStringMerge {
    // Private instance variables.
    private String word1;
    private String word2;
    // Contructor method
    public AlternateStringMerge(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }
    // Getter methods
    public String getWord1() {
        return word1;
    }
    public String getWord2() {
        return word2;
    }
    // mergeAlternately() returns the merged string 
    public String mergeAlternately(String word1, String word2) {
        // Length of word 1
        int word1Len = word1.length(); 
        // Length of word 2
        int word2Len = word2.length();
        // Create a new instance of StringBuilder class.
        StringBuilder strBuild = new StringBuilder("");
        // Intialize counters.
        int countWord1 = 0;
        int countWord2 = 0;
        // The loop runs wntil all the characters of both word1 and word2 are touched.
        while ((countWord1 < word1Len) || (countWord2 < word2Len)) {
            // Append the current character of word1 to the StringBuilder object till the last character.
            if (countWord1 < word1Len) {
                strBuild.append(word1.charAt(countWord1));
                countWord1++; 
            }
            // Append the current character of word2 to the StringBuilder object till the last character.
            if (countWord2 < word2Len) {
                strBuild.append(word2.charAt(countWord2));
                countWord2++;
            }
        }
        // Return the string after converting from the stringbuilder object.
        return strBuild.toString();
    }

    public static void main(String[] args) {
        // Create a new instance of the Scanner class.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word1: ");
        // Get user input for the first word.
        String word1 = scanner.nextLine();
        System.out.println("Enter word2");
        // Get user input for the second word.
        String word2 = scanner.nextLine();
        // Create a new instance of AlternateStringMerge class.
        AlternateStringMerge obj = new AlternateStringMerge(word1, word2);
        // Call mergeAlternately() method.
        String output = obj.mergeAlternately(word1, word2);
        // Print the output string.
        System.out.println("The output string is: " + output);
    }
}