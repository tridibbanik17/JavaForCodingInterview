import java.util.Scanner;

class BinarySearch {
    /* Given an array of integers nums which is sorted in ascending order, and an integer target,
     * search function searches for target in nums array. 
     * If target exists, then its index is returned. Otherwise, -1 is returned.
     */
    public int search(int[] nums, int target) {
        // Initialize the pointer to the leftmost index of nums[].
        int left = 0;
        // Initialize the pointer to the rightmost index of nums[].
        int right = nums.length - 1;

        while (left <= right) {
            // Calculate the middle index.
            int index = left + (right - left) / 2;

            // If the target is found, return the index.
            if (nums[index] == target) {
                return index;
            }

            // If the target is greater, ignore the left half.
            if (nums[index] < target) {
                left = index + 1;
            }
            // If the target is smaller, ignore the right half.
            else {
                right = index - 1;
            }
        }
        // If the target value is not found in nums[], return -1.
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sorted array
        System.out.println("Enter the sorted integer array in the format {1, 2, 3}: ");
        String input = scanner.nextLine();

        // Remove the curly braces and trim extra spaces
        input = input.replaceAll("[{}\\s]", "");

        // Split the input string by commas
        String[] strArray = input.split(",");

        // Convert the split strings into integers
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }

        // Input target value
        System.out.println("Enter the target value: ");
        int target = scanner.nextInt();

        // Create an instance of BinarySearch and call the search function
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(nums, target);

        // Print the result
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }

        scanner.close();
    }
}
