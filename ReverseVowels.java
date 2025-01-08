/* Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * Sample input and output:
 * Input: s = "IceCreAm"
 * Output: "AceCreIm"
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ReverseVowels {
    // Method to reverse only the vowels in the input string
    public String reverseVowels(String s) {
        // Convert the input string to a character array to work with individual characters
        int len = s.length();
        char[] charArr = s.toCharArray();
        
        // Create a copy of the original array to store the updated vowel positions
        char[] updatedArr = Arrays.copyOf(charArr, charArr.length);

        // Mark vowels in charArr with a temporary placeholder ('~')
        for (int item = 0; item < len; item++) {
            if ((charArr[item] == 'a') || (charArr[item] == 'e') || (charArr[item] == 'i') || (charArr[item] == 'o') || (charArr[item] == 'u') || (charArr[item] == 'A') || (charArr[item] == 'E') || (charArr[item] == 'I') || (charArr[item] == 'O') || (charArr[item] == 'U')) {
                charArr[item] = '~'; // Mark the vowels with '~'
            }
        }

        // Create a list to store the indices of the vowels
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (charArr[i] == '~') {
                indexList.add(i); // Add index of vowels
            }
        }

        // Reverse the list of indices to swap vowels later
        ArrayList<Integer> revIndex = new ArrayList<>();
        int left = 0;
        int right = indexList.size() - 1;
        
        // Reverse the indices of vowels
        for (int a = 0; a < indexList.size(); a++) {
            revIndex.add(left);
            revIndex.set(left, indexList.get(right));
            left++;
            right--;
        }

        // Replace the vowels in the charArr using the reversed indices
        int count = 0;
        for (int j = 0; j < len; j++) {
            if (charArr[j] == '~') {
                charArr[j] = updatedArr[revIndex.get(count)]; // Replace vowel with the reversed vowel
                count++;
            }
        }

        // Convert the character array back to a string and return the result
        StringBuilder resultBuild = new StringBuilder("");
        for (char item : charArr) {
            resultBuild.append(item); // Build the resulting string
        }

        return resultBuild.toString(); // Return the final string with reversed vowels
    }

    // Main method to test the reverseVowels method
    public static void main(String[] args) {
        ReverseVowels solution = new ReverseVowels();
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String scanner = scannerObj.nextLine();
        int vowelCount = 0;
        for (int i = 0; i < scanner.length(); i++) {
            if ((scanner.charAt(i) == 'A') || (scanner.charAt(i) == 'E') || (scanner.charAt(i) == 'I') || (scanner.charAt(i) == 'O') || (scanner.charAt(i) == 'U') || (scanner.charAt(i) == 'a') || (scanner.charAt(i) == 'e') || (scanner.charAt(i) == 'i') || (scanner.charAt(i) == 'o') || (scanner.charAt(i) == 'u')) {
                vowelCount++;
            }
        }
        if ((vowelCount == 0) || (vowelCount == 1)) {
            throw new IllegalArgumentException("There must be at least two vowels to demonstrate reverse vowels.");
        }

        System.out.println(solution.reverseVowels(scanner));
        // System.out.println(solution.reverseVowels("IceCreAm")); // Output: "AceCreIm"
        // System.out.println(solution.reverseVowels("leetcode")); // Output: "leotcede"
        // System.out.println(solution.reverseVowels("hello")); // Output: "holle"
        // System.out.println(solution.reverseVowels("aA")); // Output: "Aa"
    }
}
