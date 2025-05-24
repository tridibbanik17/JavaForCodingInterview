import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find Words Containing Character
 * Given a 0-indexed array of strings `words` and a character `x`.
 * Return a list of indices of the words that contain the character `x`.
 * The order of the returned indices does not matter.
 *
 * Example:
 * Input:  words = ["leet", "code"], x = 'e'
 * Output: [0, 1]
 */

public class FindWords {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter space-separated words: ");
        String inputLine = scanner.nextLine();
        String[] words = inputLine.trim().split("\\s+");
        System.out.print("Enter a character to search: ");
        char x = scanner.next().charAt(0); 
        List<Integer> result = findWordsContaining(words, x);
        System.out.println("Indices of words containing '" + x + "': " + result);
        scanner.close();
    }
}