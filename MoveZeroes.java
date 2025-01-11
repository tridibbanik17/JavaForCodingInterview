/*
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * The work must be done without creating a copy of the array.
 * Sample inputs and outputs:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 */

import java.util.Scanner;
import java.util.Arrays;
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // Initialize the index to place the next non-zero element
        int nonZeroElementIndex = 0;

        // First pass: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Place the non-zero element at the current nonZeroElementIndex
                nums[nonZeroElementIndex] = nums[i];
                // Increment the index for the next non-zero element
                nonZeroElementIndex++;
            }
        }

        // Initialize the index for the last element in the array
        int lastElementIndex = nums.length - 1;
        // Calculate the number of zeros to be placed at the end
        int count = lastElementIndex - nonZeroElementIndex + 1;

        // Second pass: Fill the remaining positions with zeros
        while (count != 0) {
            // Place zero at the current lastElementIndex
            nums[lastElementIndex] = 0;
            // Decrement the index for the next zero
            lastElementIndex--;
            // Decrement the count of zeros to be placed
            count--;
        }
    }

    public static void main(String[] args) {
        // Scanner object
        Scanner scanner = new Scanner(System.in);
        // Example usage of the moveZeroes method
        MoveZeroes obj = new MoveZeroes();
        System.out.println("Enter the number of elements in the array: ");
        int numOfElements = scanner.nextInt();
        System.out.println("Enter the elements one-by-one: ");
        int[] nums = new int[numOfElements];
        for (int i = 0; i < numOfElements; i++) {
            nums[i] = scanner.nextInt();
        }
        // Calling the moveZeros() method modifies the int[] nums.
        obj.moveZeroes(nums);
        // Print the modified array nums.
        System.out.println("Modified array: " + Arrays.toString(nums));
    }
}