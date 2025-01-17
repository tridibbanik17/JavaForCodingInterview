/* Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Sample input and output:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
import java.util.Scanner;
class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // The length of the array strs
        int size = strs.length;
        // New StringBuilder to contain the extracted common prefixes
        StringBuilder build = new StringBuilder("");
        // initialize smallest considering strs[0] as the reference string
        int smallest = strs[0].length();
        
        for (String s : strs) {
            // Find the string with smallest length to avoid index out of range error.
            if (s.length() < smallest) {
                smallest = s.length();
            }
        }

        // Loop through each character of each string
        for (int i = 0; i < smallest; i++) {
            // Initialize count
            int count = 1;
            // Consider the first string as a reference string and match other string with this reference one 
            for (int j = 1; j < size; j++) {
                // Match if all the string's ith character is equal to each other. If so, increment the count by 1.
                if (strs[j].charAt(i) == strs[0].charAt(i)) {
                    count++;
                }             
            }

            // If all strings have the common character at ith position, append that character to the StringBuilder instance.
            if (count == size) {
                build.append(String.valueOf(strs[0].charAt(i)));
            }
            // The first time there are different characters at the ith position, it indicates that no more characters can be added.
            else {
                break;
            }
        }
        // Convert the StringBuilder instance to a string and return it.
        return build.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of strings in the array:");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the strings one by one: ");
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = scanner.nextLine();
        }
        System.out.println("The longest common prefix is: " + longestCommonPrefix(strArr));
    }
}