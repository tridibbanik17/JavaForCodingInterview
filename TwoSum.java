/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * Assume that each input would have exactly one solution, and no need to use the same element twice.
 * Return the answer in any order.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
*/
import java.util.Scanner;
import java.util.Arrays;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Start with the first index to compare pairs
        int left = 1;

        // Initialize the right index to the end of the array
        int right = nums.length - 1;

        // Store the indices of the numbers that sum to the target
        int[] indArr = new int[]{0, 0};

        // Iterate through the array to find a pair that sums to the target
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                // Check if the current pair sums to the target
                if ((nums[left - 1] + nums[i]) == target) {
                    indArr[0] = left - 1; // Store the first index
                    indArr[1] = i;       // Store the second index
                    return indArr;       // Return the indices as the solution
                }
            }
            left++; // Move the left pointer to explore new pairs
        }

        return indArr; // Return an empty result if no pair is found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input in a format like {1, 2, 3}
        System.out.println("Enter the int array: (e.g., {1, 2, 3})");

        // Read the input and process it into a usable array
        String numsStr = scanner.nextLine();
        String[] str = numsStr.replaceAll("[{}\\s]", "").split(",");
        int nums[] = new int[str.length];

        // Convert the input string elements to integers
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        // Prompt for the target integer
        System.out.println("Enter the target integer: ");
        int target = scanner.nextInt();

        // Call the twoSum method to find indices of numbers summing to target
        int[] result = twoSum(nums, target);

        // Display the result as a formatted string
        System.out.println("The indices of the numbers that sum to the target are: " + Arrays.toString(result));

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
