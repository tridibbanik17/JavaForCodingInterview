import java.util.Arrays;

// This Java program removes duplicates from a sorted array.
// It ensures that each integer occurs only once in the array.
// If there are k unique elements after removing duplicates, the program returns k.

public class RemovingDuplicatesOne {
    /**
     * Removes duplicates from the sorted array `nums` and returns the count of unique elements.
     *
     * @param nums The input sorted array of integers.
     * @return The number of unique elements after removing duplicates.
     */
    public int duplicateEraser(int[] nums) {
        // If the array is empty, return 0 as there are no elements.
        if (nums.length == 0)
            return 0;

        // `left` is the pointer for the position where the next unique element will be placed.
        int left = 1;

        // Traverse the array using the `right` pointer.
        for (int right = 1; right < nums.length; right++) {
            // If the current element is different from the previous unique element,
            // place it at the `left` pointer and move the `left` pointer forward.
            if (nums[right] != nums[left - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }

        // Return the count of unique elements, which is equal to the value of `left`.
        return left;
    }
    public static void main(String[] args) {
        // Create an instance of RemovingDuplicatesOne.
        RemovingDuplicatesOne newObj = new RemovingDuplicatesOne();

        // Define the input sorted integer array.
        int[] inputArray = {1, 1, 1, 2, 2, 3, 3, 3};

        // Print the input array.
        System.out.println("The input integer array is " + Arrays.toString(inputArray));

        // Call the duplicateEraser method and print the count of unique elements.
        System.out.println("The number of elements after removing the duplicates is " 
                           + newObj.duplicateEraser(inputArray) + ".");
    }
}
