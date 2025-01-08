/*
 * There are n kids with candies. 
 * Given an integer array candies, where each candies[i] represents the number of candies the ith kid has, 
 * and an integer extraCandies, denoting the number of extra candies.
 * Return a boolean array result of length n, 
 * where result[i] is true if, after giving the ith kid all the extraCandies, 
 * they will have the greatest number of candies among all the kids, or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 * Sample inputs and outputs:
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class KidsWithGreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find who has the greatest number of candies initially.
        int greatest = 0; // initialize greatest
        for (int item : candies) {
            if (item > greatest) {
                greatest = item;
            }
        }

        // Create a new Boolean ArrayList data structure.
        List<Boolean> result = new ArrayList<>();
        // initialize the index of result.
        int index = 0;
        for (int item : candies) {
            // Increment each kid's number of candies by extraCandies.
            item += extraCandies;
            // If the updated number of candies is greater or equal to the previous greatest number of candies of a student, insert true to result.
            if (item >= greatest) {
                result.add(true);
            }
            // Insert false to result, if the updated number of candies is lower than the previous greatest number of candies of a student.
            else {
                result.add(false);
            }
            // Increment of result's index after each iteration of the loop.
            index++;
        }
        // Return the Boolean ArrayList.
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user for input
            System.out.println("Enter the number of kids: ");
            int n = scanner.nextInt();

            // Exception handling for entering illegal arguments.
            if (n <= 0) {
                throw new IllegalArgumentException("Number of kids must be greater than 0.");
            }

            // Input the candies array
            System.out.println("Enter the candies for each kid (space-separated): ");
            int[] candies = new int[n];
            for (int i = 0; i < n; i++) {
                candies[i] = scanner.nextInt();
                if (candies[i] < 0) {
                    throw new IllegalArgumentException("Number of candies cannot be negative.");
                }
            }

            // Input the extraCandies
            System.out.println("Enter the number of extra candies: ");
            int extraCandies = scanner.nextInt();

            if (extraCandies < 0) {
                throw new IllegalArgumentException("Extra candies cannot be negative.");
            }

            // Create an instance of the class and call the method
            KidsWithGreatestCandies solution = new KidsWithGreatestCandies();
            List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);

            // Output the result
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}