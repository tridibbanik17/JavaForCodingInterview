
/**
 * This program converts a list of strings representing a maze into a 2D character array.
 * Each cell in the 2D array contains either a '#' or an empty space.
 * If a row in the list is shorter than the longest row, it is padded with empty spaces.
 *
 * Sample Input as a List<String>:
 * ########
 *   ######
 * # ######
 * #     ##
 * ####  ##
 * #####
 * ########
 *
 * Sample Output as a 2D character array:
 * ########
 *   ######
 * # ######
 * #     ##
 * ####  ##
 * #####   
 * ########
 */

import java.util.ArrayList;
import java.util.List;

public class ListTo2DArrayConverter {

    public static char[][] convertTo2DArray(List<String> lines) {
        // Find the maximum length of the lines
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        // Create the 2D array with the appropriate size
        char[][] mazeArray = new char[lines.size()][maxLength];

        // Fill the 2D array with characters from the lines
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < maxLength; j++) {
                if (j < line.length()) {
                    mazeArray[i][j] = line.charAt(j);
                } else {
                    mazeArray[i][j] = ' ';  // Fill with empty space if the line is shorter
                }
            }
        }

        return mazeArray;
    }

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("########");
        lines.add("  ######");
        lines.add("# ######");
        lines.add("#     ##");
        lines.add("####  ##");
        lines.add("#####");
        lines.add("########");

        char[][] mazeArray = convertTo2DArray(lines);

        // Print the 2D array to verify the result
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
                System.out.print(mazeArray[i][j]);
            }
            System.out.println();
        }
    }
}