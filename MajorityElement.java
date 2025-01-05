/*
 * Given an int array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
 * Assume that the majority element always exists in the array.
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */

class MajorityElement {
    public int majorityElement(int[] nums) {
        // Step 1: Initialize variables
        // `candidate` stores the current candidate for the majority element.
        // `count` keeps track of the balance between occurrences of the candidate and other elements.
        int candidate = nums[0];
        int count = 0;

        // Step 2: Iterate through the array to find the majority candidate
        for (int num : nums) {
            // If count reaches zero, we select a new candidate.
            if (count == 0) {
                candidate = num;
            }

            // If the current number matches the candidate, increment the count.
            // Otherwise, decrement the count.
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 3: Return the majority candidate
        // The problem guarantees that a majority element always exists, so no verification is needed.
        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 2, 3};
        // Input array is [3, 2, 3]. The majority element is 3 as it appears more than n/2 times.
        System.out.println("Majority Element: " + solution.majorityElement(nums1)); // Output: 3

        // Example 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        // Input array is [2, 2, 1, 1, 1, 2, 2]. The majority element is 2.
        System.out.println("Majority Element: " + solution.majorityElement(nums2)); // Output: 2
    }
}
