/* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 
 * Sample inputs and outputs:
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 */
import java.util.Scanner;
class SingleNumber {

    // Method to find the single number that appears only once
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0; // Count occurrences of the current number
            
            // Iterate through the array to count occurrences of nums[i]
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    if (count == 2) { // If number appears twice, no need to continue
                        break;
                    }
                }
            }
            
            // If the number appears only once, return it
            if (count == 1) {
                return nums[i];
            }
        }
        return -1; // Return -1 if no single number is found
    }

    // Main method to get user input and display the single number
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object
        SingleNumber sn = new SingleNumber(); // Create instance of SingleNumber

        // Ask user for array length
        System.out.print("Enter the number of elements in the array: ");
        int length = scanner.nextInt(); // Read array length

        int[] nums = new int[length]; // Create array with user-specified length

        // Ask user to input each element one by one
        System.out.println("Enter the elements of the array (each separated by Enter):");
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt(); // Read each number into the array
        }

        // Call singleNumber method and print the result
        int result = sn.singleNumber(nums);
        if (result != -1) {
            System.out.println("The single number is: " + result);
        } else {
            System.out.println("No single number found.");
        }

        scanner.close(); // Close the scanner to prevent resource leak
    }
}
